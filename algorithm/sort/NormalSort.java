package sort;

/**
 * @author 陈包佳
 * @version 1.0
 * @date 2020/11/6 20:10
 */
public class NormalSort {

    public static void main(String[] args) {
        int[] data = {4, 8, 6, 3, 5, 10, 2, 7, 3, 5, 1, 9};
        qs(data, 0, data.length - 1);
        StringBuilder result = new StringBuilder("[");
        for (int a : data) {
            result.append(a + ", ");
        }
        result.setCharAt(result.lastIndexOf(", "), ']');
        System.out.println(result);
    }

    private static void qs(int[] data, int start, int end) {
        if (start >= end) {
            return;
        }
        int m = par(data, start, end);
        qs(data, start, m - 1);
        qs(data, m + 1, end);
    }

    private static int par(int[] data, int start, int end) {
        int stand = data[start];
        int tail = start;
        for (int i = start + 1; i <= end; i++) {
            if (data[i] < stand) {
                tail++;
                int temp = data[i];
                data[i] = data[tail];
                data[tail] = temp;
            }
        }
        int temp = data[tail];
        data[tail] = stand;
        data[start] = temp;
        return tail;
    }

    /**
     * 冒泡排序升序
     * 每一次冒泡将最大值放入头部
     * @param data
     */
    private static void bubbleSort(int[] data) {
        int len = data.length;
        if (len <= 1) {
            return;
        }
        boolean change = false;
        //冒泡次数
        for (int i = 1; i <= len - 1; i++) {
            //遍历比较
            for (int j = 0; j <= len - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    change = true;
                }
            }
            if (!change) {
                break;
            }
        }
    }

    /**
     * 插入排序，随着下标增加，将当前值插入前面的有序区使其继续保持有序，有移动操作
     * @param data
     */
    private static void insertSort(int[] data) {
        int len = data.length;
        if (len <= 1) {
            return;
        }
        for (int i = 1; i <= len - 1; i++) {
            //目标的初始值设置很关键
            int target = i;
            int cur = data[i];
            for (int j = 0; j <= i - 1; j++) {
                //此实现不是原地排序，需要从后面开始遍历，找到位置从后面插入
                if (cur < data[j]) {
                    System.arraycopy(data, j, data, j+1, i-j);
                    target = j;
                    break;
                }
            }
            data[target] = cur;
        }
    }

    /**
     * 选择排序：从无序区选择最小的数存入有序区的最后一位
     * @param data
     */
    private static void selectSort(int[] data) {
        int len = data.length;
        if (len <= 1) {
            return;
        }
        for (int i = 0; i <= len - 2; i++) {
            int target = 0;
            int min = Integer.MAX_VALUE;
            for (int j = i; j <= len - 1; j++) {
                if (data[j] < min) {
                    min = data[j];
                    target = j;
                }
            }
            if (target != i) {
                System.arraycopy(data, i, data, i+1, target-i);
            }
            data[i] = min;
        }
    }

    // 插入排序，a表示数组，n表示数组大小
    private static void insertionSort(int[] a) {
        int len = a.length;
        if (len <= 1) {
            return;
        }
        for (int i = 1; i <= len - 1; i++) {
            int cur = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > cur) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = cur;
        }
    }

    /*-------------quickSort------------*/

    private static void quickSort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int m = partition(a, start, end);
        quickSort(a, start, m - 1);
        quickSort(a, m + 1, end);

    }

    private static int partition(int[] a, int start, int end) {
        int pivot = a[end];
        int tail = start - 1;
        for (int i = start; i < end; i++) {
            if (a[i] < pivot) {
                tail++;
                int temp = a[i];
                a[i] = a[tail];
                a[tail] = temp;
            }
        }
        a[end] = a[++tail];
        a[tail] = pivot;
        return tail;
    }


    /*-------------mergeSort------------*/

    private static void mergeSort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(a, low, mid);
        mergeSort(a, mid + 1, high);
        merge(a, low, mid, mid + 1, high);
    }

    private static void merge(int[] target, int leftLow, int leftHigh, int rightLow, int rightHigh) {
        int tempL = rightHigh - leftLow + 1;
        int[] temp = new int[tempL];
        int i = leftLow;
        int j = rightLow;
        int tempIndex = 0;
        while (i <= leftHigh && j <= rightHigh) {
            if (target[i] <= target[j]) {
                temp[tempIndex++] = target[i++];
            } else {
                temp[tempIndex++] = target[j++];
            }
        }
        while (i <= leftHigh) {
            temp[tempIndex++] = target[i++];
        }
        while (j <= rightHigh) {
            temp[tempIndex++] = target[j++];
        }
        System.arraycopy(temp, 0, target, leftLow, tempL);
    }

}
