package nifreebie.task3.domain;

import lombok.Getter;

import java.util.function.DoubleSupplier;

@Getter
public class PaperCap extends Item implements Sailable{
    private boolean isTorn;
    private final DoubleSupplier randomDouble;

    public PaperCap(DoubleSupplier randomDouble) {
        super();
        this.isTorn = false;
        this.randomDouble = randomDouble;
    }

    @Override
    public boolean sail(Location destination) {
        if (isTorn) return false;
        if (randomDouble.getAsDouble() < 0.15) {
            isTorn = true;
            return false;
        }
        this.setLocation(destination);
        return true;
    }
}
