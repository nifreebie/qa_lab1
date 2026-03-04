package nifreebie.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {
    private final List<SortEvent> events = new ArrayList<>();

    public static Result sort(int[] input) {
        int[] a = Arrays.copyOf(input, input.length);
        QuickSort q = new QuickSort();
        q.quickSort(a, 0, a.length - 1);
        return new Result(a, q.events);
    }

    private void quickSort(int[] a, int lo, int hi) {
        if (lo < hi) {
            events.add(new SortEvent(SortState.ENTER, lo, hi));
            int p = partition(a, lo, hi);
            events.add(new SortEvent(SortState.EXIT, lo, hi));
            quickSort(a, lo, p - 1);
            quickSort(a, p + 1, hi);
        }
    }

    private int partition(int[] a, int lo, int hi) {
        int pivot = a[hi];
        events.add(new SortEvent(SortState.PIVOT, hi, pivot));
        int i = lo - 1;
        for (int j = lo; j <= hi - 1; j++) {
            events.add(new SortEvent(SortState.COMPARE, j, hi));
            if (a[j] <= pivot) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, hi);
        return i + 1;
    }

    private void swap(int[] a, int i, int j) {
        events.add(new SortEvent(SortState.SWAP, i, j));
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
