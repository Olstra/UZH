"""
   Informatik 1, HS2018, Oliver Strassmann
   Exercise 8, 14.11.2018
"""


from abc import ABC, abstractmethod


class Aircraft(ABC):
    def __init__(self, num_of_p, name):
        self._number_of_passengers = num_of_p
        self._name = name

    def get_number_of_passengers(self):
        return self._number_of_passengers

    def get_name(self):
        return self._name

    @abstractmethod
    def calculate_amount_of_fuel(self):
        pass


class IntercontinentalAircraft(Aircraft):
    def __init__(self, num_of_p, name, cargo_hold):
        super().__init__(num_of_p, name)                # we "take" the arguments from parent class
        self.__cargo_hold = cargo_hold

    @property
    def manifest(self):
        name = self.get_name()
        passengers = self.get_number_of_passengers()
        cargo = self.get_cargo_hold()

        formatted = "Intercontinental flight {}: " \
                    "passenger count {}, cargo load {}".format(name, passengers, cargo)
        return formatted

    def get_cargo_hold(self):
        return self._IntercontinentalAircraft__cargo_hold

    def calculate_amount_of_fuel(self, km):
        nr_of_p = self.get_number_of_passengers()
        cargo = self.get_cargo_hold()

        x = 0.25 * km * nr_of_p
        y = 2 * km * cargo
        total = x + y

        return total

    # manifest = property(__str__)


class ShortHaulAircraft(Aircraft):

    serial_number = -1

    def __init__(self, num_of_p, name):
        super().__init__(num_of_p, name)
        ShortHaulAircraft.serial_number += 1
        self.serial_number = ShortHaulAircraft.serial_number

    def get_serial_number(self):
        return self.serial_number

    def calculate_amount_of_fuel(self, km):
        nr_of_passengers = self.get_number_of_passengers()
        result = 0.1 * km * nr_of_passengers
        return result

    # def __str__(self):
    #     name = self.get_name()
    #     passengers = self.get_number_of_passengers()
    #
    #     formatted = "Short haul flight serial number {}," \
    #                 " name {}: passenger count {}".format(self.serial_number, name, passengers)
    #     return formatted

    # manifest = property(__str__)

    @property
    def manifest(self):
        name = self.get_name()
        passengers = self.get_number_of_passengers()

        formatted = "Short haul flight serial number {}," \
                    " name {}: passenger count {}".format(self.serial_number, name, passengers)
        return formatted


class ControlTower:
    def __init__(self):
        self.list = []

    def add_aircraft(self, aircraft):
        self.list.append(aircraft)

    def get_manifests(self):
        result = []
        for aircraft in self.list:
            result.append(aircraft.manifest)

        return result


if __name__ == '__main__':
    intercontinental_flight = IntercontinentalAircraft(500, "Boeing-747", 100)
    short_haul_flight = ShortHaulAircraft(110, "Airbus-A220")
    short_haul_flight2 = ShortHaulAircraft(85, "Airbus-A220")

    assert short_haul_flight.get_serial_number() == 0
    assert short_haul_flight2.get_serial_number() == 1

    assert short_haul_flight.get_number_of_passengers() == 110
    assert short_haul_flight.get_name() == "Airbus-A220"

    assert intercontinental_flight.get_number_of_passengers() == 500
    assert intercontinental_flight.get_name() == "Boeing-747"

    assert intercontinental_flight.calculate_amount_of_fuel(10000) == 3250000.
    assert short_haul_flight.calculate_amount_of_fuel(250) == 2750.

    assert intercontinental_flight.manifest == "Intercontinental flight Boeing-747: passenger count 500, cargo load 100"
    assert short_haul_flight2.manifest == "Short haul flight serial number 1, name Airbus-A220: passenger count 85"

    tower = ControlTower()
    tower.add_aircraft(intercontinental_flight)
    tower.add_aircraft(short_haul_flight)
    tower.add_aircraft(short_haul_flight2)

    air_traffic_report = tower.get_manifests()
    for aircraft in air_traffic_report:
        print(aircraft)

    # prints:
    # Intercontinental flight Boeing-747: passenger count 500, cargo load 100
    # Short haul flight serial number 0, name Airbus-A220: passenger count 110
    # Short haul flight serial number 1, name Airbus-A220: passenger count 85
