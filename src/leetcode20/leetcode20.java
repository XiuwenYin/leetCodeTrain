package leetcode20;

import java.util.*;

public class leetcode20 {
    public boolean isValid(String s) {
        if ((s.length() & 1) != 0) return false; // (num & 1) == 0 表示是偶数， != 0表示是奇数（位运算）
        Map<Character, Character> map = new HashMap<Character, Character>(){
            {
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }
        };
        char[] arr = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : arr) {
            if (map.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek() == map.get(c)) stack.pop();
                else return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }


    public boolean isValid01(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                if (stack.isEmpty() || stack.peek() != map.get(c)) {
                    return false;
                }
                stack.pop();
            } else {
                // 或者 stack.offerFirst()；不可使用stack.offer()，这样会把元素添加到末尾
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
