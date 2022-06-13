package leetcode406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode406 {
    public int[][] reconstructQueue(int[][] people) {
        // 身高从大到小排（身高相同k小的站前面）
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> res = new ArrayList<>();
        for (int[] p : people) {
            res.add(p[1], p); // p[1]为插入的索引值，p为插入的值
        }
        return res.toArray(new int[people.length][]);
    }
}
