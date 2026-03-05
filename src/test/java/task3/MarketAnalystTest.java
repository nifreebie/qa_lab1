package task3;

import nifreebie.task3.domain.CauseOfDeath;
import nifreebie.task3.domain.MarketAnalyst;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.*;

public class MarketAnalystTest {

    @Test
    void die_withCauses_setsIsAliveFalseAndStoresCauses() {
        MarketAnalyst ma = new MarketAnalyst(3.0);

        ma.die(CauseOfDeath.SUFFOCATION, CauseOfDeath.AMAZEMENT);

        assertFalse(ma.isAlive());
        EnumSet<CauseOfDeath> causes = ma.getCauses();
        assertTrue(causes.contains(CauseOfDeath.SUFFOCATION));
        assertTrue(causes.contains(CauseOfDeath.AMAZEMENT));
    }

    @Test
    void die_withoutCauses_throwsIllegalArgumentException() {
        MarketAnalyst ma = new MarketAnalyst(3.0);
        assertThrows(IllegalArgumentException.class, ma::die);
    }
}
