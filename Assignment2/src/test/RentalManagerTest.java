import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class RentalManagerTest
{
    RentalManager b1;

    @BeforeEach
    void setUp()
    {
        b1 = new RentalManager("Test Agency");
    }

    @AfterEach
    void tearDown()
    {
        b1 = null;
    }

    @Test
    void testLoadRentalsFromFile_ValidFile()
    {
        String testFileName = createTempFile(
                "1500.00, 101, 123 Main St, Cityville, 12345, 2, Apartment, A101\n" +
                        "2000.00, 202, 456 Oak Rd, Townsburg, 67890, 3, House, H202"
        );

        b1.loadRentalsFromFile(testFileName);

    }

    @Test
    void testLoadRentalsFromFile_InvalidFileFormat()
    {
        String testFileName = createTempFile(
                "1500.00, 101, 123 Main St, Cityville, 12345, TWO, Apartment, A101\n" +
                        "INVALID, 202, 456 Oak Rd, Townsburg, 67890, 3, House, H202"
        );

        b1.loadRentalsFromFile(testFileName);

    }

    @Test
    void testLoadRentalsFromFile_IncompleteLine()
    {
        String testFileName = createTempFile(
                "1500.00, 101, 123 Main St, Cityville\n" +
                        "2000.00, 202, 456 Oak Rd, Townsburg, 67890, 3, House, H202"
        );

        b1.loadRentalsFromFile(testFileName);

    }

    @Test
    void testLoadRentalsFromFile_NonExistentFile()
    {
        b1.loadRentalsFromFile("non_existent_file.txt");

    }

    private String createTempFile(String content)
    {
        try
        {
            File tempFile = File.createTempFile("rental_test_", ".txt");
            tempFile.deleteOnExit();

            try(FileWriter writer = new FileWriter(tempFile))
            {
                writer.write(content);
            }

            return tempFile.getAbsolutePath();
        }
        catch (IOException e)
        {
            fail("Could not create temporary test file: " + e.getMessage());
            return null;
        }
    }
}
