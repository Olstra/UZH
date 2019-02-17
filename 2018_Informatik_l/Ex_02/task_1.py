# Please do not modify this part of the code!
price_banana = 1.5
price_milk = 2.0
number_of_bananas_purchased = 4
number_of_milks_purchased = 3

# Your code goes here
# 1. Get promotion percentage
promotion_percentage = int(input("What is your coupon percentage?: "))

# 2. Calculate the subtotal price of the purchase
subtotal_price = number_of_bananas_purchased * price_banana + number_of_milks_purchased * price_milk

# 3. Print a message showing the subtotal price of the purchase.
print("The subtotal of your purchase is: ", subtotal_price)

# 4. Calculate the amount the customer saves
savings = subtotal_price * (promotion_percentage/100)

# 5. Print a message showing the savings the customer makes
print("Your savings are: ", savings)

# 6. Calculate the total price of the purchase and store it
total_price = subtotal_price - savings

# 7. Print a message showing the total price of the purchase
print("The total price of your purchase is: ", round(total_price, 2))


