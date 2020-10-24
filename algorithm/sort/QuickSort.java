package sort;

/**
 * @author 陈包佳
 * @version 1.0
 * @date 2020/10/21 20:05
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] i = new int[]{1, 3, 10, 2, 11, 23, 0, 10};
        quickSort(i, 0, i.length-1);
        for (int j = 0; j < i.length; j++) {
            System.out.print(i[j] + ",");
        }
    }

    private static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int m = partition(array, start, end);
            quickSort(array, 0, m-1);
            quickSort(array, m+1, end);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[low];
        int j = low;//已处理区域（小于标准的数）末尾下标
        for (int i = low + 1; i < high+1 ; i++) {
            if (array[i] <= pivot) {
                j++;//腾出一个位置
                swap(array, i, j);
            }
        }
        swap(array, low, j);//移动标准数据到末尾下标
        return j;
    }
}
