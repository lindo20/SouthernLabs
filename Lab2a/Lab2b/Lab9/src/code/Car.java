/**
 * Represents a car, a type of vehicle designed for road transport.
 *
 * @author Lindokuhle Dubazane
 * @author Cebisile Masombuka
 * @author Rethabile Sitole
 *
 * @version 1.0
 */
class Car extends Vehicle
{
    private final int numberDoors;
    private final String engineType;

    /**
     * Constructs a Car object.
     *
     * @param brand      the brand of the car
     * @param yearMade   the year the car was manufactured
     * @param color      the color of the car
     * @param numDoors   the number of doors in the car
     * @param engineType the type of engine in the car
     */
    public Car(final String brand,
               final int yearMade,
               final String color,
               final int numDoors,
               final String engineType)
    {
        super(brand, yearMade, color);

        this.numberDoors = numDoors;
        this.engineType = engineType;
    }

    /**
     * Gets the number of doors in the car.
     *
     * @return the number of doors
     */
    public int getNumberDoors()
    {
        return numberDoors;
    }

    /**
     * Gets the engine type of the car.
     *
     * @return the engine type
     */
    public String getEngineType()
    {
        return engineType;
    }

    /**
     * Prints the details of the car, including the number of doors and engine type.
     */
    public void printDetails()
    {
       super.printDetails();
        System.out.println("Number of doors: " + numberDoors);
        System.out.println("Engine type: " + engineType);
    }
}
