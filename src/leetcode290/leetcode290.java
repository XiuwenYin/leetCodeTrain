package leetcode290;

import java.util.HashMap;
import java.util.Map;

public class leetcode290 {
    public boolean wordPattern(String pattern, String s) {
        String[] strList = s.split(" ");
        if (pattern.length() != strList.length) return false;

        Map<Object, Integer> hashMap = new HashMap<Object, Integer>();
        for (Integer i = 0; i < pattern.length(); i++) {
            if (hashMap.put(pattern.charAt(i), i) != hashMap.put(strList[i], i)){
                return false;
            }
        }
        return true;
    }
}
