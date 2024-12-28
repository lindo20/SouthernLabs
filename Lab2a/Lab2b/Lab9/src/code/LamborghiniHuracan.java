/**
 * Represents a Lamborghini Huracan, a specific high-performance car model.
 *
 * @author Lindokuhle Dubazane
 * @author Cebisile Masombuka
 * @author Rethabile Sitole
 *
 * @version 1.0
 */
class LamborghiniHuracan extends Car
{
    private final int topSpeed;
    private final double accelerationTime;

    /**
     * Constructs a LamborghiniHuracan object.
     *
     * @param yearMade         the year the car was manufactured
     * @param color            the color of the car
     * @param topSpeed         the top speed of the car in mph
     * @param accelerationTime the 0-60 mph acceleration time in seconds
     */
    public LamborghiniHuracan(final int yearMade,
                              final String color,
                              final int topSpeed,
                              final double accelerationTime)
    {
        super("Lamborghini", yearMade, color, 2, "V10");

        this.topSpeed = topSpeed;
        this.accelerationTime = accelerationTime;
    }

    /**
     * Gets the top speed of the car.
     *
     * @return the top speed in mph
     */
    public int getTopSpeed()
    {
        return topSpeed;
    }

    /**
     * Gets the acceleration time from 0 to 60 mph.
     *
     * @return the acceleration time in seconds
     */
    public double getAccelerationTime()
    {
        return accelerationTime;
    }

    /**
     * Prints the details of the Lamborghini Huracan, including top speed and acceleration time.
     */
    public final void printDetails()
    {
        super.printDetails();
        System.out.println("Model: Huracan");
        System.out.println("Top speed: " + topSpeed);
        System.out.println("0-60 mph time: " + accelerationTime + " seconds");
    }
}
