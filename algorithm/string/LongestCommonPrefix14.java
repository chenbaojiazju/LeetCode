package string;

/**
 * @author 陈包佳
 * @version 1.0
 * @date 2020/9/11 0:37
 */
public class LongestCommonPrefix14 {

    public static void main(String[] args) {
        String[] strs = {"cabc", "ca", "cab"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix01(String[] strs) {
        int len = strs.length;
        if (len == 0) {
            return "";
        }
        if (len == 1) {
            return strs[0];
        }
        String common = commonPrefix(strs[0], strs[1]);
        if ("".equals(common)) {
            return common;
        }
        if (len == 2) {
            return common;
        }
        for (int i = 2; i < strs.length; i++) {
            common = commonPrefix(common, strs[i]);
            if ("".equals(common)) {
                break;
            }
        }
        return common;
    }

    private static String commonPrefix(String s1, String s2) {
        //可以使用&&条件判断
        //int len1 = s1.length();
        //int len2 = s2.length();
        //int len = Math.min(len1, len2);
        int targetIndex = -1;
        for (int i = 0; i < s1.length() && i < s2.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                break;
            }
            targetIndex = i;
        }
        if (targetIndex == -1) {
            return "";
        }
        return s1.substring(0, targetIndex + 1);
    }

    //两两比较，第一个字符串作为公共子串的初始值，进行遍历
    public static String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0) {
            return "";
        }
        String res = strs[0];
        /**
         * 包含；
         * 1.待遍历的对象：strs
         * 2.目标结果（最长前缀）的初始化
         * 3.遍历一次的目标结果的获取；res
         *      3.1明确遍历一次的目标结果的获取手段：substring（index）
         *      3.2通过遍历字符串获取index：
         *          3.2.1目标（index）的初始化
         *          3.2.2通过逻辑条件判断更新目标值
         *      3.3通过期望下标获取临时目标前缀
         * 4.目标前缀的更新
         * 5.返回
         */
        //遍历字符串数组
        for (int i = 1; i < len; i++) {
            //用于获取目标公共前缀的下标
            int targetIndex = -1;
            //用上一个比对得出的最长前缀和下一个字符串比较
            for (int j = 0; j < res.length() && j < strs[i].length(); j++) {
                //进行字符串比对
                if (res.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
                //更新目标参数
                targetIndex = j;
            }
            //根据目标参数做特殊结果的返回
            if (targetIndex == -1) {
                return "";
            }
            //临时最长前缀的更新的更新
            res = res.substring(0, targetIndex + 1);
        }
        return res;
    }
}
