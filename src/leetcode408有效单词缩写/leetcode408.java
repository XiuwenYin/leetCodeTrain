package leetcode408有效单词缩写;

public class leetcode408 {
    public boolean validWordAbbreviation(String word, String abbr) {
        char[] arr = abbr.toCharArray();
        int num = 0;    // 缩写中的数字，不能出现前导0
        int next = 0;   // 遍历 arr 的指针
        for (char c : arr) {
            // 如果是数字，则拼接成最后的样子
            if (c >= '0' && c <= '9') {
                // 前导0数字不合法
                if (num == 0 && c == '0') return false;
                num = num * 10 + (c - '0');
                continue;
            }

            next = next + num;  // 更新指针
            // 如果 next 超出了 word 的长度，说明不是 word 的缩写
            // 或者，如果 word 和 abbr 在 next 位置的字符不一致，则说明不是 word 的缩写
            if (next >= word.length() || (word.charAt(next) != c)) {
                return false;
            }
            next++;
            num = 0;
        }
        return next + num == word.length();
    }
}
