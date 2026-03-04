package task3;

import nifreebie.task3.domain.Location;
import nifreebie.task3.domain.PaperCap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.function.DoubleSupplier;

import static org.junit.jupiter.api.Assertions.*;

public class PaperCapTest {
    private static Location location;

    @BeforeAll
    public static void setUp() {
        location = new Location("дальняя Вселенная") {};
    }

    @Test
    public void paperCap_should_torn_when_random_lt_threshold() {
        DoubleSupplier alwaysLow = () -> 0.10;
        PaperCap cap = new PaperCap(alwaysLow);
        boolean res = cap.sail(location);
        assertFalse(res);
        assertTrue(cap.isTorn());
        assertNull(cap.getLocation());
    }

    @Test
    public void paperCap_should_sail_when_random_ge_threshold() {
        DoubleSupplier alwaysHigh = () -> 0.5;
        PaperCap cap = new PaperCap(alwaysHigh);
        boolean res = cap.sail(location);
        assertTrue(res);
        assertFalse(cap.isTorn());
        assertEquals(location, cap.getLocation());
    }
}
