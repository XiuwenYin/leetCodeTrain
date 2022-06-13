package leetcode210课程表II;

import java.util.*;

public class leetcode210 {
    /**
     * DFS
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>(); // 先建立图关系
        int[] indegree = new int[numCourses]; // 建立入度表
        for (int i = 0; i < prerequisites.length; i++) {
            int start = prerequisites[i][1];
            int end = prerequisites[i][0];
            graph.computeIfAbsent(start, x -> new ArrayList<>()).add(end);
            indegree[end]++;
        }
        int[] res = new int[numCourses];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res[count] = cur;
            count++;
            for (int neigh : graph.getOrDefault(cur, new ArrayList<>())) {
                if (--indegree[neigh] == 0) queue.offer(neigh);
            }
        }
        if (count == numCourses) {
            return res;
        }
        return new int[0];
    }

    /**
     * 练习
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder01(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        Map<Integer, List<Integer>> hashMap = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < n; i++) {
            int start = prerequisites[i][1];
            int end = prerequisites[i][0];
            hashMap.computeIfAbsent(start, x -> new ArrayList<>()).add(end);
            indegree[end]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            res[count] = cur;
            count++;
            for (int neigh : hashMap.getOrDefault(cur, new ArrayList<>())) {
                if (--indegree[neigh] == 0) queue.offer(neigh);
            }
        }
        if (count == numCourses) {
            return res;
        } else {
            return new int[0];
        }
    }
}
