package leetcode423从英文中重建数字;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leetcode423 {
    /**
     * 模拟法
     *
     * 具体的，zero 中的 z 在其余所有单词中都没出现过，我们可以先统计 zero 的出现次数，并构建 0；
     * 然后观察剩余数字，其中 eight 中的 g 具有唯一性，构建 8；
     * 再发现 six 中的 x 具有唯一性，构建 6；
     * 发现 three 中的 h 具有唯一性（利用在此之前 eight 已经被删除干净，词频中仅存在 three 对应的 h)，构建 3 ...
     *
     * 用static保证只读一遍没必要此次重新分配内存
     */
    static String[] ss = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    static int[] priority = new int[]{0, 8, 6, 3, 2, 7, 5, 9, 4, 1};

    public String originalDigits(String s) {
        int n = s.length();
        int[] cnts = new int[26];
        for (int i = 0; i < n; i++) cnts[s.charAt(i) - 'a']++; // 构造词频
        StringBuilder sb = new StringBuilder();
        for (int i : priority) {
            int k = Integer.MAX_VALUE;
            for (char c : ss[i].toCharArray()) k = Math.min(k, cnts[c - 'a']);
            for (char c : ss[i].toCharArray()) cnts[c - 'a'] -= k;
            while (k-- > 0) sb.append(i);
        }
        char[] cs = sb.toString().toCharArray();
        Arrays.sort(cs);
        return String.valueOf(cs);
    }
}
