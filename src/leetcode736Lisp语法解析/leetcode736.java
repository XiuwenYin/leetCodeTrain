package leetcode736Lisp语法解析;

import java.util.HashMap;

public class leetcode736 {
    public int evaluate(String expression) {
        return parse(expression, 0, expression.length(), new HashMap<>());
    }

    int parse(String expr, int start, int end, HashMap<String, Integer> vars) {
        // 去掉首尾括号
        if (expr.charAt(start) == '(') {
            start++;
            end--;
        }
        // 寻找第一个空格
        int firstSpace = start;
        while (firstSpace < end) {
            if (expr.charAt(firstSpace) == ' ')
                break;
            firstSpace++;
        }
        // 解析当前表达式类型
        String type = expr.substring(start, firstSpace);
        if (type.equals("let")) {
            // let 表达式
            // 有 2 * n + 1 个子表达式
            // let v1 e1 v2 e2 ... vn en expr
            HashMap<String, Integer> subVars = new HashMap<>(vars);
            int pre = firstSpace + 1;
            for (int i = firstSpace + 1; i <= end;) {
                // v 或 expr
                int braceCount = 0;
                while (i <= end) {
                    if (braceCount == 0 && (i == end || expr.charAt(i) == ' '))
                        break;
                    else if (expr.charAt(i) == '(')
                        braceCount++;
                    else if (expr.charAt(i) == ')')
                        braceCount--;
                    i++;
                }
                if (i == end) {
                    // expr
                    return parse(expr, pre, i, subVars);
                } else {
                    String v = expr.substring(pre, i);
                    pre = ++i;
                    // e
                    braceCount = 0;
                    while (i < end) {
                        if (braceCount == 0 && expr.charAt(i) == ' ')
                            break;
                        else if (expr.charAt(i) == '(')
                            braceCount++;
                        else if (expr.charAt(i) == ')')
                            braceCount--;
                        i++;
                    }
                    int e = parse(expr, pre, i, subVars);
                    pre = ++i;
                    subVars.put(v, e);
                }
            }
            return 0;
        } else if (type.equals("add") || type.equals("mult")) {
            // add mult 表达式
            // 只有两个子表达式
            // add e1 e2
            // mult e1 e2
            int braceCount = 0;
            int secondSpace = firstSpace + 1;
            while (secondSpace < end) {
                char c = expr.charAt(secondSpace);
                if (c == ' ' && braceCount == 0)
                    break;
                else if (c == '(')
                    braceCount++;
                else if (c == ')')
                    braceCount--;
                secondSpace++;
            }
            int e1 = parse(expr, firstSpace + 1, secondSpace, vars);
            int e2 = parse(expr, secondSpace + 1, end, vars);
            return type.equals("add") ? e1 + e2 : e1 * e2;
        } else if (type.charAt(0) >= 'a' && type.charAt(0) <= 'z') {
            // 变量
            return vars.get(type);
        } else {
            // 整数
            return Integer.parseInt(type);
        }
    }
}
