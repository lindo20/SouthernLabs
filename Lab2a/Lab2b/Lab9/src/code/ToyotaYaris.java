/**
 * Represents a Toyota Yaris, a specific model of car.
 *
 * @author Lindokuhle Dubazane
 * @author Cebisile Masombuka
 * @author Rethabile Sitole
 *
 * @version 1.0
 */
class ToyotaYaris extends Car
{
    private String fuelType;

    /**
     * Constructs a Toyota Yaris object.
     *
     * @param brand      the brand of the car (e.g., "Toyota")
     * @param yearMade   the year the car was manufactured
     * @param color      the color of the car
     * @param numDoors   the number of doors on the car
     * @param engineType the type of engine in the car (e.g., "V6", "Electric")
     * @param fuelType   the type of fuel the car uses
     */
    public ToyotaYaris(final String brand,
                       final int yearMade,
                       final String color,
                       final int numDoors,
                       final String engineType,
                       final String fuelType)
    {
        super(brand, yearMade, color, numDoors, engineType);

        this.fuelType = fuelType;
    }

    /**
     * Gets the type of fuel the Toyota Yaris uses.
     *
     * @return the fuel type of the car
     */
    public String getFuelType()
    {
        return fuelType;
    }

    /**
     * Prints the details of the Toyota Yaris, including its fuel type,
     * in addition to the details provided by the Car class.
     */
    public void printDetails()
    {
        super.printDetails();
        System.out.println("Fuel Type: " + fuelType);
    }
}
