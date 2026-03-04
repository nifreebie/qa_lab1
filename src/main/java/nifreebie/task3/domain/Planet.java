package nifreebie.task3.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Planet extends Location{
    private final String system;
    @Setter
    private Situation situation;
    private final List<Item> surfaceItems;

    public Planet(String name, String system) {
        super(name);
        this.system = system;
        this.surfaceItems = new ArrayList<>();
    }

    public void deposit(Item item) {
        surfaceItems.add(item);
        item.setLocation(this);
    }
}
