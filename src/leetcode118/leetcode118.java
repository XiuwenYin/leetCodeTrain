package leetcode118;

import java.util.ArrayList;
import java.util.List;

// 杨辉三角
public class leetcode118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            // 创建 L 形状三角
            List<Integer> row = new ArrayList<Integer>();
            for(int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // 正上方和左上方相加
                    row.add(res.get(i - 1).get(j) + res.get(i - 1).get(j - 1));
                }
            }
            res.add(row);
        }
        return res;
    }
}
