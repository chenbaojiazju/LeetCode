//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 934 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();
        //init needs
        for (char a : t.toCharArray()) {
            needs.put(a, needs.getOrDefault(a, 0) + 1);
        }
        //init windows
        int left = 0;
        int right = 0;
        int valid = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        while (right < s.length()) {
            //updata window
            char cur = s.charAt(right);
            right++;
            if (needs.containsKey(cur)) {
                windows.put(cur, windows.getOrDefault(cur, 0) + 1);
                if (windows.get(cur).equals(needs.get(cur))) {
                    valid++;
                }
            }

            while (valid == needs.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char out = s.charAt(left);
                left++;
                if (needs.containsKey(out)) {
                    if (windows.get(out).equals(needs.get(out))) {
                        valid--;
                    }
                    windows.put(out, windows.getOrDefault(out, 0) - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
