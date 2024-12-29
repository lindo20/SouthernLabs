# jason wilder
import os
import assignment2
import sys
from pathlib import Path
import hashlib
import re

score = 100


# def test_write_countries_capitals_to_file():
#     global score
#     filename = "xoxoxoxo.txt"
#
#     my_file = Path(filename)
#     if my_file.is_file():
#         os.remove(filename)
#
#     if not my_file.is_file():
#         assignment2.write_countries_capitals_to_file(filename)
#     else:
#         print("Fail; your write_countries_capitals_to_file() function must create this file")
#         score -= 30
#         sys.exit()
#
#     if not my_file.is_file():
#         print("File creation error; write_countries_capitals_to_file() is wrong")
#         score -= 30
#         sys.exit()
#     else:
#         f = open(filename, "r")
#         actual_contents = f.read()
#         actual_contents = actual_contents.replace("\r", "")
#         actual_contents = actual_contents.replace("\n", "")
#         f.close()
#
#         actual_result = hashlib.md5(actual_contents.encode())
#         actual_hex_result = (actual_result.hexdigest())
#
#         expected_correct_hex_result = "560082c8443619d3a52c04eb092eb244"  # calculated by instructor with correct file
#
#         if str(actual_hex_result) != expected_correct_hex_result:
#             print("Error; your write_countries_capitals_to_file() does not write data to the file correctly")
#             score -= 30
#             sys.exit()
#         else:
#             print("Good; your write_countries_capitals_to_file() function seems to write data to the file correctly")


def test_save_filtered_places():
    global score
    error = False

    if len(assignment2.capitals) != 0:
        print("Error; assignment2.capitals global variable must begin as empty list")
        score -= 10
        error = True

    if len(assignment2.countries) != 0:
        print("Error; assignment2.countries global variable must begin as empty list")
        score -= 10
        error = True

    if len(assignment2.places) != 0:
        print("Error; assignment2.places global variable must begin as empty dictionary")
        score -= 10
        error = True

    assignment2.save_filtered_places()

    if len(assignment2.capitals) != 200:
        print("Error; assignment2.capitals global variable must end as a tuple with 200 capitals")
        score -= 10
        error = True
    else:
        capitals_contents = "".join(assignment2.capitals)
        actual_result = hashlib.md5(capitals_contents.encode())
        actual_hex_result = (actual_result.hexdigest())
        expected_correct_hex_result = "687c341c44050a2c1d229dc02493a8e1"  # calculated by instructor with correct data
        if actual_hex_result != expected_correct_hex_result:
            print("Error; assignment2.capitals does not have the correct data")
            score -= 20
            error = True

    if len(assignment2.countries) != 200:
        print("Error; assignment2.countries global variable must end as a tuple with 200 countries")
        score -= 10
        error = True
    else:
        countries_contents = "".join(assignment2.countries)

        actual_result = hashlib.md5(countries_contents.encode())
        actual_hex_result = (actual_result.hexdigest())
        expected_correct_hex_result = "53f04118c6e4cd9dbad8b1837d7b513a"  # calculated by instructor with correct data
        if actual_hex_result != expected_correct_hex_result:
            print("Error; assignment2.countries does not have the correct data")
            score -= 20
            error = True

    if len(assignment2.places) != 200:
        print("Error; assignment2.places global variable must end as a dictionary with 200 items")
        score -= 10
        error = True
    else:
        places_contents = "".join(assignment2.places.keys())
        places_contents += "".join(assignment2.places.values())

        actual_result = hashlib.md5(places_contents.encode())
        actual_hex_result = (actual_result.hexdigest())
        expected_correct_hex_result = "0707460e13b3a920381cce7b00cfcf3a"  # calculated by instructor with correct data
        if actual_hex_result != expected_correct_hex_result:
            print("Error; assignment2.places does not have the correct data")
            score -= 20
            error = True

    if not error:
        print("Good; your save_filtered_places() function seems to create variables correctly")

    # check the regex and files now

    # vowel_vowel_vowel.txt   Contain three consecutive vowels
    # notvowel_notvowel.txt   Does NOT contain two consecutive vowels
    # cons_cons_cons.txt      Contain three consecutive consonants
    # i_before_e.txt          Contain i somewhere before e.For example: Ireland
    # a_a.txt                 Start with a, and end with a
    # start_end_same.txt      Starts and ends with the same character (e.g.warsaw)
    # weird.txt               Contains apostrophe, space, or dash
    # not_start.txt           Does not start with a - e, l - p, or s
    # multiple.txt            Consist of more than one word (e.g., New Delhi).
    # city_town.txt           End with "city" or "town"
    # hyphen.txt              Contain a hyphen
    # consonant_vowel.txt     Start with a consonant and end with a vowel or vice versa.
    # spaces.txt              Contain more than one space
    # not_aeio.txt            Do not contain any of a, e, i, or o
    # alternating.txt         Consist entirely of alternating vowels and consonants (e.g.starts with a vowel,
    #                         followed by a consonant, and so on).
    # double.txt              Contain any double letters(e.g., Addis Ababa).

    hashes_files = {"9a76df25968ebef6eee90217b42a012c": "vowel_vowel_vowel.txt",
                    "1948b1dfde232db9bf84dda1d421ecb4": "notvowel_notvowel.txt",
                    "6b7b72581ca364faf62b84ee462a2375": "cons_cons_cons.txt",
                    "0ff4b53b1405afa245c9dac077fd6d72": "i_before_e.txt",
                    "6696f6dca30a1264d7c86d4d0dbcf72a": "a_a.txt",
                    "8b7446b1bd673edadcae2c360688893c": "start_end_same.txt",
                    "55578c3fe959321e8298120b55f79f6b": "weird.txt",
                    "4dc6084b50bde5823adc88422de7e409": "not_start.txt",
                    "f12dc8dcbc482a57cafd1e713aa2b9be": "multiple.txt",
                    "40875a4d0b511021d01d2eefe9841b2b": "city_town.txt",
                    "57e3e2103a10c02df3a2ad93135e48cf": "hyphen.txt",
                    "85e0fc5bfded13752b0306d4e339416f": "consonant_vowel.txt",
                    "ce45b470736a18f6cd76c89693d7f5a3": "spaces.txt",
                    "6d68c7cfe5d1825d6622f3c824f8db8b": "not_aeio.txt",
                    "79356471e076594059e393ec44b3848a": "alternating.txt",
                    "5c757b852e34ca3f3f56975a9f7c0bb1": "double.txt"}

    for hashvalue, filename in hashes_files.items():
        with open(filename) as f:
            contents = f.read()
            contents = contents.replace("\r", "")
            contents = contents.replace("\n", "")
            actual_result = hashlib.md5(contents.encode())
            actual_hex_result = (actual_result.hexdigest())

            expected_hex_result = hashvalue  # calculated by instructor on correct file data
            if actual_hex_result != expected_hex_result:
                score -= 10
                print(f"{filename} contents wrong")
            else:
                print(f"Good; {filename} contents CORRECT")


if __name__ == '__main__':
    # test_write_countries_capitals_to_file()
    test_save_filtered_places()
    print(f"\nYour estimated score is {score} out of 100.")
