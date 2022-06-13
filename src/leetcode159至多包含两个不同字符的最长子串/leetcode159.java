package leetcode159至多包含两个不同字符的最长子串;

import java.util.HashMap;
import java.util.Map;

public class leetcode159 {
    /**
     *      ！！重要！！
     *      此题为滑动窗口模板题之一
     *      务必记住
     *      同类型题包括3,340
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length(), res = 0;
        int left = 0;
        Map<Character,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            hashMap.put(cur, hashMap.getOrDefault(cur, 0) + 1);
            while (hashMap.size() > 2) {
                char c = s.charAt(left);
                hashMap.put(c, hashMap.get(c) - 1);
                if (hashMap.get(c) == 0) hashMap.remove(c);
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
