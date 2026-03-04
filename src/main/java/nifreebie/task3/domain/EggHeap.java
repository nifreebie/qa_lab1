package nifreebie.task3.domain;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class EggHeap extends Item{
    private int count;
    private final Set<Egg> eggs;

    public EggHeap() {
        super();
        this.eggs = new HashSet<>();
    }

    public void add(Egg egg) {
        eggs.add(egg);
        count++;
    }

    void remove(Egg egg) {
        if(count == 0) return;
        eggs.remove(egg);
        count--;
    }
}
