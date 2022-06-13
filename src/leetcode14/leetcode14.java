package leetcode14;

// 最长公共前缀
public class leetcode14 {
    /**
     * 横向扫描
     */
    public String longestCommonPrefix(String[] strs) {
        // 若字符串组长度为0，直接返回空；
        if (strs.length == 0) {
            return "";
        }
        // 1. 定义最长前缀为字符串组第0位
        String res = strs[0];
        // 2. 遍历字符串组
        for (int i = 1; i < strs.length; i++) {
            // 3. 每次遍历都将对比最长前缀和当前字符，取出两者公共最长前缀并赋值给最长前缀变量
            res = twoStringCommon(res, strs[i]);
            // 4. 如果最长前缀长度为零，则直接返回空
            if (res.length() == 0) {
                return "";
            }
        }
        return res;
    }

    // 此函数用于比较两个字符串中最长的公共前缀
    public String twoStringCommon(String s1, String s2) {
        // 1. 变量n为两字符串中最短的字符长度
        int n = Math.min(s1.length(), s2.length());
        // 2. 定义指针 index
        int index = 0;
        // 3. while循环判断：指针小于长度；s1当前字符==s2当前字符
        while (index < n && s1.charAt(index) == s2.charAt(index)) {
            // 4. 指针后移
            index++;
        }
        // 5. 返回s1的子字符串：从0位开始到指针位置（指针位置代表一个公共前缀的最后一位字符）
        return s1.substring(0, index);
    }
}
