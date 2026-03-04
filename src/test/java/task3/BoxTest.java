package task3;

import nifreebie.task3.domain.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleSupplier;

import static org.junit.jupiter.api.Assertions.*;

public class BoxTest {

    private static Location universe;
    private static Planet poghril;
    private static Balloon balloon;
    private static PaperCap paperCap;
    private static List<MarketAnalyst> analysts;
    private static final int EGG_COUNT = 239_000;

    @BeforeAll
    public static void setup() {
        universe = new Location("дальняя Вселенная") {
        };
        poghril = new Planet("Погхрил", "Пансел");
        poghril.setSituation(Situation.STARVATION);
        Box box = new Box(universe);
        balloon = new Balloon();
        box.add(balloon);
        DoubleSupplier alwaysHigh = () -> 0.5;
        paperCap = new PaperCap(alwaysHigh);
        box.add(paperCap);
        analysts = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            MarketAnalyst ma = new MarketAnalyst(3.0);
            analysts.add(ma);
            box.add(ma);
        }
        EggHeap eggHeap = new EggHeap();
        for (int i = 0; i < EGG_COUNT; i++) {
            eggHeap.add(new Egg(EggCondition.FRIED));
        }
        box.add(eggHeap);
        box.openAndEjectTo(poghril);
    }

    @Test
    public void balloon_should_have_sailed_to_universe() {
        assertNotNull(balloon.getLocation());
        assertEquals(universe, balloon.getLocation());
    }

    @Test
    public void paperCap_should_sail_and_not_be_torn_with_high_random() {
        assertFalse(paperCap.isTorn());
        assertEquals(universe, paperCap.getLocation());
    }

    @Test
    public void all_market_analysts_should_be_dead_with_both_causes() {
        for (MarketAnalyst ma : analysts) {
            assertFalse(ma.isAlive());
            assertTrue(ma.getCauses().contains(CauseOfDeath.SUFFOCATION));
            assertTrue(ma.getCauses().contains(CauseOfDeath.AMAZEMENT));
        }
    }

    @Test
    public void eggs_should_be_deposited_on_poghril_with_correct_count_and_condition() {
        assertEquals(1, poghril.getSurfaceItems().size());
        assertInstanceOf(EggHeap.class, poghril.getSurfaceItems().getFirst());
        EggHeap eggHeap = (EggHeap) poghril.getSurfaceItems().getFirst();
        assertEquals(EGG_COUNT, eggHeap.getCount());
        assertTrue(eggHeap.getEggs().stream().allMatch(
                item -> item.getCondition() == EggCondition.FRIED));
    }

    @Test
    public void planet_should_have_starvation_situation() {
        assertEquals(Situation.STARVATION, poghril.getSituation());
    }
}