package leetcode241为运算表达式设计优先级;

import java.util.ArrayList;
import java.util.List;

public class leetcode241 {
    public List<Integer> diffWaysToCompute(String expression) {
        //表达式为空
        if (expression == null || expression.length() == 0) {
            return new ArrayList<>();
        }
        char[] chars = expression.toCharArray();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            //如果当前字符是操作符，也就是op，进行分割
            if (!Character.isDigit(aChar)) {
                //递归拿到左右两个表达式的结果集
                List<Integer> leftList = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rightList = diffWaysToCompute(expression.substring(i + 1));
                //对两个结果集的所有结果进行op运算
                for (Integer left : leftList) {
                    for (Integer right : rightList) {
                        if (aChar == '+') {
                            ans.add(left + right);
                        } else if (aChar == '-') {
                            ans.add(left - right);
                        } else {
                            ans.add(left * right);
                        }
                    }
                }
            }
        }
        //结果集是空，证明该字符串是数字，将数字加入结果集
        if (ans.isEmpty()) {
            ans.add(Integer.valueOf(expression));
        }
        return ans;
    }
}
