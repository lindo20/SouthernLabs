# import re
#
#
# def divide_it(numerator, denominator):
#     """
#     This function return the value of numerator divided by denominator,
#     or else raises a ValueError if the denominator is zero.
#     Raise a ValueError if the denominator is zero. Otherwise, return numerator divided by denominator.
#     After the function, create a main function in which you try{} calling the function. If it succeeds,
#     print out the answer that divideIt returns. If it fails, print out the error. Either way, print "the end"
#     :param numerator: the value to be divided
#     :param denominator: v: The value by which the numerator is divided.
#     :return: The function returns the value of numerator divided by denominator
#     """
#     if denominator != 0:
#         return numerator / denominator
#     else:
#         raise ValueError("Denominator must not be zero!!!")
#
#
# def main():
#     try:
#         result = divide_it(10, 0)
#         print(f"Result: {result}")
#     except ValueError as e:
#         print(f"Error: {e}")
#     finally:
#         print("The end.")
#
#
# if __name__ == "__main__":
#     main()


# number8
# def print_from_to(min_number, max_number):
#     if max_number < min_number:
#         raise ValueError("min cannot be greater than max")
#
#     if min_number == max_number:
#         print("what are you doing?")
#         return None
#
#     if max_number >= min_number:
#         current_number = max_number
#         while True:
#             print(current_number, end=" ")
#             if current_number == min_number:
#                 break
#             current_number -= 1
#
#     if max_number >= min_number:
#         for number in range(min_number, max_number + 1):
#             print(number, end=" ")
#
#
# def main():
#     print_from_to(5, 5)
#     print_from_to(1, 5)
#     print_from_to(4, 1)
#
#
# if __name__ == "__main__":
#     main()


# class Student:
#     def __init__(self, first_name, last_name, year_born, gpa):
#         self.f_name = first_name
#         self.l_name = last_name
#         self.year_of_birth = year_born
#         self.grade_point_average = gpa
#
#     def print_full_name(self):
#         print(f"{self.f_name} {self.l_name}")
#
#
# from student import Student
#
#
# def main():
#     student_details = Student(first_name="Tiger", last_name="Woods", year_born=1975, gpa=4.0)
#
#     print(f"First Name: {student_details.f_name}")
#     print(f"Last Name: {student_details.l_name}")
#     print(f"Year of Birth: {student_details.year_of_birth}")
#     print(f"GPA: {student_details.grade_point_average}")
#
#     student_details.print_full_name()
#
# if __name__ == "__main__":
#     main()


# day_of_the_weeks = ("Monday", "Tuesday", "WEdnesday", "Thursday", "Friday", "Saturday", "Sunday")
# days_with_e = [day for day in day_of_the_weeks if 'e' in day.lower()]
# print("Days that has  'e' or 'E':")
#
# for day in days_with_e:
#     print(day)
#
# days_of_week_dic = {"m": "monday",
#                     "t": "tuesday",
#                     "w": "wednesday",
#                     "th": "thursday",
#                     "f": "friday",
#                     "sa": "saturday",
#                     "su": "sunday"}
# for key, value in days_of_week_dic.items():
#     print(f"{key}, is the key for {value}")

first_name = "Lindokuhle"


# def print_details(last_name):
#     user_values = input("Enter Middle Name:")
#     middle_name = user_values
#
#     full_name = f"{first_name} {middle_name} {last_name}"
#     print(f"{full_name}", end="")
#
#
# def main():
#     print_details("dubazane")
#
#
# if __name__ == "__main__":
#     main()


# file_name = 'days_of_week.txt'
#
# with open(file_name, 'w') as file:
#     file.write("Monday\nTuesday\nWednesday\nThursday\nFriday\nSaturday\nSunday\n")
#
# with open(file_name, 'r') as file:
#     lines = file.readlines()
#
# with open(file_name, 'a') as file:
#     for line in lines:
#         file.write(line)

# pattern = r"^(0[0-9]|[1-8][0-9]|90)°|dg\s*(0[0-9]|[1-8][0-9]|90)'\s*[NS]\s*(0[0-9]|[1-8][0-9]|90)\"\s*[EW]$"


# days_of_the_week = ("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
# for i in range(len(days_of_the_week)):
#     day = days_of_the_week[i]
#     if len(day) >= 7:
#         print(day.upper())
#     else:
#         print(day.lower())
#
# for day in days_of_the_week:
#     new_day_of_the_week = ''.join(char.upper() if char.lower() == 'e' else char.lower() for char in day)
#     print(new_day_of_the_week)
#
# days_json = []
#
# day_number = 1
#
# for day in days_of_the_week:
#     day_dict = {
#         "day_name": day,
#         "day_number": day_number
#     }
#     days_json.append(day_dict)
#     day_number += 1
#
# print("[")
# for item in days_json:
#     print(f'    {{\n        "day_name": "{item["day_name"]}",\n        "day_number": {item["day_number"]}\n    }},')
# print("]")
