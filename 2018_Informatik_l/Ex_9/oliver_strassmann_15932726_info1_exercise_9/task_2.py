"""
    Informatik I, HS 2018
    Oliver Strassmann, 23. Nov
    Exercise 9, task 2
"""


from abc import ABC, abstractmethod


class Toy:
    def __init__(self, name):
        self.name = name
        self.is_assembled = False
        self.is_painted = False
        self.is_wrapped = False

    def is_complete(self):
        if self.is_assembled and self.is_painted and self.is_wrapped:
            return True
        return False


class AssemblyLine:

    def __init__(self, toys):
        self.__toys = toys

    def get_toys(self):
        return self.__toys

    def get_number_of_toys(self):
        return len(self.get_toys())

    def take_toy(self):
        """ removes the first toy from the assembly line (i.e., the toy at position 0 in the list) and returns it.
        If there are no toys in the assembly line, None should be returned. """
        toy = self.__toys[0]
        self.__toys.remove(self.__toys[0])
        return toy

    def put_toy_back(self, toy):
        """ adds the toy back to the assembly line (at the last position).
        Make sure it is not possible to put anything other than a toy back into the assembly line. """
        if isinstance(toy, Toy):
            self.__toys.append(toy)


class Elf(ABC):

    def __init__(self):
        self._toy_working_on = None

    @abstractmethod
    def do_job(self):
        pass

    def take_from(self, assembly_line):
        """  takes a toy from an assembly line that is passed as parameter and stores it to _toy_working_on.
        If the elf is already working on a toy, this method should do nothing """

        if self._toy_working_on is None:
            self._toy_working_on = assembly_line.take_toy()

    def put_back(self, assembly_line):
        """  puts the toy the elf was working on back into the given assembly line.
        After putting back the toy, the elf should have no reference to the toy it has worked on anymore """

        if self._toy_working_on is not None:
            assembly_line.put_toy_back(self._toy_working_on)
            self._toy_working_on = None


class AssemblerElf(Elf):

    def do_job(self):
        if self._toy_working_on is not None:
            self._toy_working_on.is_assembled = True


class PainterElf(Elf):

    def do_job(self):
        if self._toy_working_on is not None:
            self._toy_working_on.is_painted = True


class WrapperElf(Elf):

    def do_job(self):
        if self._toy_working_on is not None:
            if self._toy_working_on.is_assembled and self._toy_working_on.is_painted:
                self._toy_working_on.is_wrapped = True


class Santa:

    def verify(self, assembly_line):
        ok = True
        for toy in assembly_line.get_toys():
            if not toy.is_wrapped:
                ok = False
                break

        if ok:
            return True
        return False


if __name__ == '__main__':
    # Create three toys
    toy1 = Toy("Toy1")
    toy2 = Toy("Toy2")
    toy3 = Toy("Toy3")
    # Create an assembly line with three toys
    line = AssemblyLine([toy1, toy2, toy3])

    # Create three elves, one of each subclass
    assembler = AssemblerElf()
    painter = PainterElf()
    wrapper = WrapperElf()

    # Create a Santa :-)
    santa = Santa()

    # Let the elves work through the assembly line
    for elf in [assembler, wrapper, painter]:  # Wrong order: wrapping can't happen before painting!
        for i in range(line.get_number_of_toys()):
            elf.take_from(line)
            elf.do_job()
            elf.put_back(line)

    # The line cannot be verified because the toys are not wrapped
    assert not santa.verify(line)

    # Create three new toys...
    toy4 = Toy("Toy4")
    toy5 = Toy("Toy5")
    toy6 = Toy("Toy6")

    # ... and a new assembly line
    line2 = AssemblyLine([toy4, toy5, toy6])

    # This time, let the elves work through the assembly line in the right order
    for elf in [painter, assembler, wrapper]:  # Right order: wrap at the end!
        for i in range(line2.get_number_of_toys()):
            elf.take_from(line2)
            elf.do_job()
            elf.put_back(line2)

    # Now the line can be verified
    assert santa.verify(line2)
