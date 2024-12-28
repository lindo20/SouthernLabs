/**
 * Represents a fighter jet, a specific type of airplane with missiles.
 *
 * @author Lindokuhle Dubazane
 * @author Cebisile Masombuka
 * @author Rethabile Sitole
 *
 * @version 1.0
 */
class FighterJet extends Airplane
{
    private final int missileCount;

    /**
     * Constructs a FighterJet object.
     *
     * @param brand   the brand of the fighter jet
     * @param yearMade    the year the fighter jet was manufactured
     * @param color       the color of the fighter jet
     * @param wingspan    the wingspan of the fighter jet in meters
     * @param maxAltitude the maximum altitude of the fighter jet in feet
     * @param missileCount the number of missiles the fighter jet carries
     */
    public FighterJet(final String brand,
                      final int yearMade,
                      final String color,
                      final double wingspan,
                      final int maxAltitude,
                      final int missileCount)
    {
        super(brand, yearMade, color, wingspan, maxAltitude);

        this.missileCount = missileCount;
    }

    /**
     * Gets the number of missiles the fighter jet carries.
     *
     * @return the missile count
     */
    public int getMissileCount()
    {
        return missileCount;
    }

    /**
     * Prints the details of the fighter jet, including missile count.
     */
    public void printDetails()
    {
        super.printDetails();
        System.out.println("Missile Count: " + missileCount);
    }
}
