package leetcode2115从给定原材料中找到所有可以做出的菜;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class leetcode2115 {
    /**
     * 暴力，bfs
     * 最优为拓扑排序，但没学那个解法，这个会慢不少但是简单好理解
     * @param recipes
     * @param ingredients
     * @param supplies
     * @return
     */
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> res = new ArrayList<>();
        Queue<String> q = new ArrayDeque<>();
        for (String s : supplies) q.offer(s); // 将所有的材料都放入q中
        while (!q.isEmpty()) {
            String supply = q.poll();
            for (int i = 0; i < ingredients.size(); i++) { // 对二维数组ingredients进行遍历，用指针指向每一道菜所需的材料
                List<String> list = ingredients.get(i); // 创建list指针，这个list代表单独一道菜所需要的材料
                if (list.size() == 0) continue; // 如果空了就continue
                list.remove(supply); // 从当前材料列表中移除现在正在被遍历的材料
                if (list.size() == 0) { // 如果此时为空，说明这道菜能被做出来
                    res.add(recipes[i]); // 加入结果集
                    q.offer(recipes[i]); // 由于一道菜的原材料可能是另一道菜，所以q加入这道菜
                }
            }
        }
        return res;
    }
}
