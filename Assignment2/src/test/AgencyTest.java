import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgencyTest
{
    Agency b1;
    Agency b2;
    Rental rental1;
    Rental rental2;

    @BeforeEach
    void setUp()
    {
        b1 = new Agency("A123");
        b2 = new Agency("A456");


        rental1 = new Rental(124, 2, null, "City X", 2500, 12);
        rental2 = new Rental(102, 3, "Street B", "City Y", 3500, 24);
    }

    @AfterEach
    void tearDown()
    {
        b1 = null;
        b2 = null;
        rental1 = null;
        rental2 = null;
    }

    @Test
    void addRental()
    {
        b1.addRental(rental1);
        assertEquals(2500, b1.getRentalsBetween(2000, 3000).get(rental1.getUnitNumber()).getRentalPriceUsd());

    }

    @Test
    void getRentalsBetween()
    {
        b1.addRental(rental1);
        b1.addRental(rental2);

        assertEquals(1, b1.getRentalsBetween(2000, 3000).size());
        assertEquals(2, b1.getRentalsBetween(2000, 4000).size());
    }

    @Test
    void getTotalRentalIncome()
    {
        b1.addRental(rental1);
        b1.addRental(rental2);

        double expectedIncome = (2500 * 12) + (3500 * 24);
        assertEquals(expectedIncome, b1.getTotalRentalIncome());
    }

    @Test
    void getAgencyName()
    {
        assertEquals("A123", b1.getAgencyName());
        assertEquals("A456", b2.getAgencyName());
    }
}
