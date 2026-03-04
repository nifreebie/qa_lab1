package nifreebie.task3.domain;// Box.java
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class Box {
    private final List<Item> contents = new ArrayList<>();
    private boolean closed;
    private final Location defaultUniverseDestination;

    public Box(Location defaultUniverseDestination) {
        this.defaultUniverseDestination = defaultUniverseDestination;
        this.closed = true;
    }

    public void add(Item item) { contents.add(item); }

    public void openAndEjectTo(Planet planet) {
        if (planet == null) throw new IllegalArgumentException("планеты не должна быть null");
        closed = false;
        for (Item it : new ArrayList<>(contents)) {
            switch (it) {
                case Balloon balloon -> balloon.sail(defaultUniverseDestination);
                case PaperCap paperCap -> paperCap.sail(defaultUniverseDestination);
                case MarketAnalyst marketAnalyst -> {
                    marketAnalyst.die(CauseOfDeath.SUFFOCATION, CauseOfDeath.AMAZEMENT);
                    marketAnalyst.setLocation(null);
                }
                case EggHeap eggHeap -> planet.deposit(eggHeap);
                case null, default -> throw new IllegalArgumentException("неподдерживаемых тип предмета: " + it.getClass());
            }
        }
    }
}