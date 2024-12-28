/**
 * This Class represents a person with attributes such as name, birth year, marital status,
 * weight, and education level.
 *
 * @author Lindokuhle Dubazane
 * @author Cebisile Masombuka
 * @author Rethabile Sitole
 *
 * @version 1.0
 *
 */

class Person
{
    private final String firstName;
    private final String lastName;
    private final int birthYear;
    private final String married;
    private final double weightPounds;
    private final String highestEducationLevel;

    public static final int CURRENT_YEAR = 2024;
    public static final double weightConvert = 0.453592;

    /**
     * Constructs a Person object with all attributes.
     *
     * @param firstName             The first name of the person.
     * @param lastName              The last name of the person.
     * @param birthYear             The year the person was born.
     * @param married               The marital status (yes/no/single/married/divorced).
     * @param weightPounds          The weight of the person in pounds.
     * @param highestEducationLevel The highest education level (high school, undergraduate, graduate).
     * @throws IllegalArgumentException If education level or marital status is invalid.
     */
    public Person(final String firstName,
                  final String lastName,
                  final int birthYear,
                  final String married,
                  final double weightPounds,
                  final String highestEducationLevel)
    {
        if (!isValidEducationLevel(highestEducationLevel) || !isValidMarriageStatus(married))
        {
            throw new IllegalArgumentException("Invalid education level or marriage status.");
        }

        this.firstName              = firstName;
        this.lastName               = lastName;
        this.birthYear              = birthYear;
        this.married                = married;
        this.weightPounds           = weightPounds;
        this.highestEducationLevel  = highestEducationLevel;
    }


    /**
     * Constructs a Person object with default birth year and marital status.
     *
     * @param firstName    The first name of the person.
     * @param lastName     The last name of the person.
     * @param weightPounds The weight of the person in pounds.
     */
    public Person(final String firstName,
                  final String lastName,
                  final String married,
                  final double weightPounds,
                  final String highestEducationLevel)
    {

        this.firstName             = firstName;
        this.lastName              = lastName;
        this.birthYear             = CURRENT_YEAR;
        this.married               = married;
        this.weightPounds          = weightPounds;
        this.highestEducationLevel = highestEducationLevel;
    }

    /**
     * Constructs a Person object with default birth year and marital status.
     *
     * @param firstName    The first name of the person.
     * @param lastName     The last name of the person.
     * @param weightPounds The weight of the person in pounds.
     */

    public Person(final String firstName,
                  final String lastName,
                  final double weightPounds)
    {
        this.firstName             = firstName;
        this.lastName              = lastName;
        this.birthYear             = CURRENT_YEAR;
        this.married               = "no";
        this.weightPounds          = weightPounds;
        this.highestEducationLevel = "high school";
    }

    /**
     * Validates the given education level.
     *
     * @param educationLevelToVerify The education level to validate.
     * @return True if the education level is valid, otherwise false.
     */
    private boolean isValidEducationLevel(final String educationLevelToVerify)
    {
        if(educationLevelToVerify.equals("high school"))
        {
            return true;
        }
        else if(educationLevelToVerify.equals("undergraduate"))
        {
            return true;
        }
        else if(educationLevelToVerify.equals("graduate"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Validates the given marital status.
     *
     * @param status The marital status to validate.
     * @return True if the marital status is valid, otherwise false.
     */
    private boolean isValidMarriageStatus(final String status)
    {
        if(status.equals("yes"))
        {
            return true;

        } else if(status.equals("no"))
        {
            return true;

        } else if(status.equals("divorced"))
        {
           return true;

        } else
            return false;
    }

    public void printDetails()
    {
        printDetails(false, false);
    }

    /**
     * Prints the person's details, optionally converting weight to kilograms.
     *
     * @param kilograms True to convert weight to kilograms, otherwise prints in pounds.
     */
    public void printDetails(final boolean kilograms)
    {
        printDetails(kilograms, false);
    }

    /**
     * Prints the person's details, optionally converting weight to kilograms
     * and formatting the name in uppercase.
     *
     * @param kilograms True to convert weight to kilograms, otherwise prints in pounds.
     * @param uppercase True to print the name in uppercase, otherwise in lowercase.
     */
    public void printDetails(final boolean kilograms, final boolean uppercase)
    {
        final double weight;
        final String weightUnit;
        final String name;
        final String displayMaritalStatus;


        if(married.equals("yes"))
        {
            displayMaritalStatus = "married";

        } else if(married.equals("no"))
        {
            displayMaritalStatus = "single";

        } else
        {
            displayMaritalStatus = married;
        }


        if(kilograms)
        {
            weight = weightPounds * weightConvert;
            weightUnit = "kilograms";
        } else
        {
            weight = weightPounds;
            weightUnit = "pounds";
        }

        if(uppercase)
        {
            name = (firstName + lastName).toUpperCase();
        } else
        {
            name = (firstName +  lastName).toLowerCase();
        }


        System.out.println(String.format(
                "%s (%s) was born in %d, weighs %.1f %s, and has an %s degree!",
                name, displayMaritalStatus, birthYear, weight, weightUnit, highestEducationLevel));
    }


}
