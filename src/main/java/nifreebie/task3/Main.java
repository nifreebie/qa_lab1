package nifreebie.task3;

import nifreebie.task3.domain.*;

public class Main {
    private static final int EGG_COUNT = 239_000;
    private static final int ANALYST_COUNT = 7;
    private static final int SAIlABLE_ITEMS_COUNT = 3;

    public static void main(String[] args) {
        SailableSet sailableSet = new SailableSet();
        for (int i = 0; i < SAIlABLE_ITEMS_COUNT; i++) {
            PaperCap paperCap = new PaperCap(Math::random);
            Balloon balloon = new Balloon();
            sailableSet.add(paperCap);
            sailableSet.add(balloon);
        }

        EggHeap eggHeap = new EggHeap();
        for (int i = 0; i < EGG_COUNT; i++) {
            Egg egg = new Egg(Math.random(), EggCondition.FRIED);
            eggHeap.add(egg);
        }

        Planet planet = new Planet("Погхрил", "Пансель");
        Location location = new Location("дальняя Вселенная") {};

        Box box = new Box(location);

        box.add(sailableSet);
        box.add(eggHeap);
        for(int i = 0; i < ANALYST_COUNT; i++) {
            MarketAnalyst ma = new MarketAnalyst(3.0);
            box.add(ma);
        }

        box.openAndEjectTo(planet);

    }
}
