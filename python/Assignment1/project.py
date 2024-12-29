# author: lindokuhle dubazane

from data import countries_and_capitals, countries, capitals


def print_json_countries_and_capitals():
    """
        This function prints each country and its capital in json format exactly as follows:
     [
        {
            “country_name” : “Afghanistan”,
            “capital_city” : “Kabul”
    },
    {
            “country_name” : “Albania”,
            “capital_city” : “Tirana (Tirane)”
    },
    {
            “country_name” : “Algeria”,
            “capital_city” : “Algiers”
    },
                … etc …
    {
            “country_name” : “Zimbabwe”,
            “capital_city” : “Harare”
    }
    ]

    :return: None
    """
    i = 0
    print("[")
    while i < len(countries_and_capitals):
        country, capital = countries_and_capitals[i]
        json_list = f'{{\n\t"country_name": "{country}",\n\t"capital_city": "{capital}"\n}}'
        if i < len(countries_and_capitals) - 1:
            json_list += ","
        print(json_list)
        i += 1
    print("]")


def get_list_of_countries_whose_nth_letter_is(n, letter):
    """
    this function creates and returns a list of all countries whose nth letter matches the letter in the parameter.
    For example, calling it as follows:

    get_list_of_countries_whose_nth_letter_is(3, “m”) would return a list of every country whose THIRD letter
     (i.e. index 2) is the letter m:
    ['Armenia', 'Cambodia', 'Cameroon', 'Comoros', 'Dominica', 'Dominican Republic', 'Gambia', 'Jamaica', 'Namibia',
    'Romania', 'Samoa', 'Somalia', 'Yemen', 'Zambia', 'Zimbabwe']

    Also get_list_of_countries_whose_nth_letter_is(3, “M”) would return the same list as above (in other words,
    this is case-insensitive).

    :param n: The position of the letter to check
    :param letter: The letter to match against the nth letter of the country names
    :return: the list of country where the nth letter matches the specified letter
    """
    letter = letter.lower()
    list_of_country = [country for country in countries if country[n - 1].lower() == letter]
    return list_of_country


def get_funny_case_capital_cities(letter):
    """
    This function takes a single letter as a parameter and processes a list of capital cities to produce a list of names
    For each capital city in the list:
    - If the specified letter appears in the city name, the function will:
    - Uppercase the letter immediately before and after each occurrence of the specified letter.
    - Lowercase the specified letter itself and any consecutive occurrences of it
    (i.e., if the letter is followed by the same letter, both will be in lowercase).
    - Lowercase all other letters in the city name.
    :param letter: The letter to check in each capital city
    :return: THis function returns list of all the names that contain the specific letter
    """
    my_list = []
    lower_letter = letter.lower()

    for c in capitals:
        if lower_letter in c.lower():
            capital_city = list(c.lower())

            i = 0
            while i < len(capital_city):
                if capital_city[i] == lower_letter:
                    # Check if the next letter is the same as the specified letter
                    if i < len(capital_city) - 1 and capital_city[i + 1] == lower_letter:
                        # If the letter is followed by the same letter, both should be lowercase
                        capital_city[i] = lower_letter
                        capital_city[i + 1] = lower_letter
                        if i > 0:
                            capital_city[i - 1] = capital_city[i - 1].upper()
                        if i < len(capital_city) - 2:
                            capital_city[i + 2] = capital_city[i + 2].upper()
                        i += 1
                    else:
                        if i > 0:
                            capital_city[i - 1] = capital_city[i - 1].upper()
                        capital_city[i] = lower_letter
                        if i < len(capital_city) - 1:
                            capital_city[i + 1] = capital_city[i + 1].upper()
                i += 1

            capital_city = "".join(capital_city)
            my_list.append(capital_city)

    return my_list


def get_doubled_letter_countries():
    """
    This function creates and returns a tuple of all the countries that have consecutive repeated letters.
    When called it returns that tuple, in alphabetical order by the doubled letters:
    ('morocco', 'greece', 'marshall islands', 'seychelles', 'cameroon', 'philippines', 'andorra', 'sierra leone',
    'guinea-bissau', 'russia', 'saint kitts and nevis')

    :return: the list of sorted double letter country order by the doubled letters: c, e, l, l, o, p, r, r, s, s, t
    """
    double_char_country = []
    # this loop check for doubled letters in the country name from the country list
    for country in countries:
        for i in range(len(country) - 1):
            if country[i].lower() == country[i + 1].lower():
                double_char_country.append((country, country[i].lower()))
                break

    # This loop sort the list of countries based on the doubled letter
    for i in range(len(double_char_country) - 1):
        for j in range(len(double_char_country) - 1 - i):
            if double_char_country[j][1] > double_char_country[j + 1][1]:
                double_char_country[j], double_char_country[j + 1] = double_char_country[j + 1], double_char_country[j]

    sorted_double_letter_country = tuple(country[0] for country in double_char_country)

    return sorted_double_letter_country


def main():
    print("Its should not be called...")


if __name__ == '__main__':
    main()
