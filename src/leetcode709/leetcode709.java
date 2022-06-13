package leetcode709;
// 转换成小写字母
public class leetcode709 {
    /**
     * ASCII码中大写字母在65到90之间
     * 只要发现就 += 32
     * 近而我们可以发现，由于 [65,96] 对应的二进制表示为[(01000001)(01011010)]
     * 32 对应的二进制表示为 (00100000)
     * 而对于[(01000001)(01011010)]内的所有数，
     * 表示 32 的那个二进制位都是 0，
     * 因此可以对 c 的 ASCII 码与 32 做按位或运算，
     * 替代与 32 的加法运算
     * 以上来自leetcode
     */
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 65 && c <= 90) {
                c |= 32;
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
