/**
 * Represents a biplane, a specific type of airplane with additional attributes like number of wings.
 *
 * @author Lindokuhle Dubazane
 * @author Cebisile Masombuka
 * @author Rethabile Sitole
 *
 * @version 1.0
 *
 */
class Biplane extends Airplane
{
    private final int numberOfWings;

    /**
     * Constructs a new Biplane with the specified attributes.
     *
     * @param brand    the brand of the biplane
     * @param yearMade     the year the biplane was manufactured
     * @param color        the color of the biplane
     * @param wingspan     the wingspan of the biplane in meters
     * @param maxAltitude  the maximum altitude of the biplane in feet
     * @param numberOfWings the number of wings on the biplane
     */
    public Biplane(final String brand,
                   final int yearMade,
                   final String color,
                   final double wingspan,
                   final int maxAltitude,
                   final int numberOfWings)
    {
        super(brand, yearMade, color, wingspan, maxAltitude);

        this.numberOfWings = numberOfWings;
    }

    /**
     * Gets the number of wings on the biplane.
     *
     * @return the number of wings
     */
    public int getNumberOfWings()
    {
        return numberOfWings;
    }

    /**
     * Prints the details of the biplane, including the number of wings.
     */
    public void printDetails()
    {
        super.printDetails();
        System.out.println("Number of Wings: " + numberOfWings);
    }
}
