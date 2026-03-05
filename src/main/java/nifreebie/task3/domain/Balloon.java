package nifreebie.task3.domain;

public class Balloon extends Item implements Sailable {
    public Balloon() {
        super();
    }

    @Override
    public boolean sail(Location destination) {
        this.setLocation(destination);
        return true;
    }
}
