package task3;

import nifreebie.task3.domain.Balloon;
import nifreebie.task3.domain.Location;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BalloonTest {
    @Test
    public void balloon_should_sail_to_universe() {
        Location universe = new Location("дальняя Вселенная") {};
        Balloon b = new Balloon();
        assertTrue(b.sail(universe));
        assertEquals(universe, b.getLocation());
    }
}
