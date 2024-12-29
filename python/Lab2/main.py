# author:Lndokuhle Dubazane
# partner1:Rethabile Sitole
# partner2: Nkululeko Banda
import utilities


def main():
    radius_of_circle = float(input("Enter the radius of a circle:"))
    print("the area of circle is:", utilities.calculate_circle_area(radius_of_circle))

    radius_of_sphere = float(input("Enter the radius of a sphere:"))
    print("the volume of the sphere is:", utilities.calculate_sphere_volume(radius_of_sphere))

    print("the body mass index is:", utilities.calculate_body_mass_index())
    print("the hypotenuse length of the right angle triangle is:", utilities.calculate_hypotenuse())


if __name__ == "__main__":
    main()
