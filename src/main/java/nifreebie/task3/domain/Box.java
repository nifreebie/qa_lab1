package nifreebie.task3.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

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
                case SailableSet set -> set.getSailableItems().forEach( item -> item.sail(defaultUniverseDestination));
                case Balloon balloon -> balloon.sail(defaultUniverseDestination);
                case PaperCap paperCap -> paperCap.sail(defaultUniverseDestination);
                case MarketAnalyst marketAnalyst -> {
                    marketAnalyst.die(CauseOfDeath.SUFFOCATION, CauseOfDeath.AMAZEMENT);
                    marketAnalyst.setLocation(null);
                }
                case EggHeap eggHeap -> planet.deposit(eggHeap);
                case null, default -> throw new IllegalArgumentException("неподдерживаемый тип предмета: " + it.getClass());
            }
        }
    }
}