package leetcode513找树左下角的值;

import java.util.ArrayDeque;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class leetcode513 {
    /**
     * bfs
     * 要找寻最底层最左边的值
     * 每次更新一层时peek队列的头元素，更新为res即可
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int res = root.val;
        while (!q.isEmpty()) {
            int size = q.size();
            res = q.peek().val;
            for (int s = 0; s < size; s++) {
                TreeNode temp = q.poll();
                if (temp.left != null) q.offer(temp.left);
                if (temp.right != null) q.offer(temp.right);
            }
        }
        return res;
    }

    /**
     * dfs
     * 全局变量监听深度和结果
     * 如果当次深度超过最大值，则表示来到了新的一层
     * 直接将res替换为当前root.val，即为最左边
     */
    int res, max;
    public int findBottomLeftValue01(TreeNode root) {
        dfs(root, 1);
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (depth > max) {
            max = depth;
            res = root.val;
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
