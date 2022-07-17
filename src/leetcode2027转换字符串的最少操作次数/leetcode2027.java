package leetcode2027转换字符串的最少操作次数;

public class leetcode2027 {
    /**
     * 贪心
     * 不用更改字符串，每次跳跃即可，并将结果++
     * 超过bound自然会停下来
     * @param s
     * @return
     */
    public int minimumMoves(String s) {
        int len = s.length();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'X') {
                ans++;
                i += 2;
            }
        }
        return ans;
    }
}
