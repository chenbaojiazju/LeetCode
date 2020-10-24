package string;

import java.util.*;
/**
 * @author 陈包佳
 * @version 1.0
 * @date 2020/10/24 23:12
 */
public class ValidString {

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        Stack stack = new Stack();
        map.put('(', ')');
        map.put('}', '{');
        map.put(']', '[');
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (map.containsKey(cur)) {
                char c = (char)stack.peek();
                if (map.get(cur) == c) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(cur);
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid1(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char cur : s.toCharArray()) {
            if (cur == '{') {
                stack.push('}');
                continue;
            }
            if (cur == '[') {
                stack.push(']');
                continue;
            }
            if (cur == '(') {
                stack.push(')');
                continue;
            }
            if (stack.isEmpty() || cur != stack.pop()) return false;
            return false;
        }
        return stack.isEmpty();
    }
}
