package string;

/**
 * @author 陈包佳
 * @version 1.0
 * @date 2020/9/9 19:21
 */
public class Offer58 {

    public static void main(String[] args) {
        String s = "123456";
        int a = 3;
    }

    private String test_1(String s, int n) {
        String target = s.substring(0, n);
        String rest = s.substring(n);
        return rest+target;
    }

    private String test_2(String s, int n) {
        char[] chars = s.toCharArray();
        for(int i = 0; i <= n; i++ ) {
            char temp = chars[i];
            chars[i] = chars[chars.length-1-n+i];
            chars[chars.length-1-i] = temp;
        }
        return new String(chars).trim();
    }
}
