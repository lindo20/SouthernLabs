import re
import os


def validate_book_order_details(order_num, title, author, isbn, year_pub, quantity, cost_cad):
    if not re.match(r"^\d+$", str(order_num)):
        raise ValueError("Order Number is invalid")

    if not re.match(r"^[a-zA-Z\s]+$", str(title)):
        raise ValueError("Title is invalid")

    if not re.match(r"^[a-zA-Z\s']*$", str(author)):
        raise ValueError("Author is invalid")

    try:
        isbn_int = int(isbn)
    except ValueError:
        raise TypeError("ISBN must be an integer")
    if not re.match(r"^\d{4,20}$", str(isbn_int)):
        raise ValueError("ISBN is invalid")

    try:
        year_pub_int = int(year_pub)
    except ValueError:
        raise TypeError("Year must be an integer")
    if not re.match(r"^\d{4}$", str(year_pub_int)):
        raise ValueError("Year is invalid")

    try:
        quantity_int = int(quantity)
    except ValueError:
        raise TypeError("Quantity must be an integer")
    if not (0 <= quantity_int <= 1000):
        raise ValueError("Quantity is invalid")

    try:
        cost_cad_float = float(cost_cad)
    except ValueError:
        raise ValueError("Cost is invalid")
    if not re.fullmatch(r"\d+\.\d{2}", f"{cost_cad_float:.2f}"):
        raise ValueError("Cost is invalid")


def calculate_per_book_cost_cad(cost_cad, quantity):
    return cost_cad / quantity


def write_book_order_details(filename, title, author, isbn, year_pub, quantity, cost_cad, unit_cost_cad):
    if os.path.isfile(filename):
        raise ValueError("Order file name already exists!")

    cost_cad_float = float(cost_cad)
    unit_cost_cad_float = float(unit_cost_cad)

    with open(filename, "w") as file:
        file.write(f"book order\n")
        file.write(f"title={title}\n")
        file.write(f"author={author}\n")
        file.write(f"isbn={isbn}\n")
        file.write(f"year_pub={year_pub}\n")
        file.write(f"quantity={quantity}\n")
        file.write(f"cost_cad=${cost_cad_float:.2f}\n")
        file.write(f"unit_cost=${unit_cost_cad_float:.2f}\n")


def main():
    validate_book_order_details(1, "war", "ndo", "4235", 2022, 5, 12.5)
    write_book_order_details("data.txt", "LIFE", "Dubazane", "dg353", 2024, 4, 43, 6)
