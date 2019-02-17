"""
   Informatik 1, HS2018, Oliver Strassmann
   Exercise 8, 14.11.2018
"""


class UniPerson:
    def __init__(self, name):
        self._name = name
        self.__inbox = []

    def access_inbox(self):
        return self._UniPerson__inbox

    def receive_email(self, text):
        inbox = self.access_inbox()
        inbox.append(text)

    def read_emails(self):
        mails = self.access_inbox()
        self._UniPerson__inbox = []

        return mails

    def __str__(self):
        name = self._name
        return "Name: {}".format(name)


class Student(UniPerson):
    students_count = {}

    def __init__(self, name, start_year, has_graduated, ects):
        super(Student, self).__init__(name)
        self.has_graduated = has_graduated
        self.start_year = start_year
        self.__ects = ects
        self.__legi_nr = self.create_legi_nr()

    def __str__(self):
        name = self._name
        legi = self._Student__legi_nr
        graduated = self.has_graduated
        ects = self._Student__ects

        return "Name {} - legi {} - Graduated? {} - ECTS {}".format(name, legi, graduated, ects)

    def create_legi_nr(self):
        year = self.start_year
        nr = 0

        if year in self.students_count:
            self.students_count[year] += 1
            nr = self.students_count[year]
        else:
            self.students_count[year] = nr

        nr = str(nr).zfill(5)
        legi = "{}-{}".format(year, nr)
        return legi


class Lecturer(UniPerson):
    def __init__(self, name, lecture_name):
        super().__init__(name)
        self.__lecture_name = lecture_name

    def __str__(self):
        name = self._name
        vl = self._Lecturer__lecture_name

        return "Name: {} - Lecture: {}".format(name, vl)


class UniManagement:
    def __init__(self):
        self.__persons = []

    def get_persons(self):
        persons = self._UniManagement__persons
        return persons

    def add_person(self, person):
        # TODO check if is instance of "UniPerson"
        if person:
            persons = self.get_persons()
            persons.append(person)
        else:
            print("Person couldn't be added to the list.")

    def list_persons(self):
        persons = self.get_persons()

    def send_email(self, text):
        for person in self.get_persons():
            person.receive_email(text)

    def count_alumni(self):
        alumni = 0
        for person in self.get_persons():
            if isinstance(person, Student):
                if person.has_graduated:
                    alumni += 1
        return alumni


if __name__ == '__main__':
    p1 = UniPerson("Hans Muster")
    assert p1.__str__() == "Name: Hans Muster"

    p1.receive_email("Email 1")
    p1.receive_email("Email 2")
    assert p1.read_emails() == ["Email 1", "Email 2"]
    assert p1.read_emails() == []  # Because inbox was emptied after reading the first time

    s1 = Student("Student 1", 2017, False, 40)
    assert "Student 1" in s1.__str__()
    assert "2017-00000" in s1.__str__()
    assert "False" in s1.__str__()
    assert "40" in s1.__str__()

    s2 = Student("Student 2", 2017, True, 120)
    assert "Student 2" in s2.__str__()
    assert "2017-00001" in s2.__str__()
    assert "True" in s2.__str__()
    assert "120" in s2.__str__()

    s3 = Student("Student 3", 2016, True, 180)
    assert "Student 3" in s3.__str__()
    assert "2016-00000" in s3.__str__()
    assert "True" in s3.__str__()
    assert "180" in s3.__str__()

    mgmt = UniManagement()

    lecturer = Lecturer("Prof. Dr. Harald Gall", "Informatik 1")

    mgmt.add_person(s1)
    mgmt.add_person(s2)
    mgmt.add_person(s3)
    mgmt.add_person(lecturer)

    assert mgmt.count_alumni() == 2

    mgmt.send_email("This test email is sent to all university persons.")
    assert s1.read_emails() == ["This test email is sent to all university persons."]
    assert s2.read_emails() == ["This test email is sent to all university persons."]
    assert s3.read_emails() == ["This test email is sent to all university persons."]
    assert lecturer.read_emails() == ["This test email is sent to all university persons."]

