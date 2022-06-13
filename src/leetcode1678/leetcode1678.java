package leetcode1678;

import java.util.HashMap;
import java.util.Map;

// 设计Goal解析器
public class leetcode1678 {
    /**
     * 遍历查找
     */
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G') {
                sb.append('G');
            } else if (command.charAt(i) == '(' && command.charAt(i + 1) == ')') {
                sb.append('o');
                i++;
            } else {
                sb.append("al");
                i += 3;
            }

        }
        return sb.toString();
    }

    /**
     * String类的replace()方法
     */
    public String interpret02(String command) {
        command = command.replace("()", "o");
        command = command.replace("(al)", "al");
        return command;
    }


    public static void main(String[] args) {
        leetcode1678 test = new leetcode1678();
        String a = test.interpret("G()(al)");
        System.out.println(a);
    }
}
