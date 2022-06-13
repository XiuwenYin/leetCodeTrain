package leetcode113;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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

public class leetcode113 {
    List<List<Integer>> res = new LinkedList<>();
    Deque<Integer> deque = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return res;
        dfs(root, targetSum);
        return res;
    }
    private void dfs(TreeNode root, int target) {
        if (root == null) return;
        deque.offer(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList<>(deque));
        }
        dfs(root.left, target);
        dfs(root.right, target);
        // 如果这条路走不通，就直接弹出这个叶子结点
        deque.pollLast();
    }
}
