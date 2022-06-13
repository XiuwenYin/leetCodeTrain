package 剑指Offer50.第一个只出现一次的字符;

import java.util.HashMap;
import java.util.Map;

public class jianzhi50 {
    public char firstUniqChar(String s) {
        Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            if (hashMap.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    public char firstUniqChar01(String s) {
        int n = s.length();
        Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            hashMap.put(c, hashMap.containsKey(c) ? -1 : i);
        }
        int first = n;
        for (Map.Entry<Character, Integer> check: hashMap.entrySet()) {
            int temp = check.getValue();
            if (temp != -1 && temp < first) {
                first = temp;
            }
        }
        return first == n ? ' ' : s.charAt(first);
    }
}
