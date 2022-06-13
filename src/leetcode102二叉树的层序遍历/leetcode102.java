package leetcode102二叉树的层序遍历;
// 二叉树的层序遍历


import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

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

public class leetcode102 {
    /**
     * bfs，用Queue
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                level.add(temp.val);
            }
            res.add(level);
        }
        return res;
    }


    /**
     * dfs 了解即可
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder01(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode root, List<List<Integer>> res, int height) {
        if (root == null) return;
        if (height > res.size()) res.add(new ArrayList<>());

        res.get(height).add(root.val);

        if (root.left != null) dfs(root.left, res, height + 1);
        if (root.right != null) dfs(root.right, res, height + 1);
    }



}
