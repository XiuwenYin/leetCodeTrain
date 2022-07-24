package leetcode129求根节点到叶节点数字之和;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

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
    /**
     * dfs
     */
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0);
        return sum;
    }

    public void dfs(TreeNode root, int cur) {
        cur = cur * 10 + root.val;
        // base case
        if (root.left == null && root.right == null) {
            sum += cur;
            return;
        }
        if (root.left != null) {
            dfs(root.left, cur);
        }
        if (root.right != null) {
            dfs(root.right, cur);
        }
    }

    /**
     * bfs
     * 双队列
     * 一个存放TreeNode朴素bfs，一个存放到当前节点的数值
     */
    public int sumNumbers01(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        Queue<Integer> numq = new ArrayDeque<>();
        q.offer(root);
        numq.offer(root.val);
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                TreeNode temp = q.poll();
                int numTemp = numq.poll();
                // 当前节点如果为叶子结点，则res += numTemp;
                if (temp.left == null && temp.right == null) {
                    res += numTemp;
                }
                if (temp.left != null) {
                    q.offer(temp.left);
                    numq.offer(numTemp * 10 + temp.left.val);
                }
                if (temp.right != null) {
                    q.offer(temp.right);
                    numq.offer(numTemp * 10 + temp.right.val);
                }
            }
        }
        return res;
    }
}
