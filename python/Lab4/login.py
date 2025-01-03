# author: Lindokuhle Dubazane
# partner1: Rethabile Sitole
# partner2: Nkululeko Banda
def generate_password(first_name, last_name, bcit_id):
    """
    This Function takes three parameters: first name,last name,and BCIT ID, and which returns the default login password
    The first and last names must be formatted properly by this function: i.e. the first character is upper case and the
    rest of the name is lowercase. If the function is called like this: generate_login(“tiger”, “woods”, “a00123”),
    it creates new variables with values “Tiger” and “Woods”.

    The password is generated as follows:
    Get the first three letters from a properly-formatted first name; if the first name length is less than three
    characters then the entire name will be used.
    Get the first three characters from a properly-formatted last name; if the last name length is less than three
    characters then the entire last name will be used.
    Get the last three characters of the BCIT ID; if the BCIT ID length is less than three
    characters then the entire ID will be used.
    Concatenate the characters generated from the above instructions as follows:
    (Characters from the first name + characters from the last name+ characters from BCIT ID)


    :param first_name:The first name of the user.
    :param last_name:The last name of the user.
    :param bcit_id:The BCIT ID of the user.
    :return: A password generated by concatenating the first three characters of the first name,
            the first three characters of the last name, and the last three characters of the BCIT ID.
    """
    if len(first_name) < 3:
        first_name_length = first_name
    else:
        first_name_length = first_name[0:3]

    if len(last_name) < 3:
        last_name_length = last_name
    else:
        last_name_length = last_name[0:3]

    if len(bcit_id) < 3:
        id_length = bcit_id
    else:
        id_length = bcit_id[-3:]

    login_password = first_name_length + last_name_length + id_length
    return login_password


def change_password():
    """
    this function will repeatedly (i.e. in a loop) prompt the user to enter a new password.
    If the password meets the specifications, the loop terminates and the password is returned;
    otherwise a message including the password specifications and a request to enter another password will be displayed
    and the user will be prompted to enter another password…until the user follows the rules.
    The password specifications are as follows:
    The password must be at least seven characters long
    The password must contain at least one uppercase character
    The password must contain at least one lowercase character.
    The password must contain at least one digit.

    :return:
    """
    print("enter a new password. The password should be at least 7 characters long has one uppercase, one lowercase "
          "character and one number. It cannot have special characters")
    while True:
        new_password = input("enter a new password: ")

        if (length_password(new_password) and has_upper(new_password) and has_lower(new_password) and
                has_digit(new_password) and all_special_chars(new_password)):

            print(" valid password")
            print(new_password)
            break


def length_password(password):
    """
    This function checks if the password is at least 7 characters long.
    :param password: The password to check
    :return: The function return True if the password is at least 7 characters long, False otherwise.
    """
    if len(password) >= 7:
        return True
    else:
        print("the password must be at least 7 characters")


def has_upper(password):
    """
    This function check if the password contains at least one uppercase character.
    :param password:The password to check
    :return:The function return True if the password contains at least one uppercase character, False otherwise.
    """
    i = 0
    found_upper_case = False

    while i < len(password):
        if not str.isdigit(password[i]) and password[i] == str.upper(password[i]):
            found_upper_case = True

        i += 1

    if found_upper_case:
        return True
    else:
        print("the password must have at least one uppercase character")


def has_lower(password):
    """
    This function check if the password contains at least one lowercase character
    :param password:The password to check.
    :return:The function returns True if the password contains at least one lowercase character, False otherwise.
    """
    i = 0
    found_lower_case = False

    while i < len(password):
        if not str.isdigit(password[i]) and password[i] == str.lower(password[i]):
            found_lower_case = True
        i += 1

    if found_lower_case:
        return True
    else:
        print("the password must have at least one lowercase character")


def has_digit(password):
    """
    This Function check if the password contains at least one digit.
    :param password:The password to check
    :return: The function returns True if the password contains at least one digit, False otherwise.
    """
    i = 0
    found_digit = False

    while i < len(password):
        if not password.isalpha() and str.isdigit(password[i]):
            found_digit = True
        i += 1

    if found_digit:
        return True
    else:
        print("the password must have at least one number")


def all_special_chars(password):
    """
    THis function check if the password contains any special characters (non-alphanumeric).
    :param password:The password to check
    :return:The function returns True if the password does not contain any special characters, False otherwise.
    """
    i = 0
    found_special_chars = False

    while i < len(password):
        if not password[i].isalnum():
            found_special_chars = True

        i += 1

    if found_special_chars:
        print("special characters are not allowed")
    else:
        return True
