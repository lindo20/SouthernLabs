# author : lindokuhle dubazane
# partner1: Rethabile Sitole
# partner2: Nkululeko Banda
class Car:
    """ Represents a car in a car lot """

    def __init__(self, make, model, year, cost, price_usd):
        """ Initializes the car details """
        self._make = make
        self._model = model
        self._year = year
        self._cost = cost
        self._price_usd = price_usd

    def calc_profit_usd(self):
        """ Returns the projected profit in USD. """
        return self._price_usd - self._cost

    def get_details(self):
        """ Returns a formatted string with the car details. """
        return f"{self._year} {self._make} {self._model} for sale for ${self._price_usd:.2f} USD"

    def reduce_price(self, reduction):
        """ Reduces the price by the given reduction amount in USD. """
        self._price_usd -= reduction
