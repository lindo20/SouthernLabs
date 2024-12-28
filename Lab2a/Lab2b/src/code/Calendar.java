import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Lindokuhle Dubazane
 * @author Given Sitole
 *
 * @version 1.0
 *
 * Represents a Calendar that stores dates from January 1, 1910 to December 30, 2025.
 * Stores each date in a HashMap with a key and a MyDate object.
 */
class Calendar {
    private ArrayList<Integer> years;
    private String[] months;
    private ArrayList<Integer> days;
    private HashMap<Integer, Date> dates;

    /**
     * Constructs a new Calendar object and populates it with MyDate objects from January 1, 1910 to December 30, 2025.
     */
    public Calendar()
    {
        years = new ArrayList<>();
        for (int i = 1910; i <= 2025; i++)
        {
            years.add(i);
        }
        months = new String[]{"January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"};

        days = new ArrayList<>();
        for (int i = 1; i <= 30; i++)
        {
            days.add(i);
        }

        dates = new HashMap<>();

        int key = 1;
        for (Integer year : years)
        {
            for (String month : months)
            {
                for (Iterator<Integer> it = days.iterator(); it.hasNext(); )
                {
                    int day = it.next();
                    Date date = new Date(year, month, day);
                    dates.put(key, date);
                    key++;
                }
            }
        }
    }

    /**
     * Prints each date in the calendar using the keySet of the dates map.
     */
    public void printCalendar()
    {
        for (Integer key : dates.keySet())
        {
            Date date = dates.get(key);
            System.out.println(key + ": " + date.getDate());
        }
    }
}
