import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoccerPlayerTest
{
    Name name;
    SoccerPlayer b1;
    SoccerPlayer b2;
    SoccerPlayer b3;
    SoccerPlayer b4;
    SoccerPlayer b5;
    SoccerPlayer b6;

    @BeforeEach
    void setUp()
    {
        name = new Name("Lindokuhle", "Dubazane");

        b1 = new SoccerPlayer(name, 12, "right wing", null);
        b2 = new SoccerPlayer(name, 99, "left wing", " ");
        b3 = new SoccerPlayer(name, 1, "center", "SouthernLab");
        b4 = new SoccerPlayer(name, 55, "midfield", "UL");
        b5 = new SoccerPlayer(name, 90, "defense", "KC");
        b6 = new SoccerPlayer(name, 0, "center", "FC");
    }

    @AfterEach
    void tearDown()
    {
        b1 = null;
        b2 = null;
        b3 = null;
        b4 = null;
        b5 = null;
        b6 = null;
    }

    @Test
    void testJerseyNumber()
    {
        assertEquals(12, b1.getJerseyNumber());
        assertEquals(99, b2.getJerseyNumber());
        assertEquals(1, b3.getJerseyNumber());
        assertEquals(55, b4.getJerseyNumber());
        assertEquals(90, b5.getJerseyNumber());

        // Check that invalidPlayer's jersey number is set to -1
        assertEquals(-1, b6.getJerseyNumber());
    }

    @Test
    void testPosition()
    {
        assertEquals("right wing", b1.getPosition());
        assertEquals("left wing", b2.getPosition());
        assertEquals("center", b3.getPosition());
        assertEquals("midfield", b4.getPosition());
        assertEquals("defense", b5.getPosition());
    }

    @Test
    void testTeam()
    {
        assertEquals("team name must not be null nor blank", b1.getTeam());
        assertEquals("team name must not be null nor blank", b2.getTeam());
        assertEquals("southernlab", b3.getTeam());
        assertEquals("ul", b4.getTeam());
        assertEquals("kc", b5.getTeam());
    }
}
