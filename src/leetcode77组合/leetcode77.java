package leetcode77组合;

import java.util.ArrayList;
import java.util.List;

public class leetcode77 {


    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, n, k, 1, new ArrayList<>());
        return res;
    }

    private void dfs(List<List<Integer>> res, int n, int k, int index, List<Integer> level) {
        if (level.size() == k) {
            res.add(new ArrayList<>(level));
            return;
        }
        for (int i = index; i <= n; i++) {
            level.add(i);
            dfs(res, n, k, i + 1, level);
            level.remove(level.size() - 1);
        }
    }


}
