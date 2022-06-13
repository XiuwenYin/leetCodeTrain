package leetcode124;

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

public class leetcode124 {
    // global一个最大值，用于处理当前最大值
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        DFS(root);
        return max;
    }
    public int DFS(TreeNode root) {
        // base case 如果root为null，返回0
        if (root == null) return 0;
        // 获取左右子树的值
        int left = DFS(root.left);
        int right = DFS(root.right);
        // 与 0 相比，如果是负数则没有添加的必要，直接归零处理
        left = Math.max(left, 0);
        right = Math.max(right, 0);
        // 更新当前最大值
        max = Math.max(left + right + root.val, max);
        // 获取当前层级最大值 并返回
        int levelMax = Math.max(left + root.val, right + root.val);
        return levelMax;

    }
}
