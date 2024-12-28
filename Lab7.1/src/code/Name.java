 class Name
 {
    private final String firstName;
    private final String lastName;

    public Name(final String firstName,
                final String lastName)
    {
        if (firstName == null)
        {
            throw new IllegalArgumentException("Name cannot be null");
        }
            this.firstName = firstName;


        if (lastName == null)
        {
            throw new IllegalArgumentException("Name cannot be null");
        }
            this.lastName = lastName;
    }

    public String getFirstName()
    {
        return firstName.toLowerCase();
    }

    public String getLastName()
    {
        return lastName.toLowerCase();
    }
}
