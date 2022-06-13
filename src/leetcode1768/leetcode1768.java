package leetcode1768;
// 交替合并字符串
public class leetcode1768 {
    /**
     * 双指针
     * StringBuilder
     */
    public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int p1 = 0, p2 = 0;
        while(res.length() != (word1.length() + word2.length())) {
            if (p1 != word1.length()){
                res.append(word1.charAt(p1++));
            }
            if(p2 != word2.length()){
                res.append(word2.charAt(p2++));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        leetcode1768 test = new leetcode1768();
        String a = test.mergeAlternately("ab", "pqrs");
        System.out.println(a);

    }
}
