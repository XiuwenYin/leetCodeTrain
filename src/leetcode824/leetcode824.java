package leetcode824;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class leetcode824 {
    public String toGoatLatin(String S) {
        Set<Character> vowel = new HashSet<>();
        for (char c: new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'})
            vowel.add(c);

        int index = 1;
        StringBuilder sb = new StringBuilder();
        for (String word: S.split(" ")) {
            char first = word.charAt(0);
            if (vowel.contains(first)) {
                sb.append(word);
            } else {
                sb.append(word.substring(1));
                sb.append(word.substring(0, 1));
            }
            sb.append("ma");
            for (int i = 0; i < index; i++)
                sb.append("a");
            index++;
            sb.append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
