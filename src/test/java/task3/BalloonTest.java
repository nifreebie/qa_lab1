package task3;

import nifreebie.task3.domain.Balloon;
import nifreebie.task3.domain.Location;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BalloonTest {

    private static Location destination;

    @BeforeAll
    static void setup() {
        destination = new Location("дальняя Вселенная") {};
    }

    @Test
    void balloon_sail_setsLocationAndReturnsTrue() {
        Balloon balloon = new Balloon();

        boolean result = balloon.sail(destination);

        assertTrue(result);
        assertEquals(destination, balloon.getLocation());
    }
}