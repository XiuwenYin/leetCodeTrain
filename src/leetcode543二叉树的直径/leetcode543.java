package leetcode543二叉树的直径;

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

/**
 * dfs
 * 思想就是每次以当前节点为根节点，寻找左右子树的长度，然后加起来和res取max
 * 之后返回当前MAX(左, 右)
 * 类似124、687
 */
public class leetcode543 {
    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root.left == null && root.right == null) return 0;
        int left = root.left == null ? 0 : dfs(root.left) + 1;
        int right = root.right == null ? 0 : dfs(root.right) + 1;
        res = Math.max(res, left + right);
        return Math.max(left, right);
    }
}
