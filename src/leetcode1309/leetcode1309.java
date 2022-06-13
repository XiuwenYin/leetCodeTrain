package leetcode1309;
// 解码字母到整数映射
public class leetcode1309 {
    /**
     * 倒序查找，判断当前是否为 '#'
     * 创建字母表，用于查找字母
     */
    public String freqAlphabets(String s) {
        char[] arr = new char[26];
        for (int i = 0; i < 26; i++) {
            arr[i] = (char)('a' + i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '#') {
                sb.append(arr[(s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0' - 1]);
                i -= 2;
            } else {
                sb.append(arr[c - '0' - 1]);
            }
        }
        return sb.reverse().toString();
    }
}
