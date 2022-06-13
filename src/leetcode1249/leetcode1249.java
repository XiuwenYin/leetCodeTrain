package leetcode1249;

public class leetcode1249 {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = removeExreaParentheses(s, '(', ')');
        sb = removeExreaParentheses(sb.reverse(), ')', '(');
        return sb.reverse().toString();
    }

    public StringBuilder removeExreaParentheses(CharSequence s, char p1, char p2) {
        StringBuilder sb = new StringBuilder();
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == p1) {
                balance++;
            }
            if (c == p2) {
                if (balance == 0) continue;
                balance--;
            }
            sb.append(c);
        }
        return sb;
    }

}
