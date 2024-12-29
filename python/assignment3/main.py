# Author: Lindokuhle Dubazane

import random
from country import Country
import data


def main():
    """
    The main function try’s to create a list of all of Country objects called all_countries
    (assigning each and every country a random population between 1 million and 1 billion, in the try block)
     using the countries_and_capitals tuple (use a loop); make sure any ValueError exceptions are handled
     by printing “oops” to the console in addition to the ValueError’s message of “Population 1999999 is too low”.
    Import random and generate a random int like this: population = random.randint(1000000, 1000000000).
    Keep generating populations and countries until you have successfully created all the countries.
     Each time a too-small population (i.e. under 2000000) is generated, print the value error's message like this:
    "Canada cannot have a population of 1999999 because the lower limit is 2000000"; then try to generate its population

    Loop through the 20 countries in the all_countries list and call each object’s print_details() method.

    Then loop through the list again, calling birth() for each object and calling print_details() again;
    note that each country’s population should be 1 higher than the previous loop.

    Then loop through the list again, calling death() for each object and calling print_details() again;
    note that each country’s population should be 1 lower than the previous loop.

    Then loop through the list again, calling disaster() for each object and calling print_details() again;
     note that each country’s population should be 100 million lower than the previous loop (for big countries)
     or zero (for countries that previously had populations of 100 million or lower

    :return:None
    """
    all_countries = []

    for country_info in data.countries_and_capitals:
        name, capital = country_info
        while True:
            try:
                population = random.randint(1000000, 1000000000)
                if population < 2000000:
                    raise ValueError(f"Population {population} is too low")
                country = Country(name, capital, population)
                all_countries.append(country)
                break
            except ValueError as e:
                print("oops", e)

    for country in all_countries:
        country.print_details()

    for country in all_countries:
        country.birth()
        country.print_details()

    for country in all_countries:
        country.death()
        country.print_details()

    for country in all_countries:
        country.disaster()
        country.print_details()


if __name__ == '__main__':
    main()
