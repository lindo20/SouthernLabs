class Name
{
    private final String firstName;
    private final String lastName;

    Name(final String firstName,
         final String lastName)
    {
        if(firstName == null)
        {
           this.firstName = "Name cannot be null ";
        }
        else
        {
            this.firstName = firstName;
        }


        if(lastName == null)
        {
            this.lastName = "Name cannot be null ";
        }
        else
        {
            this.lastName = lastName;
        }
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
