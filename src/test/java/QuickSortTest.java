import nifreebie.task2.QuickSort;
import nifreebie.task2.Result;
import nifreebie.task2.SortEvent;
import nifreebie.task2.SortState;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickSortTest {
    @Test
    public void testTwoElements() {
        int[] input = {2, 1};
        Result res = QuickSort.sort(input);

        assertArrayEquals(new int[]{1, 2}, res.sorted());

        List<SortEvent> expected = Arrays.asList(
                new SortEvent(SortState.ENTER, 0, 1),
                new SortEvent(SortState.PIVOT, 1, 1),
                new SortEvent(SortState.COMPARE, 0, 1),
                new SortEvent(SortState.SWAP, 0, 1),
                new SortEvent(SortState.EXIT, 0, 1)
        );

        assertEquals(expected, res.events());
    }

    @Test
    public void testThreeElements() {
        int[] input = {3, 1, 2};
        Result res = QuickSort.sort(input);

        assertArrayEquals(new int[]{1, 2, 3}, res.sorted());

        List<SortEvent> expected = Arrays.asList(
                new SortEvent(SortState.ENTER, 0, 2),
                new SortEvent(SortState.PIVOT, 2, 2),
                new SortEvent(SortState.COMPARE, 0, 2),
                new SortEvent(SortState.COMPARE, 1, 2),
                new SortEvent(SortState.SWAP, 0, 1),
                new SortEvent(SortState.SWAP, 1, 2),
                new SortEvent(SortState.EXIT, 0, 2)
        );

        assertEquals(expected, res.events());
    }
}
