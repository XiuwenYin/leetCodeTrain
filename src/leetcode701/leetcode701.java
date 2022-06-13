package leetcode701;
// 二叉搜索树中的插入操作

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

public class leetcode701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return DFS(root, val);
    }
    public TreeNode DFS(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            root.left = DFS(root.left, val);
        }
        if (root.val < val) {
            root.right = DFS(root.right, val);
        }
        return root;
    }
}
