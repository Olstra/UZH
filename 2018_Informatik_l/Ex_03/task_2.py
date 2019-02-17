# Please do not modify this part of the code!
result = ""

# Your code goes here
print("Choose between 'Rock', 'Paper' and 'Scissors'\n")
user_1 = input("\nUser 1: ")
user_2 = input("\nUser 2: ")

valid_input = ["Rock", "Paper", "Scissors"]

if user_1 in valid_input and user_2 in valid_input:
    if user_1 == user_2:
        result = "Tie"
    elif user_1 == "Rock":
        if user_2 == "Paper":
            result = "User 2 wins"
        else:
            result = "User 1 wins"
    elif user_1 == "Paper":
        if user_2 == "Scissors":
            result = "User 2 wins"
        else:
            result = "User 1 wins"
    else:
        if user_2 == "Rock":
            result = "User 2 wins"
        else:
            result = "User 1 wins"
else:
    result = "Wrong input"
