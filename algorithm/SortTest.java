import java.util.Arrays;
import java.util.Random;

public class SortTest {
    public static void main(String[] args) {
        int[] arr = new int[300];
        Random r = new Random(1);
        for(int i=0; i<arr.length; i++) {
            arr[i] = r.nextInt(100);
        }
        int[] arr_bak = arr;
        long start1 = System.currentTimeMillis();
        System.out.println("before sort:" + Arrays.toString(arr));
        InsertionSort.sort(arr);
        System.out.println("after sort:" + Arrays.toString(arr));
        System.out.println(String.format("insertion sort cost: %d", System.currentTimeMillis()-start1));

        long start2 = System.currentTimeMillis();
        System.out.println("before sort:" + Arrays.toString(arr_bak));
        BubbleSort.sort(arr_bak);
        System.out.println("after sort:" + Arrays.toString(arr_bak));
        System.out.println(String.format("insertion sort cost: %d", System.currentTimeMillis()-start2));
    }
}
