
public class Speedboat extends  Boat
{
    private final int enginePower;

    public Speedboat(final String brand,
                     final int yearMade,
                     final String color,
                     final double length,
                     final int enginePower)
    {
        super("Speedboat", yearMade, color, length);

        this.enginePower = enginePower;
    }

    public int getEnginePower()
    {
        return enginePower;
    }
    public void printDetails()
    {
        super.printDetails();
        System.out.println("Engine Power: " + enginePower + " HP");
    }
}
