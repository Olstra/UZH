"""
   Task 1, Assignment 07, Informatik 1, UZH
   Oliver Strassmann
   Nov 2018
"""


class Password(object):

    def __init__(self, name, username, password):
        self.__name = name
        self.__username = username
        self.__password = password

    def pretty_str_password(self):
        # TODO check for None "name" etc
        return "{}: {} / {}".format(self._Password__name, self._Password__username, self._Password__password)

    def __str__(self):
        # TODO check if None
        asterisked = ""
        for char in self._Password__password:
            asterisked += "*"
        ugly_pw = "{}: {} / {}".format(self._Password__name, self._Password__username, asterisked)
        return ugly_pw


class PasswordManager(object):

    def __init__(self, master_password):
        self.__master_password = master_password
        self.__passwords = {}
        self.unlocked = False

    def lock(self):
        self.unlocked = False

    def unlock(self, master_password):
        if self._PasswordManager__master_password == master_password:
            self.unlocked = True
            return True
        return False

    def create_new_password(self, name, username, password):
        if self.unlocked:
            if name not in self._PasswordManager__passwords:
                self._PasswordManager__passwords[name] = Password(name, username, password)
                return self._PasswordManager__passwords[name]
        return None

    def update_password(self, name, username, password):
        if self.unlocked:
            if name in self._PasswordManager__passwords:
                self._PasswordManager__passwords[name]._Password__username = username
                self._PasswordManager__passwords[name]._Password__password = password
                return self._PasswordManager__passwords[name]
        return None

    def get_password(self, name):
        if self.unlocked:
            if name in self._PasswordManager__passwords:
                return self._PasswordManager__passwords[name]
        return None

    def list_passwords(self):
        pw_list = []

        if self.unlocked:
            for pw in self._PasswordManager__passwords:
                pw_list.append(self._PasswordManager__passwords[pw].pretty_str_password())
        else:
            for pw in self._PasswordManager__passwords:
                new = str(self._PasswordManager__passwords[pw])
                pw_list.append(new)

        return pw_list


if __name__ == '__main__':
    manager = PasswordManager("abc")  # Create a new password manager
    manager.unlock("abc")  # Unlock it with the master password

    # Create new passwords
    manager.create_new_password("pw1", "user1", "aaa")
    manager.create_new_password("pw2", "user2", "bbb")

    print(manager.list_passwords())  # Prints the passwords in plain text
    manager.lock()  # Lock the password manager
