# Author:Lindokuhle Dubazane
# partner1:Rethabile Sitole
# partner2:Nkululeko Banda


def is_leap_year(year):
    """
    This function checks if the year is a leap year or not
    :param year: enter the year
    :return: the function returns true if its leap year , false if not
    """
    if year % 4 == 0:
        return True
    if year % 100 == 0:
        return False
    if year % 400 == 0:
        return True
    else:
        return False


def get_maximum_days(month, year):
    """
    This function checks number of days in each month
    :param month: the month of the year
    :param year: a year for a given date
    :return: the maximum days in a month
    """
    if month == 1 or month == 3 or month == 5 or month == 7 or month == 8 or month == 10 or month == 12:
        max_days = 31
    elif month == 4 or month == 6 or month == 9 or month == 11:
        max_days = 30
    elif (year % 4 == 0 and year % 100 != 0) or year % 400 == 0:
        max_days = 29
    else:
        max_days = 28

    return max_days


def get_month_codes(month):
    """
    This function adds the month codes
    Jan 	= 1	Feb 	= 4	Mar 	= 4
    Apr 	= 0	May 	= 2	Jun 	= 5
    Jul 	= 0	Aug 	= 3 Sep 	= 6
    Oct 	= 1	Nov 	= 4 Dec 	= 6
    :param month: the month of the year
    :return: the code of the month
    """
    if month == 4 or month == 7:
        month_code = 0
    elif month == 1 or month == 10:
        month_code = 1
    elif month == 5:
        month_code = 2
    elif month == 8:
        month_code = 3
    elif month == 2 or month == 3 or month == 11:
        month_code = 4
    elif month == 6:
        month_code = 5
    else:
        month_code = 6

    return month_code


def century_dates(year):
    """
    This function gets  the century code for a given year
    Dates in the 1600s: add 6
    Dates in the 1700s: add 4
    Dates in the 1800s: add 2
    Dates in the 2000s: add 6
    Dates in the 2100s: add 4
    :param year: the year for which to calculate the century code
    :return: the century code
    """
    if year // 100 == 16:
        return 6
    elif year // 100 == 17:
        return 4
    elif year // 100 == 18:
        return 2
    elif year // 100 == 20:
        return 6
    elif year // 100 == 21:
        return 4
    else:
        return 0


def get_day_of_the_week(month, day, year):
    """
    This function calculates and returns the name of the day of the week for that month, day, and year
    :param month: the month of the year
    :param day: the day of the week
    :param year: the year
    :return: the name of the day of the week
    """
    # check if the entered day and month are valid or not
    if month < 1 or month > 12:
        print("Invalid month")
        return None
    elif day < 1 or day > get_maximum_days(month, year):
        print("Invalid day")
        return None

    # Last two digits of the year
    last_two_digit = year % 100

    # Number of 12s that fit into last two digits
    number_of_12s = last_two_digit // 12

    # Remainder of the division
    remainder = last_two_digit % 12

    # Number of 4s that fit into remainder
    number_of_4s_in_remainder = remainder // 4

    # Add the date of the month
    total = number_of_12s + number_of_4s_in_remainder + day + remainder

    # Adjust for leap year
    if is_leap_year(year) and (month == 1 or month == 2):
        total += 6
    total += century_dates(year)

    # Add month code
    total += get_month_codes(month)

    # Find the day of the week
    week_days = total % 7

    if week_days == 0:
        return "Saturday"
    elif week_days == 1:
        return "Sunday"
    elif week_days == 2:
        return "Monday"
    elif week_days == 3:
        return "Tuesday"
    elif week_days == 4:
        return "Wednesday"
    elif week_days == 5:
        return "Thursday"
    elif week_days == 6:
        return "Friday"
    else:       # week_days greater than 7 or less than 0
        print("Invalid day")

    return week_days


def main():
    print("Sunday" == get_day_of_the_week(12, 25, 2022))
    print("Friday" == get_day_of_the_week(8, 26, 2022))
    print("Thursday" == get_day_of_the_week(10, 5, 1972))
    print("Wednesday" == get_day_of_the_week(2, 3, 2016))
    print("Monday" == get_day_of_the_week(12, 18, 1899))


if __name__ == "__main__":
    main()

