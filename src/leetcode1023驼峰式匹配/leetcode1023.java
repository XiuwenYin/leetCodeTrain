package leetcode1023驼峰式匹配;

import java.util.ArrayList;
import java.util.List;

public class leetcode1023 {
    /**
     * 字符串匹配
     * @param queries
     * @param pattern
     * @return
     */
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        for (String query : queries)
            ans.add(isMatch(query, pattern));
        return ans;

    }

    private boolean isMatch(String query, String pattern) {
       // 设定指针p1, p2，用于针对query和pattern分别进行遍历
        int p1 = 0, p2 = 0, n1 = query.length(), n2 = pattern.length();
        while (p1 < n1 && p2 < n2) {
            char c1 = query.charAt(p1), c2 = pattern.charAt(p2);
            if (c1 == c2) { // 如果当前两个字符相同，则两个指针++，进入下一轮循环
                p1++;
                p2++;
            } else { // 如果不同，且query当前位置的字符是大写，则返回false
                if (Character.isUpperCase(c1)) return false;
                p1++; // 如果不是大写，则query指针向右挪动一位
            }
        }
        if (p2 != n2) return false; // 如果遍历完后pattern指针没有到达末尾，则代表未完全匹配，返回false
        while (p1 != n1) { // 如果遍历完后query指针没有到达末尾，则继续遍历看是否存在大写字符，如果有则返回false
            char c1 = query.charAt(p1);
            if (Character.isUpperCase(c1)) return false;
            p1++;
        }
        return true; // 全部通过则返回true
    }
}
