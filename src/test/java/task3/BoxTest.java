package task3;

import nifreebie.task3.domain.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.*;

public class BoxTest {

    private static Location defaultDest;
    private static Planet poghril;

    @BeforeAll
    static void setup() {
        defaultDest = new Location("дальняя Вселенная") {};
        poghril = new Planet("Погхрил", "Пансель");
    }

    @Test
    void openAndEject_sailableItemsAreSailedAndBoxIsOpened() {
        Box box = new Box(defaultDest);

        SailableSet set = new SailableSet();
        PaperCap cap = new PaperCap(() -> 0.2);
        Balloon balloon = new Balloon();
        set.add(cap);
        set.add(balloon);

        box.add(set);

        assertTrue(box.isClosed());

        box.openAndEjectTo(poghril);

        assertFalse(box.isClosed());
        assertEquals(defaultDest, cap.getLocation());
        assertEquals(defaultDest, balloon.getLocation());
    }

    @Test
    void openAndEject_marketAnalystsDieAndLocationNull() {
        Box box = new Box(defaultDest);

        MarketAnalyst ma1 = new MarketAnalyst(3.0);
        MarketAnalyst ma2 = new MarketAnalyst(3.0);
        box.add(ma1);
        box.add(ma2);

        box.openAndEjectTo(poghril);

        for (MarketAnalyst ma : new MarketAnalyst[]{ma1, ma2}) {
            assertFalse(ma.isAlive());
            EnumSet<CauseOfDeath> causes = ma.getCauses();
            assertTrue(causes.contains(CauseOfDeath.SUFFOCATION));
            assertTrue(causes.contains(CauseOfDeath.AMAZEMENT));
            assertNull(ma.getLocation());
        }
    }

    @Test
    void openAndEject_eggHeapIsDepositedOnPlanet() {
        Box box = new Box(defaultDest);
        EggHeap heap = new EggHeap();
        box.add(heap);

        box.openAndEjectTo(poghril);

        assertEquals(poghril, heap.getLocation());
        assertTrue(poghril.getSurfaceItems().contains(heap));
    }

    @Test
    void openAndEject_nullPlanet_throws() {
        Box box = new Box(defaultDest);
        assertThrows(IllegalArgumentException.class, () -> box.openAndEjectTo(null));
    }

    @Test
    void openAndEject_unsupportedItem_throws() {
        Box box = new Box(defaultDest);
        Item unknown = new Item() {};
        box.add(unknown);

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> box.openAndEjectTo(poghril));
        assertTrue(ex.getMessage().contains("неподдерживаемый тип предмета"));
    }
}