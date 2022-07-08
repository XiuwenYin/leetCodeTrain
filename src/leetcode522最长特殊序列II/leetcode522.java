package leetcode522最长特殊序列II;

import java.util.HashMap;
import java.util.Map;

public class leetcode522 {
    /**
     * LCS问题（longest comment subsequence）
     * 字符串数组中每个元素的长度也不一定相同
     * @param strs
     * @return
     */
    public int findLUSlength(String[] strs) {
        int n = strs.length;
        int res = -1;
        for (int i = 0; i < n; i++) {
            boolean check = true;
            for (int j = 0; j < n; ++j) {
                if (i != j && isSubseq(strs[i], strs[j])) {
                    check = false;
                    break;
                }
            }
            if (check) res = Math.max(res, strs[i].length());
        }
        return res;
    }

    public boolean isSubseq(String s, String t) {
        int ptS = 0, ptT = 0;
        while (ptS < s.length() && ptT < t.length()) {
            if (s.charAt(ptS) == t.charAt(ptT)) {
                ptS++;
            }
            ptT++;
        }
        return ptS == s.length();
    }
}
