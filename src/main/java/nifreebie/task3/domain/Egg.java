package nifreebie.task3.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Egg extends Item implements Comparable<Egg> {
    private double size;
    private EggCondition condition;

    public Egg(double size, EggCondition condition) {
        super();
        this.size = size;
        this.condition = condition;
    }

    @Override
    public int compareTo(Egg eggToCompare) {
        return Double.compare(this.size, eggToCompare.size);
    }
}
