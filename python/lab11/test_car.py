import unittest

from car import Car


class TestCar(unittest.TestCase):
    """ Tests for the Car class """

    grade = 0

    @classmethod
    def setUpClass(cls):
        """ Sets up the Test Case """
        TestCar.grade = 0
        print("Grading your Car class... ")

    @classmethod
    def tearDownClass(cls):
        """ Tears down the Test Case """
        print("Your grade for this part of the lab is: %d/8" % TestCar.grade)

    def setUp(self):
        """ Sets up the car objects to test in the subsequent tests """
        self.car1 = Car("Honda", "Civic", 2015, 4999.99, 9999.99)
        self.car2 = Car("Mazda", "Miata", 1990, 1500.0, 3999.88)

    def test_constructor(self):
        """ Tests that the car is successfully created """

        self.assertIsNotNone(self.car1)
        TestCar.grade += 1
        self.assertIsNotNone(self.car2)
        TestCar.grade += 1

    def test_details(self):
        """ Tests that the car details are correct """
        self.assertEqual("2015 Honda Civic for sale for $9999.99 USD", self.car1.get_details())
        TestCar.grade += 1
        self.assertEqual("1990 Mazda Miata for sale for $3999.88 USD", self.car2.get_details())
        TestCar.grade += 1

    def test_profit(self):
        """ Tests that the profit is calculated correctly """
        self.assertEqual(self.car1.calc_profit_usd(), 5000.0)
        TestCar.grade += 1
        self.assertEqual(self.car2.calc_profit_usd(), 2499.88)
        TestCar.grade += 1

    def test_price_reduction(self):
        """ Tests that the price reduction is recorded correctly """
        self.car1.reduce_price(1000.50)
        self.assertEqual(self.car1.calc_profit_usd(), 3999.50)
        TestCar.grade += 1

        self.car2.reduce_price(999.88)
        self.assertEqual(self.car2.calc_profit_usd(), 1500.0)
        TestCar.grade += 1


if __name__ == "__main__":
    unittest.main()


