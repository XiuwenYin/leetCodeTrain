package leetcode394;

import java.util.Deque;
import java.util.LinkedList;

public class leetcode394 {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int times = 0;
        Deque<Integer> multi = new LinkedList<>();
        Deque<String> res = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                multi.addLast(times);
                res.addLast(sb.toString());
                times = 0;
                sb = new StringBuilder();
            } else if (c == ']') {
                StringBuilder temp = new StringBuilder();
                int curTimes = multi.removeLast();
                for (int i = 0; i < curTimes; i++) {
                    temp.append(sb);
                }
                sb = new StringBuilder(res.removeLast() + temp);
            } else if (c >= '0' && c <= '9')  {
                times = times * 10 + Integer.parseInt(c + "");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String decodeString01(String s) {
        //创建数字栈，创建字符串栈 及临时数字和临时字符串
        Deque<Integer> stackDigit = new LinkedList<>();
        Deque<StringBuilder> stackString = new LinkedList<>();
        int digit = 0;
        StringBuilder res = new StringBuilder();
        //遍历字符串 分4中情况
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[') {
                //如果是"[" 将临时数字和临时字符串入栈
                stackDigit.push(digit);
                stackString.push(res);
                digit = 0;
                res = new StringBuilder();
            }else if (ch == ']') {
                //如果是"]" 将数字和字符串出栈 此时临时字符串res = 出栈字符串 + 出栈数字*res
                StringBuilder temp = stackString.poll();
                int count = stackDigit.poll();
                for (int j = 0; j < count; j++) {
                    temp.append(res.toString());
                }
                res = temp;
            }else if (Character.isDigit(ch)) {
                //如果是数字 将字符转成整型数字 ch-‘0’。 注意数字不一定是个位 比如100[a] 所以digit要*10
                digit = digit * 10 + ch - '0';
            }else {
                //如果是字符 直接将字符放在临时字符串中
                res.append(ch);
            }
        }
        return res.toString();
    }
}
