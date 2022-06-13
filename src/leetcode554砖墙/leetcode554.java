package leetcode554砖墙;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode554 {
    public int leastBricks(List<List<Integer>> wall) {
        int n = wall.size();
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int cur : wall.get(i)) {
                sum += cur; // 把每个节的厚度都加到一起，放入map中并更新出现次数
                hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
            }
            hashMap.remove(sum); // 移除掉最后一个
        }
        int res = n;
        for (int x : hashMap.keySet()) { // 对map中的厚度进行遍历
            int cnt = hashMap.get(x);
            res = Math.min(res, n - cnt); // 每次对总厚度 - 分厚度，更新最小值
        }
        return res;
    }
}
