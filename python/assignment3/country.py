# Author: Lindokuhle Dubazane
class Country:
    """
    This file contains the Country class. Define a constructor that takes three parameters:
     a country name, a capital name, and a population. In the constructor, assign the parameter values to the instance
     variables, unless the population is less than 2 million; in that case raise a
      ValueError with a message in the format of (“Population 1999999 is too low”).

    Also add the following methods:

    print_details()	This method prints data in this format:
                    "The capital of Canada (pop. 12345678) is OTTAWA"

    birth()    		This method adds 1 to the object’s own self’s population

    death()    		This method subtracts 1 from the object’s own self’s population

    disaster()		For countries with a population of 100 million or higher, this method subtracts
                    100 million from the population. For smaller countries, it sets the population to 0.
    """
    def __init__(self, country_name, capital_name, population):
        if population < 2_000_000:
            raise ValueError(f"Population {population} is too low")
        self.country_name = country_name
        self.capital_name = capital_name
        self.population = population

    def print_details(self):
        print(f"The capital of {self.country_name} (pop. {self.population}) is {self.capital_name.upper()}")

    def birth(self):
        self.population += 1

    def death(self):
        self.population -= 1

    def disaster(self):
        if self.population >= 100_000_000:
            self.population -= 100_000_000
        else:
            self.population = 0
