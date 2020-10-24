package array;
import java.util.*;
/**
 * @author 陈包佳
 * @version 1.0
 * @date 2020/10/21 21:48
 */
public class ThreeSum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        ArrayList<Integer> t;
        for (int i = 0; i < num.length-2; i++){
            if (i == 0 || num[i] != num[i-1]) {
                int left = i + 1;
                int right = num.length - 1;
                while (left < right) {
                    if (num[i] + num[left] + num[right] > 0) {
                        right--;
                    } else if (num[i] + num[left] + num[right] < 0) {
                        left++;
                    } else {
                        t = new ArrayList();
                        t.add(num[i]);
                        t.add(num[left]);
                        t.add(num[right]);
                        results.add(t);
                        while (left < right && num[left] == t.get(1)) {
                            //重复的数据跳过
                            left++;
                        }
                    }
                }
            }
        }
        return results;
    }
}
