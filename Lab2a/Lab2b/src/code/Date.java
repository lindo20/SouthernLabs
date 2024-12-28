/**
 * @author Lindokuhle Dubazane
 * @author Given Sitole
 *
 * @version 1.0
 * Represents a Date with a year, month, and day.
 */
class Date
{
    private final int year;
    private final String month;
    private final int day;

    /**
     * Constructs a new Date object.
     *
     * @param year  the year of the date
     * @param month the month of the date
     * @param day   the day of the date
     */
    Date(final int year,
         final String month,
         final int day)
    {
        this.year  = year;
        this.month = month;
        this.day   = day;
    }

    /**
     * Returns the year of the date.
     *
     * @return the year
     */
    public int getYear()

    {
        return year;
    }

    /**
     * Returns the month of the date.
     *
     * @return the month
     */
    public String getMonth()
    {
        return month;
    }

    /**
     * Returns the day of the date.
     *
     * @return the day
     */
    public int getDay()
    {
        return day;
    }

    /**
     * Returns a string representation of the date in the format "Month Day, Year".
     *
     * @return the formatted date as a string
     */
    public String getDate()
    {
        return month + day + "," + year;
    }

}