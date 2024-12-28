import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest
{
    Name name1;
    Name name2;
    Name name3;
    Name name4;

    @BeforeEach
    void setUp() {
        name1 = new Name("lindokuhle", "dubazane");
        name2 = new Name("given", "sithole");
    }

    @AfterEach
    void tearDown()
    {
        name1 = null;
        name2 = null;
        name3 = null;
        name4 = null;
    }

    @Test
    void testFirstName()
    {
        assertEquals("lindokuhle", name1.getFirstName());
        assertEquals("given", name2.getFirstName());
    }

    @Test
    void testLastName()
    {
        assertEquals("dubazane", name1.getLastName());
        assertEquals("sithole", name2.getLastName());
    }

    @Test
    void testNullFirstName()
    {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            name3 = new Name(null, "Zulu");
        });
        assertEquals("Name cannot be null", exception.getMessage());
    }

    @Test
    void testNullLastName()
    {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            name4 = new Name("sam", null);
        });
        assertEquals("Name cannot be null", exception.getMessage());
    }
}
