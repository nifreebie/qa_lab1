package task3;

import nifreebie.task3.domain.CauseOfDeath;
import nifreebie.task3.domain.MarketAnalyst;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MarketAnalystTest {
    @Test
    public void marketAnalyst_dies_with_both_causes_and_location_null_after_event() {
        MarketAnalyst ma = new MarketAnalyst(3.0);
        ma.die(CauseOfDeath.SUFFOCATION, CauseOfDeath.AMAZEMENT);
        assertFalse(ma.isAlive());
        assertTrue(ma.getCauses().contains(CauseOfDeath.SUFFOCATION));
        assertTrue(ma.getCauses().contains(CauseOfDeath.AMAZEMENT));
    }
}
