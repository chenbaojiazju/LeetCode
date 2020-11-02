package array;
import java.util.*;
/**
 * @author 陈包佳
 * @version 1.0
 * @date 2020/10/21 21:48
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] a = new int[]{1,0,2,3,0,4,5,0};
        new ThreeSum().duplicateZeros(a);
        for (int b : a) {
            System.out.println(b);
        }
    }

    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != 0 ) {
                continue;
            }
            shift(arr, i+1);
            arr[++i] = 0;
        }
    }

    public void shift(int[] arr, int index) {
        if (index == arr.length - 1) return;
        for (int i = arr.length - 2; i >= index; i--) {
            arr[i+1] = arr[i];
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length < 3) return results;
        for (int i = 0; i < nums.length-2; i++){
            //以为有序可提前退出
            if (nums[i] > 0) break;
            if (i == 0 || nums[i] != nums[i-1]) {
                int left = i + 1;
                int right = nums.length - 1;
                int sum = 0 - nums[i];
                while (left < right) {
                    if (nums[left] + nums[right] == sum) {
                        results.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        //在满足条件下去重
                        while (left < right && nums[left+1] == nums[left]) left++;
                        while (left < right && nums[right-1] == nums[right]) right--;
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] < sum) {
                        left++;
                        //快速去重
                        while (left < right && nums[left] + nums[right] < sum) left++;
                    } else {
                        right--;
                        while (left < right && nums[left] + nums[right] > sum) right--;
                    }
                }
            }
        }
        return results;
    }
}
