package leetcode841;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode841 {
    /*
    dfs
     */
    int num;
    boolean[] visited;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        num = n;
        visited = new boolean[n];
        dfs(rooms, 0);
        return num == 0;
    }

    private void dfs(List<List<Integer>> rooms, int i) {
        if (visited[i]) return;
        visited[i] = true;
        num--;
        for (int x : rooms.get(i)) {
            if (!visited[x]) {
                dfs(rooms, x);
            }
        }
    }

    /*
    bfs
     */
    public boolean canVisitAllRooms01(List<List<Integer>> rooms) {
        int n = rooms.size();
        int num = n;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(0);
        visited[0] = true;
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            num--;
            for (int x : rooms.get(temp)) {
                if (!visited[x]) {
                    visited[x] = true;
                    queue.offer(x);
                }
            }
        }
        return num == 0;
    }
}
