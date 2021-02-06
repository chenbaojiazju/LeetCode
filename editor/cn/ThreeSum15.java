//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 2940 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i == 0 || nums[i] != nums[i-1]) {
                int other = -nums[i];
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum == other) {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left < right && nums[left + 1] == nums[left]) left++;
                        while (left < right && nums[right - 1] == nums[right]) right--;
                        left++;
                        right--;
                    } else if (sum < other) {
                        left++;
                        //快速去重
                        while (left < right && nums[left] + nums[right] < other) left++;
                    } else {
                        right--;
                        while (left < right && nums[left] + nums[right] > other) right--;
                    }
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
