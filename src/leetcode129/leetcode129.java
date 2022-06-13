package leetcode129;

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

public class leetcode129 {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        DFS(root, 0);
        return sum;
    }

    public void DFS(TreeNode root, int val) {
        val = val * 10 + root.val;
        // base case
        if (root.left == null && root.right == null) {
            sum += val;
            return;
        }
        if (root.left != null) {
            DFS(root.left, val);
        }
        if (root.right != null) {
            DFS(root.right, val);
        }
    }
}
