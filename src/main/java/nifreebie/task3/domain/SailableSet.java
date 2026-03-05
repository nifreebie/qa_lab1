package nifreebie.task3.domain;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class SailableSet extends Item {
    private final Set<Sailable> sailableItems;

    public SailableSet() {
        super();
        this.sailableItems = new HashSet<Sailable>();
    }

    public void add(Sailable sailable) {
        sailableItems.add(sailable);
    }
}
