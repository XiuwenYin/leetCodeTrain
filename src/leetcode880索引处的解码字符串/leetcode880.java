package leetcode880索引处的解码字符串;

import java.util.ArrayDeque;
import java.util.Deque;

public class leetcode880 {
    /**
     * 逐位更新解码后的字符串长度，直到长度不小于k，就往回找
     * @param s
     * @param k
     * @return
     */
    public String decodeAtIndex(String s, int k) {
        long size = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                size = size * (c - '0');
            } else {
                size++;
            }
            if (size >= k) { // 如果找到size大于k的时候，就截取并且中断循环
                s = s.substring(0, i + 1);
                break;
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            k = (int) (k % size); // 每次循环取余
            char c = s.charAt(i);
            if (k == 0 && Character.isLetter(c)) { // 如果余数为0则直接返回当前字符
                return String.valueOf(c);
            }
            if (Character.isDigit(c)) {
                size = size / (c - '0');
            } else {
                size--;
            }
        }
        return "";
    }

    /**
     * 朴素写法
     * 双辅助栈
     * 类第394题写法，爆空间，不要用，短测试用例可通过
     *
     * @param s
     * @param k
     * @return
     */
    public String decodeAtIndex01(String s, int k) {
        Deque<StringBuilder> str = new ArrayDeque<>();
        Deque<Integer> num = new ArrayDeque<>();
        int digit = 0;
        StringBuilder res = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                str.push(res);
                res = new StringBuilder();
                StringBuilder temp = str.poll();
                for (int j = 0; j < (c - '0'); j++) {
                    res.append(temp);
                }
            } else {
                res.append(c);
            }
        }
        return String.valueOf(res.charAt(k - 1));
    }
}
