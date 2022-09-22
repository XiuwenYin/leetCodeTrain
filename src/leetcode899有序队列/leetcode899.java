package leetcode899有序队列;

import java.util.Arrays;

public class leetcode899 {
    /**
     * 如果k == 1, 则遍历字符串s，找到轮巡一圈哪个阶段字典序小，则赋给res
     * 如果k > 1，则必定有最小字典序存在，所以直接sort返回即可
     * @param s
     * @param k
     * @return
     */
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String res = s;
            for (int i = 0; i < s.length(); i++) {
                String t = s.substring(i) + s.substring(0, i);
                if (t.compareTo(res) < 0) {
                    res = t;
                }
            }
            return res;
        }
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
