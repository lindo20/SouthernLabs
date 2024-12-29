# Author: Lindokuhle Dubazane
import re

capitals = []
countries = []
places = {}


def write_countries_capitals_to_file(filename):
    """
    Checks the filename and writes country and capital data from 'places.txt'
    to the specified filename in a formatted manner. The filename must match
    the pattern: one to eight alphanumeric characters followed by '.txt'.
    If the filename does not match, the user will be prompted to enter a valid filename.
    :param filename: The name of the file to write to.
    :return: None
    """
    pattern = r'^[A-Za-z0-9]{1,8}\.txt$'

    while not re.match(pattern, filename):
        filename = input("Please enter a valid filename: ")

    with open('places.txt', 'r') as input_file, open(filename, 'w') as output_file:
        for line in input_file:
            country, capital = map(str.strip, line.strip().split(':'))
            country = country.title()
            capital = capital.title()
            output_file.write(f"The capital of {country} is {capital}.\n")

def save_filtered_places():
    """
    Reads country and capital data from 'places.txt', applies various regular expression patterns,
    and writes the results to specific files based on the patterns.
    :return: None
    """
    global countries
    global capitals
    global places

    with open("places.txt", "r") as file:
        lines = file.readlines()
        capitals = []
        countries = []

        for line in lines:
            country, capital = map(str.strip, line.strip().split(":"))
            countries.append(country.lower())
            capitals.append(capital.lower())

        capitals = tuple(capitals)
        countries = tuple(countries)
        places = dict(zip(countries, capitals))

    patterns = {
        "vowel.txt": r"[aeiou]{3}",
        "not_vowel.txt": r"^(?!.*[aeiouAEIOU]{2}).*$",
        "cons_cons_cons.txt": r"[b-df-hj-np-tv-z]{3}",
        "i_before_e.txt": r"i(.)*e",
        "a_a.txt": r"^a(.)+a$",
        "start_end_same.txt": r"^(.).*\1$",
        "weird.txt": r"[ '\-]",
        "not_start.txt": r"^[^a-e, l-p, s].*$",
        "multiple.txt": r"^\S+\s+\S+.*$",
        "city_town.txt": r".*(city|town)$",
        "hyphen.txt": r".*-.*",
        "consonant_vowel.txt": r"^[bcdfghjklmnpqrstvwxyz].*[aeiou]$|^[aeiou].*[bcdfghjklmnpqrstvwxyz]$",
        "spaces.txt": r".*\s.*\s.*",
        "not_aeio.txt": r"^[^aeio]*$",
        "double.txt": r"(.)\1",
        "alternating.txt": r"^(?:[aeiou][bcdfghjklmnpqrstvwxyz])*$|^(?:[bcdfghjklmnpqrstvwxyz][aeiou])*$"
    }

    files = {name: open(name, "w") for name in patterns.keys()}

    for capital, country in places.items():
        for file_name, pattern in patterns.items():
            if re.search(pattern, capital, re.IGNORECASE):
                files[file_name].write(f"{capital.lower()}\n")
            if re.search(pattern, country, re.IGNORECASE):
                files[file_name].write(f"{country.lower()}\n")

    for file in files.values():
        file.close()


def main():
    write_countries_capitals_to_file("example.txt")
    save_filtered_places()


if __name__ == "__main__":
    main()
