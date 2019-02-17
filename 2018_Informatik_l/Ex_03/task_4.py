is_prime = True

n = int(input("Please enter a positive integer: "))

if n <= 1:
    is_prime = False
elif n % 2 == 0:
    is_prime = False
else:
    for factor in range(3, n, 2):
        if n % factor == 0:
            is_prime = False
            break

print("Is prime: ", is_prime)