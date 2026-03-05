package task3;

import nifreebie.task3.domain.EggHeap;
import nifreebie.task3.domain.Planet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlanetTest {

    @Test
    void deposit_addsItemToSurfaceAndSetsItemLocation() {
        Planet planet = new Planet("Погхрил", "Пансель");
        EggHeap heap = new EggHeap();

        planet.deposit(heap);

        assertTrue(planet.getSurfaceItems().contains(heap));
        assertEquals(planet, heap.getLocation());
    }
}