package leetcode654最大二叉树;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class leetcode654 {
    /**
     * 分治
     *
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int l, int r) {
        if (l > r) return null;
        int idx = l;
        for (int i = l; i <= r; i++) {
            if (nums[i] > nums[idx]) idx = i;
        }
        TreeNode ans = new TreeNode(nums[idx]);
        ans.left = build(nums, l, idx - 1);
        ans.right = build(nums, idx + 1, r);
        return ans;
    }
}
