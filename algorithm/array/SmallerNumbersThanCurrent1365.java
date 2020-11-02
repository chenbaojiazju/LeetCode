package array;
import java.util.*;
/**
 * @author 陈包佳
 * @version 1.0
 * @date 2020/10/26 22:51
 */
public class SmallerNumbersThanCurrent1365 {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int[][] data = new int[len][2];
        for (int i = 0; i < len; i++) {
            data[i][0] = nums[i];
            data[i][1] = i;
        }
        Arrays.sort(data, Comparator.comparingInt(a -> a[0]));
//        Arrays.sort(data, new Comparator<>() {
//            @Override
//            public int compare(int[] a, int[] b) {
//                return a[0] - b[0];
//            }
//        });
        int[] res = new int[len];
        int pres = -1;
        for (int j = 0; j < len; j++) {
            if (pres == -1 || data[j][0] != data[j-1][0]) {
                pres = j;
            }
            res[data[j][1]] = pres;
        }
        return res;
    }
}
