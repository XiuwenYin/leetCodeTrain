package leetcode104二叉树的最大深度;

import java.text.DateFormatSymbols;
import java.util.LinkedList;
import java.util.Queue;

// 二叉树的最大深度
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

public class leetcode104 {
    /**
     * DFS 深度优先搜索
     */
    public int maxDepth(TreeNode root) {
        // 结束条件
        if (root == null) {
            return 0;
        }
        // 每次递归都要加上当前层数的值也就是+1，
        // 对左右子节点进行递归运算，用Math.max()判断左右子节点哪一个更深层
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * BFS 广度优先搜索
     */
    public int maxDepth02(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            // size()会动态变化，所以需要记录此时的size
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res++;
        }
        return res;
    }


    /*
    练习 DFS
     */
    public int maxDepth03(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth03(root.left), maxDepth(root.right));
    }
    /*
    练习 BFS
     */
    public int maxDepth04(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode temp = queue.poll();
            if (temp.left != null) queue.offer(temp.left);
            if (temp.right != null) queue.offer(temp.right);
            level++;
        }
        return level;
    }

    /*
    练习 DFS
     */
    public int maxDepth05(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth05(root.left);
        int right = maxDepth05(root.right);
        // 当前最大depth，所以要加1
        int max = Math.max(left, right) + 1;
        return max;
    }
}
