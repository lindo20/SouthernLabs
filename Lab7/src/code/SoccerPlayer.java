class SoccerPlayer
{
    private static final int MIN_NUMBER            = 1;
    private static final int MAX_NUMBER            = 99;
    private static final int INVALID_JERSEY_NUMBER = -1;

    private  Name name;
    private final int jerseyNumber;
    private final String position;
    private final String team;

    public SoccerPlayer(final Name name,
                        final int jerseyNumber,
                        final String position,
                        final String team)
    {
        if(team == null || team.trim().isEmpty())
        {
            this.team = "Team name must not be null nor blank";
        }
        else
        {
            this.team = team;
        }

        if(jerseyNumber < MIN_NUMBER || jerseyNumber > MAX_NUMBER)
        {
            this.jerseyNumber = INVALID_JERSEY_NUMBER; // not sure for this part chatgpt helped
        }
        else
        {
            this.jerseyNumber = jerseyNumber;
        }

        if(name == null)
        {
            throw new IllegalArgumentException("Invalid name: null"); // not sure if we supported to use IllegalArgument
                                                                      // but the rest was done in class
        }
        this.name = name;


        if(position.equals("right wing") || position.equals("left wing")||
           position.equals("center") || position.equals("midfield")||
           position.equals("defense") || position.equals("goaltender"))
        {
            this.position = position;
        }
        else
        {
            this.position = "invalid position!!!";
        }
    }

    public Name getName()
    {
        return name;
    }

    public int getJerseyNumber()
    {
        return jerseyNumber;
    }

    public String getPosition()
    {
        return position.toLowerCase();
    }

    public String getTeam()
    {
        return team.toLowerCase();
    }
}
