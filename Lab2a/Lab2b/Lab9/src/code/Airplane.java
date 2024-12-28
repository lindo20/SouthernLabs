/**
 * Represents an airplane, a type of vehicle with specific attributes like wingspan and maximum altitude.
 *
 * @author Lindokuhle Dubazane
 * @author Cebisile Masombuka
 * @author Rethabile Sitole
 *
 * @version 1.0
 *
 */
class Airplane extends Vehicle
{
    private final double wingspan;
    private final int maxAltitude;

    /**
     * Constructs a new Airplane with the specified attributes.
     *
     * @param brand   the brand of the airplane
     * @param yearMade    the year the airplane was manufactured
     * @param color       the color of the airplane
     * @param wingspan    the wingspan of the airplane in meters
     * @param maxAltitude the maximum altitude of the airplane in feet
     */
    public Airplane(final String brand,
                    final int yearMade,
                    final String color,
                    final double wingspan,
                    final int maxAltitude)
    {
        super(brand, yearMade, color);

        this.wingspan = wingspan;
        this.maxAltitude = maxAltitude;
    }

    /**
     * Gets the wingspan of the airplane.
     *
     * @return the wingspan in meters
     */
    public double getWingspan()
    {
        return wingspan;
    }

    /**
     * Gets the maximum altitude of the airplane.
     *
     * @return the maximum altitude in feet
     */
    public int getMaxAltitude()
    {
        return maxAltitude;
    }


    /**
     * Prints the details of the airplane, including wingspan and maximum altitude.
     */
    public void printDetails()
    {
        super.printDetails();
        System.out.println("Wingspan: " + wingspan + " meters");
        System.out.println("Maximum altitude: " + maxAltitude + " feet");
    }
}
