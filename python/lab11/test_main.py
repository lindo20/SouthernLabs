import unittest
import sys
import io
import subprocess
import re

import main

EXPECTED_OUTPUT = \
[
    "2020 Honda Civic for sale for $20000.00 USD",
    "First Car's Initial Profit is $5000.00 USD`",
    "First Car's New Profit is $4000.00 USD",
    "",
    "2019 BMW M3 for sale for $50000.00 USD",
    "Second Car's Initial Profit is $20000.00 USD",
    "Second Car's New Profit is $14999.50 USD"
]


class TestMain(unittest.TestCase):
    """ Tests for the Main Script """

    grade = 0

    @classmethod
    def setUpClass(cls):
        """ Sets up the Test Case """
        TestMain.grade = 0
        print("Grading your Main Script... ")

    @classmethod
    def tearDownClass(cls):
        """ Tears down the Test Case """
        print("Your grade for this part of the lab is: %d/7" % TestMain.grade)

    def test_main_output(self):
        """ Tests the Output from the Main Script """
        saved_stdout = sys.stdout
        try:
            out = io.StringIO()
            sys.stdout = out
            main.main()
            output = out.getvalue()
            print(output)
            output = re.sub("\n*$", "", output) # Remove the last line return
            lines = re.split("\n", output)
            print(lines)
            self.assertEqual(len(EXPECTED_OUTPUT), len(lines))

            for index in range(len(lines)):
                self.assertEqual(lines[index], EXPECTED_OUTPUT[index])
                TestMain.grade += 1

        finally:
            sys.stdout = saved_stdout

if __name__ == "__main__":
    unittest.main()


