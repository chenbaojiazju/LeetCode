package string;
import java.util.*;
/**
 * @author 陈包佳
 * @version 1.0
 * @date 2020/10/24 13:28
 */
public class LengthOfLongestSubString3 {

    public static void main(String[] args) {
        String a = "aucc";
        a.isEmpty();
        System.out.println(new LengthOfLongestSubString3().lengthOfLongestSubstring(a));
    }


    //使用滑动窗口
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        Set<Character> chars = new HashSet<>();
        int r = -1;
        int res = 1;
        int len = s.length();
        for (int i = 0; i < s.length(); i++) {
            //每一次遍历都需要移动窗口，都需要删除哈希表中对应的元素,上一个字符就是对应的重复字符，利用其索引删除
            if (i != 0) {
                chars.remove(s.charAt(i-1));
            }
            //判断滑动的边界
            while (r + 1 < len && !chars.contains(s.charAt(r+1))) {
                //移动右指针
                ++r;
                chars.add(s.charAt(r));
            }
            res = Math.max(res, chars.size());
        }
        return res;
    }
}
