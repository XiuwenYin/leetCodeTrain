package leetcode310最小高度树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        // 建立各个节点的出度表
        int[] degree = new int[n];

        // 建立图关系
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // 有多少个节点，就创建多少个List放入图关系
            map.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            // 出度
            degree[edge[0]]++;
            degree[edge[1]]++;

            // 无向图，所以互相添加
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        // 添加所有的叶子结点
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                // 如果出度为1，则代表只有一个方向从这个节点出去，也就是说这个节点是叶子结点
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            // 每一层循环，都需要创建一个新的空的res
            res = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();

                /*把当前节点加入结果集，不要有疑问，为什么当前只是叶子节点为什么要加入结果集呢?
                因为我们每次循环都会新建一个list，所以最后保存的就是最后一个状态下的叶子节点，
                这也是很多题解里面所说的剪掉叶子节点的部分，你可以想象一下图，每层遍历完，
                都会把该层（也就是叶子节点层）这一层从队列中移除掉，
                不就相当于把原来的图给剪掉一圈叶子节点，形成一个缩小的新的图吗*/
                res.add(cur);

                /*这里就是经典的bfs了，把当前节点的相邻接点都拿出来，
                把它们的出度都减1，因为当前节点已经不存在了，所以，
                它的相邻节点们就有可能变成叶子节点*/
                List<Integer> neighbors = map.get(cur);
                for (int neighbor : neighbors) {
                    degree[neighbor]--;
                    // 如果是叶子节点我们就入队
                    if (degree[neighbor] == 1) {
                        queue.offer(neighbor);
                    }
                }

            }
        }
        return res;
    }
}
