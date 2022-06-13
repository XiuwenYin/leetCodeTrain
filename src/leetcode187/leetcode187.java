package leetcode187;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode187 {
    public static final int length = 10;
    public List<String> findRepeatedDnaSequences(String s) {
//        int length = 10;
        List<String> res = new ArrayList<String>();
        Map<String, Integer> hashMap = new HashMap<String, Integer>();
        for (int i = 0; i < s.length() - length; ++i) {
            String sub = s.substring(i, i + length);
            hashMap.put(sub, hashMap.getOrDefault(sub, 0) +1 );
            if (hashMap.get(sub) == 2) res.add(sub);
        }
        return res;
    }
}
