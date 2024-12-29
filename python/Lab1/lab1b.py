# author:   Lindokuhle Dubazana
# partner1: Rethabile Sitole
# partner2: Nkululeko Banda

print("Enter your first name:")
first_name = input()                # Allow user to enter their name
print("Hello", first_name)

x = 5                                   # Assign variable x to integer value 5
y = 10                                  # Assign variable y to integer value 10
total = x + y                           # Assign total to the sum of the two integers x and y
print("Total:", x, "+", y, "=", total)

a = 10.5                                # Assign variable a to float value 10.5
b = 4.0                                 # Assign variable b to float value 4.0
product = a * b                         # Assign the product to value of a multiplied by b
print("Product:", a, "*", b, "=", product)

# the difference between product and total
print("the difference:", int(product) - total)  # the output difference would be a float

print("This program is done.", end="")
