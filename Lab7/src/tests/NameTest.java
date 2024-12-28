import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest
{
    Name b1;
    Name b2;
    Name b3;
    Name b4;

    @BeforeEach
    void setUp()
    {
        b1 = new Name("lindokuhle", "dubazane");
        b2 = new Name("given", "sithole");
        b3 = new Name(null, "Zulu");
        b4 = new Name("sam", null);
    }

    @AfterEach
    void tearDown()
    {
        b1 = null;
        b2 = null;
    }


    @Test
    void testFirstName()
    {
        assertEquals("lindokuhle", b1.getFirstName());
        assertEquals("given",b2.getFirstName());
        assertEquals("name cannot be null ",b3.getFirstName());
    }

    @Test
    void testLastName()
    {
        assertEquals("dubazane",b1.getLastName());
        assertEquals("sithole",b2.getLastName());
        assertEquals("name cannot be null ",b4.getLastName());
    }
}