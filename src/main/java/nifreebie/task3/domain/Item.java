package nifreebie.task3.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
public abstract class Item {
    private final UUID id;
    @Setter
    private Location location;

    public Item() {
        this.id = UUID.randomUUID();
    }
}
