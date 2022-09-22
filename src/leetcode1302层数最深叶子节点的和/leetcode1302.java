package leetcode1302层数最深叶子节点的和;

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

public class leetcode1302 {
    /**
     * bfs
     * 没那么快，但是好懂（自己写的）
     * @param root
     * @return
     */
    public int deepestLeavesSum(TreeNode root) {
        int res = 0;
        if (root == null) return res;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            res = 0; // 如何判断是不是最后一层，不如想想如何判断 是不是 不是最后一层；最后一层的话不会经过这里，所以每次res归零就可以解决找到最后一层的问题
            for (int s = 0; s < size; s++) {
                TreeNode temp = q.poll();
                res += temp.val;
                if (temp.left != null) q.offer(temp.left);
                if (temp.right != null) q.offer(temp.right);
            }
            level++;
        }
        return res;
    }

    /**
     * dfs
     * @param root
     * @return
     */
    int level;
    int res;
    public int deepestLeavesSum01(TreeNode root) {
        dfs(root, 0);
        return res;
    }
    public void dfs(TreeNode root, int deepth) {
        if (root == null) return;
        if (deepth > level) {
            level = deepth;
            res = 0;
        }
        if (deepth == level) res += root.val;
        dfs(root.left, deepth + 1);
        dfs(root.right, deepth + 1);

    }

}
