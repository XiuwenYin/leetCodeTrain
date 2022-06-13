package leetcode929独特的电子邮件地址;

import java.util.HashSet;
import java.util.Set;

public class leetcode929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String s : emails) {
            StringBuilder sb = new StringBuilder();
            int n = s.length();
            int i = 0;
            boolean okay = true;
            while (i < n) {
                char c = s.charAt(i);
                if (c == '@') break;
                if (c == '+') okay = false;
                if (c == '.' && ++i >= 0) continue; // ++i是为了更新i值
                if (okay) sb.append(c);
                i++;
            }
            // s.substring(i) 表示起始index为i
            set.add(sb.append(s.substring(i)).toString());
        }
        return set.size();
    }
}
