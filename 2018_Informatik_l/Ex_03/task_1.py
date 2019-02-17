# Please do not modify this part of the code!
grade = '-'

# Your code goes here
score = int(input("Type in your achieved score: "))

if score in range(0, 101):
    score = int(score)
    if score >= 90:
        grade = 'A'
    elif score >= 80:
        grade = 'B'
    elif score >= 70:
        grade = 'C'
    elif score >= 60:
        grade = 'D'
    else:
        grade = 'F'
else:
    print("\nERROR: Please enter a number from 0-100.")
