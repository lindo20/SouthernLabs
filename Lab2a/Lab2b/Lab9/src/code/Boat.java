/**
 * Represents a boat, a type of vehicle designed for water transport.
 *
 * @author Lindokuhle Dubazane
 * @author Cebisile Masombuka
 * @author Rethabile Sitole
 *
 * @version 1.0
 */
class Boat extends Vehicle
{
    private final double length;

    /**
     * Constructs a Boat object.
     *
     * @param brand the brand of the boat
     * @param yearMade  the year the boat was manufactured
     * @param color     the color of the boat
     * @param length    the length of the boat in meters
     */
    public Boat(final String brand,
                final int yearMade,
                final String color,
                final double length)
    {
        super(brand, yearMade, color);

        this.length = length;
    }

    /**
     * Gets the length of the boat.
     *
     * @return the length in meters
     */
    public double getLength()

    {
        return length;
    }

    /**
     * Prints the details of the boat, including its length.
     */
    public void printDetails()
    {
        super.printDetails();
        System.out.println("Length: " + length + " meters");
    }
}
