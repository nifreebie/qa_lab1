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
    public void testEmptyArray() {
        int[] input = {};
        Result res = QuickSort.sort(input);

        assertArrayEquals(new int[]{}, res.sorted());
        assertEquals(List.of(), res.events());
    }

    @Test
    public void testSingleElement() {
        int[] input = {5};
        Result res = QuickSort.sort(input);

        assertArrayEquals(new int[]{5}, res.sorted());
        assertEquals(List.of(), res.events());
    }

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

    @Test
    public void testAlreadySortedThree() {
        int[] input = {1, 2, 3};
        Result res = QuickSort.sort(input);

        assertArrayEquals(new int[]{1, 2, 3}, res.sorted());

        List<SortEvent> expected = Arrays.asList(
                new SortEvent(SortState.ENTER, 0, 2),
                new SortEvent(SortState.PIVOT, 2, 3),
                new SortEvent(SortState.COMPARE, 0, 2),
                new SortEvent(SortState.SWAP, 0, 0),
                new SortEvent(SortState.COMPARE, 1, 2),
                new SortEvent(SortState.SWAP, 1, 1),
                new SortEvent(SortState.SWAP, 2, 2),
                new SortEvent(SortState.EXIT, 0, 2),

                new SortEvent(SortState.ENTER, 0, 1),
                new SortEvent(SortState.PIVOT, 1, 2),
                new SortEvent(SortState.COMPARE, 0, 1),
                new SortEvent(SortState.SWAP, 0, 0),
                new SortEvent(SortState.SWAP, 1, 1),
                new SortEvent(SortState.EXIT, 0, 1)
        );

        assertEquals(expected, res.events());
    }

    @Test
    public void testReversedThree() {
        int[] input = {3, 2, 1};
        Result res = QuickSort.sort(input);

        assertArrayEquals(new int[]{1, 2, 3}, res.sorted());

        List<SortEvent> expected = Arrays.asList(
                new SortEvent(SortState.ENTER, 0, 2),
                new SortEvent(SortState.PIVOT, 2, 1),
                new SortEvent(SortState.COMPARE, 0, 2),
                new SortEvent(SortState.COMPARE, 1, 2),
                new SortEvent(SortState.SWAP, 0, 2),
                new SortEvent(SortState.EXIT, 0, 2),

                new SortEvent(SortState.ENTER, 1, 2),
                new SortEvent(SortState.PIVOT, 2, 3),
                new SortEvent(SortState.COMPARE, 1, 2),
                new SortEvent(SortState.SWAP, 1, 1),
                new SortEvent(SortState.SWAP, 2, 2),
                new SortEvent(SortState.EXIT, 1, 2)
        );

        assertEquals(expected, res.events());
    }

    @Test
    public void testAllEqual() {
        int[] input = {1, 1, 1};
        Result res = QuickSort.sort(input);

        assertArrayEquals(new int[]{1, 1, 1}, res.sorted());

        List<SortEvent> expected = Arrays.asList(
                new SortEvent(SortState.ENTER, 0, 2),
                new SortEvent(SortState.PIVOT, 2, 1),
                new SortEvent(SortState.COMPARE, 0, 2),
                new SortEvent(SortState.SWAP, 0, 0),
                new SortEvent(SortState.COMPARE, 1, 2),
                new SortEvent(SortState.SWAP, 1, 1),
                new SortEvent(SortState.SWAP, 2, 2),
                new SortEvent(SortState.EXIT, 0, 2),

                new SortEvent(SortState.ENTER, 0, 1),
                new SortEvent(SortState.PIVOT, 1, 1),
                new SortEvent(SortState.COMPARE, 0, 1),
                new SortEvent(SortState.SWAP, 0, 0),
                new SortEvent(SortState.SWAP, 1, 1),
                new SortEvent(SortState.EXIT, 0, 1)
        );

        assertEquals(expected, res.events());
    }

    @Test
    public void testWithNegatives() {
        int[] input = {0, -1, 5, -3};
        Result res = QuickSort.sort(input);

        assertArrayEquals(new int[]{-3, -1, 0, 5}, res.sorted());

        List<SortEvent> expected = Arrays.asList(
                new SortEvent(SortState.ENTER, 0, 3),
                new SortEvent(SortState.PIVOT, 3, -3),
                new SortEvent(SortState.COMPARE, 0, 3),
                new SortEvent(SortState.COMPARE, 1, 3),
                new SortEvent(SortState.COMPARE, 2, 3),
                new SortEvent(SortState.SWAP, 0, 3),
                new SortEvent(SortState.EXIT, 0, 3),

                new SortEvent(SortState.ENTER, 1, 3),
                new SortEvent(SortState.PIVOT, 3, 0),
                new SortEvent(SortState.COMPARE, 1, 3),
                new SortEvent(SortState.SWAP, 1, 1),
                new SortEvent(SortState.COMPARE, 2, 3),
                new SortEvent(SortState.SWAP, 2, 3),
                new SortEvent(SortState.EXIT, 1, 3)
        );

        assertEquals(expected, res.events());
    }
}
