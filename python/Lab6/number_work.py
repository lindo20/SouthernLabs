# author : lindokuhle dubazane
# partner1: Rethabile Sitole
# partner2: Nkululeko Banda


def get_square_numbers_between(first, last):
    """
    This function creates and returns a list of all the square numbers between (and including) first and last.
    Examples:
    print(get_square_numbers_between(30, 222))        # [36, 49, 64, 81, 100, 121, 144, 169, 196]
    print(get_square_numbers_between(500, 611))       # [529, 576]

    :param first: the first number on your list
    :param last: the last number on your list
    :return: this function return all the perfect square numbers
    """
    for number in range(first, last + 1):
        number_perfect_square = number ** 0.5
        if number_perfect_square == int(number_perfect_square):
            print(number)


def process_user_input():
    """
    This function repeatedly (e.g. while loop) asks the user to enter numbers, or type 0 (zero) to quit entering numbers
    The user can enter as many numbers as they like; each time, add the int() version of their input to a list.
    After they eventually enter 0 as input, the function stops asking for input and instead calculates and
    prints the following statistics max _values , min_values and all_values[].
    :return: None
    """
    all_values = []
    max_value = 0
    min_value = 0
    total = 0

    while True:
        user_value = int(input("Enter a number or 0 to end: "))

        if user_value != 0:
            if max_value == 0 or user_value > max_value:
                max_value = user_value

            if min_value == 0 or user_value < min_value:
                min_value = user_value

            all_values.append(user_value)

            total += user_value

            continue
        else:
            break

    print(f"Your numbers are: {all_values}")
    print(f"sum is  {total}")
    print(f"Min is {min_value}")
    print(f"Max is {max_value}")


def main():
    get_square_numbers_between(30, 222)
    process_user_input()


if __name__ == "__main__":
    main()
