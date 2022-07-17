package leetcode1328破坏回文串;

public class leetcode1328 {
    public String breakPalindrome(String palindrome) {
        int len = palindrome.length(), half = (len - 2) >> 1;
        if (len < 2) return "";
        char[] ch_arr = palindrome.toCharArray();
        for (int i = 0; i <= half; ++i) { // 从0起，到half的位置停下
            if (ch_arr[i] > 'a') { // 如果当前位置不是a，则直接改为a并返回
                ch_arr[i] = 'a';
                return String.valueOf(ch_arr);
            }
        }
        ch_arr[len - 1] = 'b'; // 如果都是a的情况，则将最后一位改为b
        return String.valueOf(ch_arr);
    }

}
