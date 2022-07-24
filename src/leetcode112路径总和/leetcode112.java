package leetcode112路径总和;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class leetcode112 {
    /**
     * BFS
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> val = new LinkedList<Integer>();
        queue.offer(root);
        val.offer(root.val);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int curVal = val.poll();
            if (cur.left == null && cur.right == null) {
                if (curVal == targetSum) {
                    return true;
                }
                // continue;
            }
            if (cur.left != null) {
                queue.offer(cur.left);
                val.offer(curVal + cur.left.val);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                val.offer(curVal + cur.right.val);
            }
        }
        return false;
    }

    /**
     * DFS
     */
    public boolean hasPathSum01(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }


    /**
     * dfs练习
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum02(TreeNode root, int targetSum) {
        return dfs(root, targetSum);
    }

    public boolean dfs(TreeNode root, int k) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return root.val == k;
        }
        k -= root.val;
        return dfs(root.left, k) || dfs(root.right, k);
    }

    /**
     * bfs练习
     */
    public boolean hasPathSum03(TreeNode root, int targetSum) {
        if (root == null) return false;
        Queue<TreeNode> q = new ArrayDeque<>();
        Queue<Integer> val = new ArrayDeque<>();
        q.offer(root);
        val.offer(root.val);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                int curVal = val.poll();
                if (cur.left == null && cur.right == null) {
                    if (curVal == targetSum) {
                        return true;
                    }
                    // continue;
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                    val.offer(curVal + cur.left.val);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                    val.offer(curVal + cur.right.val);
                }
            }
        }
        return false;
    }
}
