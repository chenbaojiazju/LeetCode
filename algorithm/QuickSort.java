public class QuickSort {
    public static void main(String[] args) {
        int[] test = new int[]{9, 3, 4, 6, 3, 6, 77, 45, 34, 6, 7, 8, 9, 0};
        quickSort(test, 0, test.length - 1);
        for (int i = 0; i < test.length; i++) {
            System.out.print(test[i] + ",");
        }
    }

    private static void quickSort(int[] a, int start, int end) {
        if (start < end) {
            int m = partition(a, start, end);
            quickSort(a, start, m - 1);
            quickSort(a, m + 1, end);
        }
    }

    private static int partition(int[] a, int start, int end) {
        int pivot = a[start];
        int solvedAreaTail = start;
        for (int i = start + 1; i < end + 1; i++) {
            if (a[i] > pivot) {
                solvedAreaTail++;
                swap(a, i, solvedAreaTail);
            }
        }
        swap(a, start, solvedAreaTail);
        return solvedAreaTail;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }
}
