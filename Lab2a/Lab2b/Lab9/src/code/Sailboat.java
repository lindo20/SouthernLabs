/**
 * Represents a sailboat, a specific type of boat powered by sails.
 *
 * @author Lindokuhle Dubazane
 * @author Cebisile Masombuka
 * @author Rethabile Sitole
 *
 * @version 1.0
 */
class Sailboat extends Boat
{
    private final String sailMaterial;

    /**
     * Constructs a Sailboat object.
     *
     * @param brandName    the brand of the sailboat
     * @param yearMade     the year the sailboat was manufactured
     * @param color        the color of the sailboat
     * @param length       the length of the sailboat in meters
     * @param sailMaterial the type material of the sailboat has
     */
    public Sailboat(final String brandName,
                    final int yearMade,
                    final String color,
                    final double length,
                    final String sailMaterial)
    {
        super("Sailboat", yearMade, color, length);
        this.sailMaterial = sailMaterial;
    }

    /**
     * Gets the number of sails on the sailboat.
     *
     * @return the material of sails
     */
    public String getSailMaterial()
    {
        return sailMaterial;
    }

    /**
     * Prints the details of the sailboat, including the type of materials of sails.
     */
    public final void printDetails()
    {
        super.printDetails();
        System.out.println("Sail Material: " + sailMaterial);
    }
}
