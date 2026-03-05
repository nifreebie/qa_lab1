package nifreebie.task3.domain;

import lombok.Getter;

import java.util.PriorityQueue;

@Getter
public class EggHeap extends Item{
    private int count;
    private final PriorityQueue<Egg> eggs;

    public EggHeap() {
        super();
        this.eggs = new PriorityQueue<>();
    }

    public void add(Egg egg) {
        eggs.add(egg);
        count++;
    }
}
