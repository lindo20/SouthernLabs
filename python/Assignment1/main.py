# author: lindokuhle dubazane

import project


def main():
    project.print_json_countries_and_capitals()

    vowels = ["a", "e", "i", "o", "u"]
    for n in range(1, 4):
        for letter in vowels:
            print(project.get_list_of_countries_whose_nth_letter_is(n, letter))

    all_alphabet = ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
                    "u", "v", "w", "x", "y", "z"]
    for alph in all_alphabet:
        print(project.get_funny_case_capital_cities(alph))

    print(project.get_doubled_letter_countries())


if __name__ == '__main__':
    main()
