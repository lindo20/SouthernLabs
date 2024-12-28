import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyTest
{
    Property b1;
    Property b2;

    @BeforeEach
    void setUp()
    {
        b1 = new Property(13, 2, "a123", "Johannesburg");
        b2 = new Property(234, 6, "a456", "JohanNesburG");
    }

    @AfterEach
    void tearDown()
    {
        b1 = null;
        b2 = null;
    }

    @Test
    void getUnitNumber()
    {
        assertEquals(13, b1.getUnitNumber());
        assertEquals(234, b2.getUnitNumber());
    }

    @Test
    void getNumberBedroomBooked()
    {
        assertEquals(2, b1.getNumberBedroomBooked());
        assertEquals(6, b2.getNumberBedroomBooked());
    }

    @Test
    void getAddress()
    {
        assertEquals("a123", b1.getAddress());
        assertEquals("a456", b2.getAddress());
    }

    @Test
    void getCity()
    {
        assertEquals("johannesburg", b1.getCity());
        assertEquals("johannesburg", b2.getCity());
    }
}
