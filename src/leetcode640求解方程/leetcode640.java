package leetcode640求解方程;

public class leetcode640 {
    /**
     * 模拟运用
     *
     * @param equation
     * @return
     */
    public String solveEquation(String equation) {
        int x = 0, num = 0;
        int n = equation.length();

        char[] arr = equation.toCharArray();
        for (int i = 0, op = 1; i < n; ) { // 注意循环条件不在这里更新
            char c = arr[i];
            if (c == '+') {
                i++;
                op = 1;
            } else if (c == '-') {
                i++;
                op = -1;
            } else if (c == '=') {
                x *= -1;
                num *= -1;
                op = 1;
                i++;
            } else {
                int j = i;
                while (j < n && arr[j] != '+' && arr[j] != '-' && arr[j] != '=') j++;
                if (arr[j - 1] == 'x') {
                    x += (i < j - 1 ? Integer.parseInt(equation.substring(i, j - 1)) : 1) * op;
                } else {
                    num += Integer.parseInt(equation.substring(i, j)) * op;
                }
                i = j;
            }
        }
        if (x == 0) return num == 0 ? "Infinite solutions" : "No solution";
        else return "x=" + (num / -x);
    }
}
