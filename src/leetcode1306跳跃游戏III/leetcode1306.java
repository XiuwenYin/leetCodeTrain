package leetcode1306跳跃游戏III;

public class leetcode1306 {
    /**
     * 本质就是链表题，甚至类似二叉树
     * 看给出节点是否能达到val = 0的节点
     * @param arr
     * @param start
     * @return
     */
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n]; // 去重
        return dfs(arr, visited, start);

    }
    public boolean dfs(int[] arr, boolean[] visited, int idx) {
        int n = arr.length;
        if (idx < 0 || idx >= n) return false; // 超边界了直接false

        int num = arr[idx]; // 获取当前位置arr的值
        if (num == 0) return true;

        if (visited[idx]) return false; // 去重
        else visited[idx] = true;

        return dfs(arr, visited, idx + num) || dfs(arr, visited, idx - num);
    }
}
