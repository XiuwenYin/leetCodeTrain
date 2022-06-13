package leetcode112;

import java.util.LinkedList;
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
        while(!queue.isEmpty()) {
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
    public boolean hasPathSum02(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

}
