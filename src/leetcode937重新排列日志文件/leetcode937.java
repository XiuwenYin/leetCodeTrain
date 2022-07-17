package leetcode937重新排列日志文件;

import java.util.*;

public class leetcode937 {
    /**
     * 模拟
     * 重写compare方法
     * @param logs
     * @return
     */
    public String[] reorderLogFiles(String[] logs) {
//        Arrays.sort(logs, (o1, o2)->compare(o1, o2)); // lambda表达式，下面是lambda替换方法引用
        Arrays.sort(logs, this::compare);
        return logs;
    }

    private int compare(String log1, String log2) {
        // 分别截取s1, s2的第一个空格后的字符的位置，用于判断是字母日志还是数字日志
        int s1 = log1.indexOf(' ') + 1;
        int s2 = log2.indexOf(' ') + 1;
        char c1 = log1.charAt(s1), c2 = log2.charAt(s2);

        if (Character.isDigit(c1) && Character.isDigit(c2)) {
            return 0; // 如果都是数字，则保持顺序
        } else if (Character.isDigit(c1)) {
            return 1; // 如果log1是数字日志，则放后面
        } else if (Character.isDigit(c2)) {
            return -1; // 如果log2是数字日志，则放后面
        } else { // 如果都是字符日志
            /* 如果参数字符串等于该字符串，则值为 0；
               如果此字符串按字典顺序小于字符串参数，则值小于 0；
               如果此字符串按字典顺序大于字符串参数，则值大于 0 */
            int cmp = log1.substring(s1).compareTo(log2.substring(s2));
            if (cmp == 0) return log1.compareTo(log2);
            else return cmp;
        }
    }

    /**
     * 另一种类似解法
     * @param logs
     * @return
     */
    public String[] reorderLogFiles01(String[] logs) {
        Arrays.sort(logs, (o1,o2)->{
            String[] s1 = o1.split(" ", 2);
            String[] s2 = o2.split(" ", 2);
            boolean digit1 = Character.isDigit(s1[1].charAt(0));
            boolean digit2 = Character.isDigit(s2[1].charAt(0));
            if (digit1 && digit2) {
                return 0;
            } else if (!digit1 && !digit2) {
                int res = s1[1].compareTo(s2[1]);
                return res == 0 ? s1[0].compareTo(s2[0]) : res;
            } else return digit1 ? 1 : -1;
        });

        return logs;
    }
}
