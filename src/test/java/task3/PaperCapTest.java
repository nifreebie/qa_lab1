package task3;

import nifreebie.task3.domain.Location;
import nifreebie.task3.domain.PaperCap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PaperCapTest {

    private static Location destination;

    @BeforeAll
    static void setup() {
        destination = new Location("дальняя Вселенная") {};
    }

    @Test
    void sail_whenRandomLessThanThreshold_becomesTornAndReturnsFalse() {
        PaperCap cap = new PaperCap(() -> 0.1);

        boolean result = cap.sail(destination);

        assertFalse(result);
        assertTrue(cap.isTorn());
        assertNull(cap.getLocation());
    }

    @Test
    void sail_whenRandomAboveThreshold_setsLocationAndReturnsTrue() {
        PaperCap cap = new PaperCap(() -> 0.2);

        boolean result = cap.sail(destination);

        assertTrue(result);
        assertFalse(cap.isTorn());
        assertEquals(destination, cap.getLocation());
    }
}
