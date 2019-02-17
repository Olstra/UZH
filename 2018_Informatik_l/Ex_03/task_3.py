# Please do not modify this part of the code!
special_character_set = "@/%&*_-"

is_valid = False

# Your code goes here
# password = input("Type in your password: ")
password = "ke1dEEl@3"


# Counters for minimal requirements
uppercase = 0
lowercase = 0
digits = 0
special_char = 0

if len(password) in range(8, 31):
    for char in password:
        if char.isupper():
            uppercase += 1
        if char.islower():
            lowercase += 1
        if char.isdigit():
            digits += 1
        for element in special_character_set:
            if element == char:
                special_char += 1
        if not char.isalnum():
            special_char += 1
    if uppercase >= 2 and lowercase >= 2 and special_char == 1 and digits >= 1:
        is_valid = True



print("Valid? ", is_valid)