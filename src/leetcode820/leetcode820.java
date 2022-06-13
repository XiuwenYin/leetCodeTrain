package leetcode820;

import java.util.Arrays;

public class leetcode820 {
    /**
     * 字符串翻转，
     * 翻转之后如果 t 是 s 的后缀，那么反转之后 t’ 就是 s’ 的前缀。
     * 在反转+排序之后，s’ 一定紧跟在 t’ 的后面！
     * 这样，我们就可以检查排序后的每一个单词，如果当前单词是下一个单词的前缀，则将单词丢弃
     * @param words
     * @return
     */
    public int minimumLengthEncoding(String[] words) {
        int n = words.length;
        int res = 0;
        String[] reverses = new String[n];
        for (int i = 0; i < n; i++) { // 取出字符串并翻转，再加入新的翻转arr中
            String word = words[i];
            String reverse = new StringBuilder(word).reverse().toString();
            reverses[i] = reverse;
        }
        Arrays.sort(reverses); // 排序
        for (int i = 0; i < n; i++) {
            // 如果当前位置的下一个不出界，且下一个reverse是以当前reverse的单词开始，直接下一轮循环
            if (i + 1 < n && reverses[i + 1].startsWith(reverses[i])) {
                continue;
            } else {
                res += reverses[i].length() + 1; // 如果不是的话，则在结果里添加这个单词的长度，并且加上#号（为什么+1的缘故）
            }
        }
        return res;
    }
}
