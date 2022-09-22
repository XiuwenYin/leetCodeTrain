package leetcode1282用户分组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode1282 {
    /**
     * 基础写法（自己写的）
     * 遍历时遇到相同的数字就放进同一个组，每当当前组满了就放入res，并new一个ArrayList<>放入map
     * 最后检查map是否为空，如果不是则将map中的value放入res
     * 不是很快
     *
     * @param groupSizes
     * @return
     */
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        int n = groupSizes.length;
        for (int i = 0; i < n; i++) {
            int num = groupSizes[i];
            if (map.containsKey(num)) {
                List<Integer> temp = map.get(num);
                if (temp.size() == num) {
                    res.add(new ArrayList<>(temp));
                    temp = new ArrayList<>();
                }
                temp.add(i);
                map.put(num, temp);
            } else {
                map.put(num, new ArrayList<>());
                map.get(num).add(i);
            }
        }
        if (!map.isEmpty()) {
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                res.add(entry.getValue());
            }
        }
        return res;
    }

    /**
     * 大佬写法
     * 每当遍历到当前非0数字，以此为基础计数并向后遍历，并且每遍历到一个相同的数字时放入桶的同时将cnt-1，直到到头或者cnt == 0为止
     *
     * @param groupSizes
     * @return
     */
    public List<List<Integer>> groupThePeople01(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (groupSizes[i] != 0) {
                List<Integer> list = new ArrayList<>();
                int cnt = groupSizes[i]; // 不仅是元素，而且还是计数，一举两得
                list.add(i);
                cnt--;
                for (int j = i + 1; j < groupSizes.length && cnt > 0; j++) {
                    if (groupSizes[j] == groupSizes[i]) {
                        list.add(j);
                        cnt--;
                        groupSizes[j] = 0;
                    }

                }
                ans.add(list);
            }
        }
        return ans;
    }
}