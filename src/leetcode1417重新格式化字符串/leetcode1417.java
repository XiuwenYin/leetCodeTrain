package leetcode1417重新格式化字符串;

public class leetcode1417 {
    /**
     * 计数
     * 丑，但直白且有用
     *
     * @param s
     * @return
     */
    public String reformat(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int numCnt = 0, charCnt = 0;
        for (char arr : s.toCharArray()) {
            if (Character.isDigit(arr)) numCnt++;
            else charCnt++;
        }
        if (Math.abs(numCnt - charCnt) > 1) return "";
        int ptr1 = 0, ptr2 = 0;
        boolean isDigit = true;
        if (numCnt <= charCnt) isDigit = false;
        while (sb.length() < n) {
            if (isDigit) {
                while (!Character.isDigit(s.charAt(ptr1))) ptr1++;
                sb.append(s.charAt(ptr1));
                ptr1++;
            } else {
                while (Character.isDigit(s.charAt(ptr2))) ptr2++;
                sb.append(s.charAt(ptr2));
                ptr2++;
            }
            isDigit = !isDigit;
        }
        return sb.toString();
    }

    /**
     * 改良
     * 快，推荐
     *
     * @param s
     * @return
     */
    public String reformat01(String s) {
        int num1 = 0, num2 = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c >= '0' && c <= '9') num1++;
            else num2++;
        }
        if (Math.abs(num1 - num2) > 1) return "";

        if (num1 > num2) {
            num1 = 0;
            num2 = 1;
        } else {
            num1 = 1;
            num2 = 0;
        }
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                chars[num1] = c;
                num1 += 2;
            } else {
                chars[num2] = c;
                num2 += 2;
            }
        }
        return new String(chars);
    }
}
