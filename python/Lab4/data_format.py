# author: Lindokuhle Dubazane
# partner1: Rethabile Sitole
# partner2: Nkululeko Banda

def get_book_info():
    """
    This function prompt the user to enter the following information:
     book title
     book ISBN
     book author last name
     book publisher
     year published
     book price in American dollars
    :return: the function returns the book details
    """
    book_title = input("Enter the book title: ").strip()
    book_isbn = input("Enter book ISBN: ").strip()
    book_author_last_name = input("Enter author last name: ").strip()
    book_publisher = input("Enter the book publisher: ").strip()
    year_published = int(input("Enter year published: ").strip())
    book_price_usd = float(input("Enter price: ").strip())

    book_details = (f"{book_title.capitalize()}/{book_isbn}/{book_author_last_name}"
                    f"/{book_publisher}/{year_published}/{book_price_usd:.2f}")

    return book_details


def to_csv_format(book_details):
    """
    This function takes a string containing book details and converts it to a CSV format string.
    :param book_details: The string containing book details in a specific format.
    :return: The function returns a new string containing the book details in CSV format,
             where each detail is separated by a comma.
    """
    csv_formatted = book_details.replace('/', ',')
    return csv_formatted


def to_json_format(csv_formatted_string):
    """
    This function takes a string containing book details in CSV format and converts it to a JSON format string.
    :param csv_formatted_string: The string containing book details in CSV format.
    :return: The function returns a new string containing the book details in JSON format.
    """
    csv_parts = csv_formatted_string.split(',')
    json_formatted = (f"{{\"title\":\"{csv_parts[0]}\",\"isbn\":\"{csv_parts[1]}\",\"author_last_name\":"
                      f"\"{csv_parts[2]}\",\"publisher\":\"{csv_parts[3]}\",\"year_published\":"
                      f"\"{csv_parts[4]}\",\"price\":\"{csv_parts[5]}\"}}")
    return json_formatted


def main():
    book_info = get_book_info()
    csv_format = to_csv_format(book_info)
    json_format = to_json_format(csv_format)

    print("Book Information:", book_info)
    print(f"The CSV Format String:\n{csv_format}")
    print(f"The JSON Format String:\n{json_format}")


if __name__ == "__main__":
    main()
