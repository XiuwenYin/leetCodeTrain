package leetcode207课程表;

import java.util.*;

public class leetcode207 {
    /**
     * 拓扑排序
     * 建立邻接表（adjacency list）
     * BFS 图关系
     *
     * @param numCourses
     * @param prerequisites prerequisites[i] 中的所有课程对 互不相同
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>(); // 创建邻接表
        int[] indegree = new int[numCourses]; // 计算入度
        for (int i = 0; i < prerequisites.length; i++) { // 挂链表的方式存储adjacency list
            int end = prerequisites[i][0]; // 根据题目要求，prerequisites的子数组的0位置是end，1位置是start
            int start = prerequisites[i][1];
            /*
            如果不存在start作为的key，那就创建新的映射关系 start -> 空数组
            如果存在的话，就不用重定向映射关系
            但无论存在与否，映射结果（value）都要加上end的值
             */
            graph.computeIfAbsent(start, x -> new ArrayList<>()).add(end);
            indegree[end]++;
        }
        Queue<Integer> queue = new LinkedList<>(); // 通常 bfs
        for (int i = 0; i < indegree.length; i++) { // 遍历入度表，找到有向图入口
            if (indegree[i] == 0) queue.offer(i); // 任何入读为0的都可以当做起始点（代表没有前置课程）
        }
        int count = 0; // 计量当前遍历了多少节点（上了多少课）
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            count++; // 每次从queue中poll一个节点就count++（课程互不相同所以没必要判断visited）
            for (int neigh : graph.getOrDefault(cur, new ArrayList<>())) { // 对邻接表进行以cur为key的遍历（有可能有孤立节点所以用getOrDefault）
                if (--indegree[neigh] == 0) { // 对当前节点的邻居进行入度检察，先将indegree[neigh]减1，再判断是否等于0，如果等于0代表前置课程修完了，加入queue
                    queue.offer(neigh);
                }
            }
        }
        return count == numCourses;
    }
}
