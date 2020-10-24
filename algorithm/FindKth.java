import java.util.*;

public class FindKth {

    public int findKth(int[] a, int n, int K) {
        return findKth(a, 0, n-1, K);
    }

    private int findKth(int[] a, int start, int end, int K) {
        int m = partition(a, start, end);
        if (m + 1 == K) {
            return a[m];
        } else if (m + 1 < K) {
            return findKth(a, m + 1, end, K);
        } else {
            return findKth(a, start, m - 1, K);
        }
    }

    private int partition(int[] a, int start, int end){
        int pivot = a[start];
        int tail = start;
        for (int i = start + 1; i < end + 1; i++) {
            if (a[i] > pivot) {
                tail++;
                swap(a, i, tail);
            }
        }
        swap(a, start, tail);
        return tail;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}