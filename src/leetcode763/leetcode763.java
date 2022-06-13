package leetcode763;

import java.util.ArrayList;
import java.util.List;

public class leetcode763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        if (s.length() == 1) {
            res.add(1);
            return res;
        }
        int[] alphaMap = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphaMap[s.charAt(i) - 'a'] = i;
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, alphaMap[s.charAt(i)]);
            if (i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        String str1 = "tan";
        String str2 = "ant";
        int res = 0;
        for (int i = 0; i < str1.length(); i++) {
            res ^= str1.charAt(i);
        }
        System.out.println(res);
        for (int i = 0; i < str1.length(); i++) {
            res ^= str2.charAt(i);
        }
        System.out.println(res);
    }
}
