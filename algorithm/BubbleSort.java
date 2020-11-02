import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

/**
 * 从小到大冒泡排序
 */
public class BubbleSort {
    public static void sort (int[] arr) {
        if ( arr.length  <= 0 ) return;
        // i 冒泡的次数
        boolean changed = false;
        for ( int i = 1; i < arr.length; i++ ) {
            for ( int j = 0; j < arr.length-i; j++) {
                if ( arr[j] > arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    changed = true;
                }
            }
            if (!changed) break;
        }
    }



}
