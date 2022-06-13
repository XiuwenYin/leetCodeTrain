package leetcode108;

import java.util.Random;

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

public class leetcode108 {
    Random random = new Random();
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode res = helper(nums, nums[0], nums[nums.length - 1]);
        return res;
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = (left + right + random.nextInt()) / 2;
        TreeNode tree = new TreeNode(nums[mid]);
        tree.left = helper(nums, left, mid - 1);
        tree.right = helper(nums, mid, right);
        return tree;
    }


}
