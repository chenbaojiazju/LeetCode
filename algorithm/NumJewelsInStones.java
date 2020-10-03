import java.util.*;

/**
 *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。
 * S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * @author 陈包佳
 * @version 1.0
 * @date 2020/10/3 19:27
 */
public class NumJewelsInStones {
    public int method1(String j, String s) {
        Set<Character> chars = new HashSet<>();
        char[] jewels = j.toCharArray();
        for (int i = 0; i < j.length(); i++) {
            chars.add(jewels[i]);
        }
        char[] stones = s.toCharArray();
        int result = 0;
        for (int i = 0; i < stones.length; i++) {
            if (chars.contains(stones[i])) {
                result++;
            }
        }
        return result;
    }

    public int method2(String J, String S) {
        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            chars.add(J.charAt(i));
        }
        int result = 0;
        for (int i = 0; i < S.length(); i++) {
            if (chars.contains(S.charAt(i))) {
                result++;
            }
        }
        return result;
    }

    public int method3(String J, String S) {
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (J.contains(String.valueOf(S.charAt(i)))) count++;
        }
        return count;
    }
}
