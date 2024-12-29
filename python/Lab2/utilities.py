# author:Lindokuhle Dubazane
# partner1:Rethabile Sitole
# partner2: Nkululeko Banda
import math


def calculate_circle_area(radius_of_circle):
    """
    This function calculate the area of the circle
    :param radius_of_circle: the radius of the circle
    :return: the function return area of the circle
    """
    area = math.pi * radius_of_circle ** 2
    return area


def calculate_sphere_volume(radius_of_sphere):
    """
    THis function calculate the volume of the sphere
    :param radius_of_sphere: the radius of the sphere
    :return: the function returns volume of the sphere
    """
    volume = (4/3) * math.pi * radius_of_sphere ** 3
    return volume


def calculate_body_mass_index():
    """
    This function calculate the body mass index
    :return: the function returns body mass index
    """
    weight_in_kilograms = float(input("Enter the weight in kilograms:"))
    height_in_meter = float(input(" Enter the height in meter:"))
    body_mass_index = weight_in_kilograms / (height_in_meter * height_in_meter)
    return body_mass_index


def calculate_hypotenuse():
    """
    This function calculates the  hypotenuse of a right angle triangle
    :return: the function returns hypotenuse of a triangle
    """
    length_of_first_side_cm = float(input("Enter the length of side A in cm:"))
    length_of_second_side_cm = float(input("Enter the length of side B in cm:"))
    length_of_hypotenuse_cm = math.hypot(length_of_first_side_cm, length_of_second_side_cm)
    return length_of_hypotenuse_cm
