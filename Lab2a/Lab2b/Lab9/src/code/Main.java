/**
 * The Main class contains the main method, which creates a list of vehicles
 *
 * @author Lindokuhle Dubazane
 * @author Cebisile Masombuka
 * @author Rethabile Sitole
 *
 * @version 1.0
 */
import java.util.ArrayList;
import java.util.List;
class Main
{
    public static void main(final String[] args)
    {
        final List<Vehicle> vehicles;
        vehicles = new ArrayList<>();

        vehicles.add(new Airplane("Boeing", 2010, "White", 60.0, 35000));
        vehicles.add(new Biplane("Classic Biplane", 1920, "Red", 8.5, 12000, 2));
        vehicles.add(new Boat("Luxury Yacht", 2020, "Blue", 30.0));
        vehicles.add(new Car("Honda", 2018, "Black", 4, "Hybrid"));
        vehicles.add(new FighterJet("Lockheed Martin", 2015, "Gray", 15.0, 50000, 6));
        vehicles.add(new LamborghiniHuracan(2023, "Yellow", 325, 2.9));
        vehicles.add(new Sailboat("Regatta", 2019, "White", 20.0, "Canvas"));
        vehicles.add(new Speedboat("Yamaha", 2022, "Red", 15.0, 450));
        vehicles.add(new ToyotaYaris("Toyota", 2021, "Silver", 4, "Petrol", "Diesel"));

        for(final Vehicle vehicle : vehicles)
        {
            vehicle.printDetails();
            System.out.println();
        }
    }
}
