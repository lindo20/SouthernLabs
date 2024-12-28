/**
 * Represents a generic vehicle with basic attributes such as brand, year, and color.
 *
 * @author Lindokuhle Dubazane
 * @author Cebisile Masombuka
 * @author Rethabile Sitole
 *
 * @version 1.0
 *
 */
class Vehicle
{
    private final String brand;
    private final int yearMade;
    private final String color;

    /**
     * Constructs a new Vehicle with the specified brand, year, and color.
     *
     * @param brand    the brand of the vehicle
     * @param yearMade the year the vehicle was manufactured
     * @param color    the color of the vehicle
     */
    public Vehicle(final String brand,
                   final int yearMade,
                   final String color)
    {
        this.brand = brand;
        this.yearMade  = yearMade;
        this.color     = color;
    }

    /**
     * Gets the brand of the vehicle.
     *
     * @return the brand
     */
    public String getBrand()
    {
        return brand;
    }

    /**
     * Gets the year the vehicle was manufactured.
     *
     * @return the year made
     */
    public int getYearMade()
    {
        return yearMade;
    }

    /**
     * Gets the color of the vehicle.
     *
     * @return the color
     */
    public String getColor()
    {
        return color;
    }

    /**
     * Prints the details of the vehicle.
     */
    public void printDetails()
    {
        System.out.println("Vehicle Details:");
        System.out.println("Brand: " + brand);
        System.out.println("Year: " + yearMade);
        System.out.println("Color: " + color);
    }
}
