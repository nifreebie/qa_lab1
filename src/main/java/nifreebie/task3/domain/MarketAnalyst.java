package nifreebie.task3.domain;

import lombok.Getter;
import java.util.EnumSet;


@Getter
public class MarketAnalyst extends Item{
    private final double heightFeet;
    private boolean isAlive;
    private EnumSet<CauseOfDeath> causes = EnumSet.noneOf(CauseOfDeath.class);

    public MarketAnalyst(double heightFeet) {
        super();
        this.isAlive = true;
        this.heightFeet = heightFeet;
    }

    public void die(CauseOfDeath... causes) {
        if (causes == null || causes.length == 0) {
            throw new IllegalArgumentException();
        }
        this.isAlive = false;
        this.causes = EnumSet.of(causes[0], causes);
    }
}
