//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1113 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> track = new ArrayList<>();
        backtrack(track, nums);
        return res;
    }

    public void backtrack(List<Integer> track, int[] nums) {
        if (track.size() == nums.length) {
            res.add(new ArrayList(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) continue;
            track.add(nums[i]);
            backtrack(track, nums);
            track.remove(Integer.valueOf(nums[i]));
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
