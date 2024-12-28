/**
 * @author Lindokuhle Dubazane
 * @author Cebisile Masombuka
 * @author Rethabile sitole
 *
 * @version 1.0
 *
 */
class Main
{
    public static void main(final String[] args)
    {
        final Person p1;
        final Person p2;
        final Person p3;

        p1 = new Person("Tiger", "Woods", 1975, "divorced", 200, "undergraduate");
        p2 = new Person("Jason", "Wilder", 2000, "no", 180, "graduate");
        p3 = new Person("Santa", "Claus", 1000, "yes", 280, "high school");

        p1.printDetails();
        p1.printDetails(true);
        p1.printDetails(true, true);
        p1.printDetails(true, false);
        p1.printDetails(false, true);
        p1.printDetails(false, false);

        p2.printDetails();
        p2.printDetails(true);
        p2.printDetails(true, true);
        p2.printDetails(true, false);
        p2.printDetails(false, true);
        p2.printDetails(false, false);

        p3.printDetails();
        p3.printDetails(true);
        p3.printDetails(true, true);
        p3.printDetails(true, false);
        p3.printDetails(false, true);
        p3.printDetails(false, false);
    }
}
