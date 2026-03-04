package nifreebie.task2;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

public record SortEvent(SortState state, List<Integer> params) {
    public SortEvent(SortState state, int... params) {
        this(state, buildList(params));
    }

    private static List<Integer> buildList(int... params) {
        List<Integer> tmp = new ArrayList<>();
        for (int p : params) tmp.add(p);
        return Collections.unmodifiableList(tmp);
    }
}