package leetcode103;

import java.util.*;

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

public class leetcode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        // 增加一个保护措施
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean order = true;
        while (!queue.isEmpty()) {
            Deque<Integer> level = new LinkedList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                // 注意此时的顺序，offerLast 和 offerFirst
                if (order) {
                    level.offerLast(temp.val);
                } else {
                    level.offerFirst(temp.val);
                }
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
            res.add(new LinkedList<>(level));
            order = !order;
        }
        return res;
    }
}


