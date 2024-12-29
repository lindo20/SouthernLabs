1   # author:lindokuhle dubazane
# partner1: Given Sitole
# partner2:Nkululeko Banda
import re


def is_valid_license_plate(license_plate):
    """
    This function Checks if the given license plate is valid based on defined patterns.
    Six characters total:
    Valid license plate formats are:
    three letters then three digits, or
    three digits then three letters, or
    two letters, digit, space or hyphen, two digits, letter
    :param license_plate: The license plate to check.
    :return:bool: True if the license plate matches any of the valid formats, False otherwise.
    """
    license_plate_pattern1 = r'^[A-Z]{0,3}[0-9]{3}$'
    license_plate_pattern2 = r'^[0-9]{3}[A-Z]{3}$'
    license_plate_pattern3 = r'^[A-Z]{2}[0-9][ -][0-9]{2}[A-Z]$'

    if (re.match(license_plate_pattern1, license_plate) or re.match(license_plate_pattern2, license_plate)
            or re.match(license_plate_pattern3, license_plate)):
        return True
    else:
        return False


def is_valid_python_variable_name(variable_name):
    """
    This function validates if the given string is a valid Python variable name.
    A valid Python variable name:
    Between one and 32 characters total:
    all characters must be lowercase letters or underscores,
    but not more than one underscore in a row
    :param variable_name: the name of the variable to check
    :return: True if the variable name is valid, False otherwise
    """
    variable_name_pattern = r"^[a-z]+(_?[a-z]+){0,31}$"
    if re.match(variable_name_pattern, variable_name):
        return True
    else:
        return False


def is_valid_email_address(email):
    """
    This function checks if the given email address is in a correct format.
    A valid email address:
    Contains exactly one '@' and one '.'.
    - Username length: 1-256 characters, with letters and underscores.
    - Domain name length: 1-32 characters, with letters only.
    - Top-level domain length: 2-5 characters, with letters only.
    - Username cannot start or end with an underscore
    :param email: The email address to check.
    :return: True if the email address is valid, False otherwise
    """
    if '@' not in email or '.' not in email:
        return False

    email_data = re.split('@', email)

    if len(email_data) != 2:
        return False

    username = email_data[0]
    domain_data = re.split('[.]', email_data[1])

    if len(domain_data) != 2:
        return False

    domain_name = domain_data[0]
    top_level_domain = domain_data[1]

    if not (1 <= len(username) <= 256):
        return False
    if not re.match(r'^[a-zA-Z]+(?:[a-zA-Z0-9]*_?[a-zA-Z0-9]+)*$', username):
        return False
    if username[0] == '_' or username[-1] == '_':
        return False

    if not (1 <= len(domain_name) <= 32):
        return False
    if not re.match(r'^[a-zA-Z]+$', domain_name):
        return False

    if not (2 <= len(top_level_domain) <= 5):
        return False
    if not re.match(r'^[a-zA-Z]+$', top_level_domain):
        return False

    return True


def is_valid_human_height(human_height):
    """
    This function checks  if the given height string is in the correct format.
    A valid height format:
    - Feet and inches (e.g., 5'11" or 6'0in").
    - Feet only (e.g., 6').
    :param human_height: The height to check.
    :return:True if the height is in a valid format, False otherwise.
    """
    height_pattern = r"^(?:[2-8]'(?:0?[0-9]|[1][0-1])|[2-8]'(?:0?[0-9]|[1][0-1])in)$"
    if re.match(height_pattern, human_height):
        return True
    else:
        return False


if __name__ == "__main__":
    print(is_valid_license_plate("ABC134"))
    print(is_valid_python_variable_name("first_name_last"))
    print(is_valid_human_height("2'01in"))
    print(is_valid_email_address("Jason_Harrison@bcit.com"))
