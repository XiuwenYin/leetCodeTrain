package leetcode111;

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


public class leetcode111 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int res = Integer.MIN_VALUE;
        if (root.left == null) {
            res = Math.min(minDepth(root.left), res);
        }
        if (root.right == null) {
            res = Math.min(minDepth(root.right), res);
        }
        return res + 1;
    }

    public int minDepth01(TreeNode root) {
        if (root == null) return 0;
        int res = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left == null && temp.right == null) return res;
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
            res++;
        }
        return res;
    }
}
