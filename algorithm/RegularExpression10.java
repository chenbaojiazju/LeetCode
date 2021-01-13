import java.util.Arrays;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 *  
 * 示例 1：
 * <p>
 * 输入：s = "aa" p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入：s = "aa" p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3：
 * <p>
 * 输入：s = "ab" p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4：
 * <p>
 * 输入：s = "aab" p = "c*a*b"
 * 输出：true
 * 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5：
 * <p>
 * 输入：s = "mississippi" p = "mis*is*p*."
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 20
 * 0 <= p.length <= 30
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 保证每次出现字符 * 时，前面都匹配到有效的字符
 *
 * @author 陈包佳
 * @version 1.0
 * @date 2021/1/12 21:34
 */
public class RegularExpression10 {
    int[][] cache;

    public static void main(String[] args) {
        System.out.println(true|false);
    }

    public boolean isMatch(String s, String p) {
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        boolean[][] dp = new boolean[2][pp.length + 1];
        dp[0][0] = true;
        for (int i = 0; i <= ss.length; i++) {
            if (i != 0) {
                Arrays.fill(dp[1], false);
            }
            for (int j = 1; j <= pp.length; j++) {
                if (pp[j - 1] != '*') {
                    if (i > 0 && (ss[i - 1] == pp[j - 1] || pp[j - 1] == '.')) {
                        dp[1][j] = dp[0][j - 1];
                    }
                } else {
                    if (j > 1) {
                        if (i == 0) {
                            dp[0][j] |= dp[0][j - 2];
                        } else {
                            dp[1][j] |= dp[1][j - 2];
                        }

                    }
                    if (i > 0 && j > 1 && (ss[i - 1] == pp[j - 2] || pp[j - 2] == '.')) {
                        dp[1][j] |= dp[0][j];
                    }
                }
            }
            if (i != 0) {
                System.arraycopy(dp[1], 0, dp[0], 0, pp.length + 1);
            }
        }
        return dp[Math.min(1, ss.length)][pp.length];
    }

    public boolean isMatch04(String s, String p) {
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        boolean[][] result = new boolean[ss.length + 1][pp.length + 1];
        result[0][0] = true;
        for (int i = 0; i <= ss.length; i++) {
            for (int j = 1; j <= pp.length; j++) {
                if (pp[j - 1] != '*') {
                    if (i > 0 && (ss[i - 1] == pp[j - 1] || pp[j - 1] == '.')) {
                        result[i][j] = result[i - 1][j - 1];
                    }
                } else {
                    if (j > 1) {
                        result[i][j] |= result[i][j - 2];
                    }
                    if (i > 0 && j > 1 && (ss[i - 1] == pp[j - 2] || pp[j - 2] == '.')) {
                        result[i][j] |= result[i - 1][j];
                    }
                }
            }
        }
        return result[ss.length][pp.length];
    }

    private boolean isMatch03(char[] ss, int s, char[] pp, int p) {
        if (p >= pp.length) return s >= ss.length;
        if (cache[s][p] != 0) return cache[s][p] > 0;
        boolean match = (s < ss.length) && (ss[s] == pp[p] || pp[p] == '.');
        if (pp.length - p >= 2 && pp[p + 1] == '*') {
            boolean t = isMatch02(ss, s, pp, p + 2) || match && isMatch02(ss, s + 1, pp, p);
            if(t) cache[s][p] = 1;
            else cache[s][p] = -1;
            return t;
        }
        boolean t = match && isMatch02(ss, s + 1, pp, p + 1);
        if(t) cache[s][p] = 1;
        else cache[s][p] = -1;
        return t;
    }

    private boolean isMatch02(char[] ss, int i, char[] pp, int j) {
        if (j >= pp.length) return i >= ss.length;
        boolean match = (i < ss.length) && (ss[i] == pp[j] || pp[j] == '.');
        if (pp.length - j >= 2 && pp[j + 1] == '*') {
            return isMatch02(ss, i, pp, j + 2) || match && isMatch02(ss, i + 1, pp, j);
        }
        return match && isMatch02(ss, i + 1, pp, j + 1);
    }

    public boolean isMatch01(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        boolean match = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*')
            return isMatch01(s, p.substring(2)) || match && isMatch01(s.substring(1), p);
        return match && isMatch01(s.substring(1), p.substring(1));
    }


}
