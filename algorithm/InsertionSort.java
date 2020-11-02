import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class InsertionSort {
    public static void sort (int[] arr) {
        if (arr.length == 0) return;
        //插入排序执行序号，
        for (int i = 1; i < arr.length; ++i) {
            int current = arr[i];
            int j = i - 1;
            //寻找插入位置：小等于当前值的下标+1
            for (; j>=0; --j) {
                if (arr[j] > current) {
                    arr[j+1] = arr[j]; //向前移动
                }else { break; }
            }
            arr[j+1] = current; //插入数据

        }
    }


}
