package leetcode22括号生成;

import java.util.ArrayList;
import java.util.List;

public class leetcode22 {
    /**
     * dfs(回溯)
     * @param n
     * @return
     */
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
        if (left > right) return; // 剪枝（左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节；不然会生成在没有左括号的情况下添加右括号）
        if (left > 0) {
            dfs(res, left - 1, right, cur + "("); // 之所以这里不用回溯是因为每次字符串拼接会默认生成一个新字符串，即一个新对象
        }
        if (right > 0) {
            dfs(res, left, right - 1, cur + ")");
        }
    }
}
