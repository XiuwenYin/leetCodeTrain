package leetcode22括号生成;

import java.util.ArrayList;
import java.util.List;

public class leetcode22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        dfs(res, n, n, "");
        return res;
    }

    private void dfs(List<String> res, int left, int right, String cur) {
        if(left == 0 && right == 0) {
            res.add(new String(cur));
        }
        if (left > right) return;
        if (left > 0) {
            dfs(res, left - 1, right, cur + "(");
        }
        if (right > 0) {
            dfs(res, left, right - 1, cur + ")");
        }
    }
}
