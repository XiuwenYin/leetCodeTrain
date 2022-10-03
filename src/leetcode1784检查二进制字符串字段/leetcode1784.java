package leetcode1784检查二进制字符串字段;

public class leetcode1784 {
    /**
     * 根据题意，反向遍历会更快（剪枝）
     * @param s
     * @return
     */
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        boolean res = false; // 初始化res为false
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '1') res = true; // 如果当前位为1，则res为true
            else if (res) return false; // 如果当前位不为1，且当前res为true，则证明出现了隔断（10011这样子）；直接返回false
        }
        return res;
    }
}
