package array;

/**
 * @author 陈包佳
 * @version 1.0
 * @date 2020/10/24 17:05
 */
public class FindMedianSortedArray4 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{1};
        System.out.println(new FindMedianSortedArray4().findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //特殊情况处理
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (nums1.length == 0) {
            if ((len2 & 1) == 1) {
                return nums2[len2/2];
            } else {
                return (double)(nums2[len2/2] + nums2[len2/2 - 1])/2;
            }
        }
        if (nums2.length == 0) {
            if ((len1 & 1) == 1) {
                return nums1[len1/2];
            } else {
                return (double)(nums1[len1/2] + nums1[len1/2 - 1])/2;
            }
        }
        int[] temp = new int[nums1.length + nums2.length];
        int j = 0;
        int i = 0;
        int t = 0;
        while (i != len1 && j != len2) {
            if (nums1[i] <= nums2[j]) {
                temp[t] = nums1[i];
                ++t;
                ++i;
            } else {
                temp[t] = nums2[j];
                ++t;
                ++j;
            }
        }
        while (i < len1-1) {
            temp[t] = nums1[i];
            ++i;
            ++t;
        }
        while (j < len2-1) {
            temp[t] = nums2[j];
            ++j;
            ++t;
        }
        int len = len1 + len2;
        if ((len & 1) == 1) {
            return temp[len/2];
        } else {
            return (double)(temp[len/2] + temp[len/2 -1])/2;
        }
    }
}
