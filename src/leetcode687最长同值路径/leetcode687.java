package leetcode687最长同值路径;

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

public class leetcode687 {
    int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = 0, right = 0;
        if (root.left != null) {
            left = dfs(root.left) + 1;
        }
        if (root.right != null){
            right = dfs(root.right) + 1;
        }
        // 重点在这里，要在子节点dfs后再判断是否需要truncate
        if (left > 0 && root.val != root.left.val) left = 0;
        if (right > 0 && root.val != root.right.val) right = 0;

        res = Math.max(res, left + right);
        return Math.max(left, right);

    }
}
