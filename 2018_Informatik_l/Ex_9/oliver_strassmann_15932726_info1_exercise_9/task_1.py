"""
    Informatik I, HS 2018
    Oliver Strassmann, 23. Nov
    Exercise 9, task 1
"""

from abc import ABC, abstractmethod
import csv


class CarWash(object):

    def __init__(self, persistence, notifier):
        self.persistence = persistence
        self.notifier = notifier

    def register_car_for_wash(self, car, customer):
        job = self.persistence.save(CarWashJob(car, customer))
        return job.job_id

    def complete_wash(self, job_id):
        job = self.persistence.find_by_id(job_id)
        self.sms_sender.send(job.contact_details, job.notification_message)


class CarWashJob:
    """ This class should wrap the customer and car objects and the job_id """
    job_counter = 0

    def __init__(self, car, customer, job_id=None):
        self.customer = customer
        self.car = car

        if job_id is None:
            self.job_id = self.new_job_id()
        else:
            self.job_id = job_id

    @property
    def contact_details(self):
        """ returns customer mobile phone number """
        phone_nr = self.customer.mobile_phone
        return phone_nr

    @property
    def notification_message(self):
        """
        creates a string exactly like the one we passed on previoulsy to sms_sender.
        I.E. Job {job_id}, Car {plate} washed
        """
        msg = "Job {}, Car {} washed.".format(self.job_id, self.car.plate)
        return msg

    def new_job_id(self):
        job_id = CarWashJob.job_counter
        CarWashJob.job_counter += 1
        return job_id

    def __repr__(self):
        r = "ID: {} Car plate: {}".format(self.job_id, self.car.plate)
        return r


class CarJobRepository(ABC):

    # def __init__(self):
    #     pass

    @abstractmethod
    def save(self, job):
        pass

    @abstractmethod
    def find_by_id(self, job_id):
        pass


class InMemoryCarJobRepository(CarJobRepository):

    def __init__(self):
        self.db = {}

    def save(self, job):
        if isinstance(job, CarWashJob):
            if job.job_id not in self.db:
                self.db[job.job_id] = job
                print("Job ID was saved successfully.")
            else:
                print("ERROR: Job ID already in db")
                return
        else:
            print("Error: got {} instead of CarWashJob".format(type(job)))

    def find_by_id(self, job_id):
        if job_id in self.db:
            return self.db[job_id]
        print("ID was not found")
        raise ValueError

    
class FileCarJobRepository(CarJobRepository):
    """ writes the entries to file upon saving and retrieves them from file when calling find_by_id. """

    def __init__(self, db_name, drop_on_startup=False):
        self.db_name = db_name
        self.create_header()
        if drop_on_startup:  # TODO check if it also drops db when given a string zbsp "x"
            self.drop_db()

    def create_header(self):
        with open(self.db_name, 'w') as db:
            header = csv.writer(db)
            columns = ["Job ID", "Customer Name", "Phone", "Car Plate"]
            header.writerow(columns)

    def save(self, job):
        info = [job.job_id, job.customer.name, job.customer.mobile_phone, job.car.plate]
        with open(self.db_name, mode="a") as db:
            writer = csv.writer(db)
            writer.writerow(info)

    def find_by_id(self, job_id):
        with open(self.db_name, "r") as db:
            for row in db:
                # job information saved in CSV format-must be converted to a CarWashJob obj at the end
                info = row.split(",")
                try:
                    if int(info[0]) == job_id:
                        info[3] = info[3][0:-1]     # create new string plate without "\n"
                        car = Car(info[3])
                        customer = Customer(info[1], info[2])
                        found_job = CarWashJob(car, customer, int(info[0]))
                        return found_job
                except ValueError:      # expected for header
                    continue

        print("ID was not found")
        raise ValueError

    def drop_db(self):
        """ Deletes the contents of the file. """
        with open(self.db_name, "w+"):
            pass


class Customer(object):

    def __init__(self, name, mobile_phone):
        self.name = name
        self.mobile_phone = mobile_phone


class Car(object):

    def __init__(self, plate):
        self.plate = plate


class Notifier(ABC):

    @abstractmethod
    def send(self):
        pass


class CallSender(Notifier):

    def __init__(self, phone_number):
        self.phone_number = phone_number
        pass

    def send(self, phone_number, msg):
        print(f'Calling {phone_number}: {msg}')


if __name__ == '__main__':

    car_wash = CarWash()

    car1 = Car('ZH 123456')
    car2 = Car('AG 654321')
    customer1 = Customer('Foo', '079 xxx xxxx')
    customer2 = Customer('Bar', '078 xxx xxxx')

    job_id1 = car_wash.register_car_for_wash(car1, customer1)
    job_id2 = car_wash.register_car_for_wash(car2, customer2)
    assert job_id1 != job_id2

    car_wash.complete_wash(job_id1)

    in_memory_db = InMemoryCarJobRepository()

    file_db = FileCarJobRepository('car-wash-db.tsv', drop_on_startup=True)

    in_memory_car_wash = CarWash(in_memory_db)

    file_db_car_wash = CarWash(file_db)
