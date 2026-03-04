package nifreebie.task3.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Egg extends Item{
    private EggCondition condition;

    public Egg(EggCondition condition) {
        super();
        this.condition = condition;
    }
}
