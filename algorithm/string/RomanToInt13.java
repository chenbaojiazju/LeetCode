package string;

/**
 * @author 陈包佳
 * @version 1.0
 * @date 2020/9/10 23:25
 */
public class RomanToInt13 {

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(new RomanToInt13().romanToInt(s));
    }

    public int romanToInt(String s) {
        int result = 0;
        int cur = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int next = getValue(s.charAt(i));
            //通过位置关系确定加减，小数在左为负
            if (cur < next) {
                cur = -cur;
            }
            result += cur;
            cur = next;
        }
        return result+cur;
    }


    /**
     * 获取每个字符的映射关系
     */
    public int getValue(char c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
