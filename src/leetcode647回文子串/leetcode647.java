package leetcode647回文子串;

public class leetcode647 {
    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;

        for (int i = 0; i < n * 2 - 1; i++) {
            int left = i / 2;
            int right = i / 2 + i % 2;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                res++;
            }
        }
        return res;
    }


    /**
     * 更快
     * @param s
     * @return
     */
    public int countSubstrings01(String s) {
        int cnt = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int begin = i;
            char c = s.charAt(i);
            while (i < n && s.charAt(i) == c) {
                i++;
            }
            int end = --i;
            // 从begin到end为相同的字符，可组成的回文子串数为 (1+x)*x/2，其中x=end-begin+1
            cnt += (1 + end - begin + 1) * (end - begin + 1) / 2;
            // 中心扩展法
            while (end < n - 1 && begin > 0) {
                end++;
                begin--;
                if (s.charAt(begin) != s.charAt(end)) {
                    break;
                }
                cnt++;
            }
        }
        return cnt;
    }


}
