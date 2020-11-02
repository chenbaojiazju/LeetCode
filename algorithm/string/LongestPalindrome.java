package string;

/**
 * @author 陈包佳
 * @version 1.0
 * @date 2020/10/25 9:04
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String res = new LongestPalindrome().longestPalindrome("ccc");
        System.out.println(res);
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        int resL = 0;
        int resR = 0;
        int subLen = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > subLen && checkPalindrome(chars, i, j)) {
                    //每一次暴力匹配成功修改结果变量
                    resL = i;
                    resR = j;
                    subLen = j - i + 1;
                }
            }
        }
        return s.substring(resL, resR+1);
    }

    private boolean checkPalindrome(char[] s, int i, int j) {
        while (i < j) {
            if (s[i++] != s[j--]) {
                return false;
            }
        }
        return true;
    }
}
