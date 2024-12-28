import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RentalTest
{
    Rental p1;
    Rental p2;

    @BeforeEach
    void setUp()
    {
        p1 = new Rental(21,3,"a123","Johannesburg",2500, 2);
        p2 = new Rental(17,1, "a456,", "Johannesburg", 400, 1);
    }

    @AfterEach
    void tearDown()
    {
            p1 = null;
            p2 = null;
    }

    @Test
    void getRentalPriceUsd()
    {
        assertEquals(2500, p1.getRentalPriceUsd());
        assertEquals(400, p2.getRentalPriceUsd());
    }

    @Test
    void getLeaseLengthMonths()
    {
        assertEquals(12, p1.getLeaseLengthMonths());
        assertEquals(1, p2.getLeaseLengthMonths());

    }

}