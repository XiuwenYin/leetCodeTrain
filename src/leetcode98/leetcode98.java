package leetcode98;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

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

public class leetcode98 {
    /*
    中序遍历：先左，再当前，再右
     */
    // 用pre存储上一个节点的值
    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        // 访问左子树
        if (!isValidBST(root.left)) return false;
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) return false;
        // 更新pre的值
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }


    /**
     * dfs
     * 这个更好用
     */
    public boolean isValidBST01(TreeNode root) {
        return dfs(root, null, null);
    }

    public boolean dfs(TreeNode root, TreeNode max, TreeNode min) {
        if (root == null) return true;
        if (max != null && root.val >= max.val) return false; // 如果max不为空，说明在左边，如果比 max 大则为false
        if (min != null && root.val <= min.val) return false; // 如果min不为空，说明在右边，如果比 min 小则为false

        // 对于left，max就是root，min就是min；对于right，max就是max，min就是root
        return dfs(root.left, root, min) && dfs(root.right, max, root);
    }

    /**
     * bfs
     */
    public boolean isValidBST02(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>(); // 用Stack，Deque不行
        // 记录前一个节点
        TreeNode pre = null;

        while (stack.size() > 0 || root != null) {
            // 一直向左子树走，每一次将当前节点保存到栈中
            if (root != null) {
                stack.add(root);
                root = root.left;
            }
            // 当前节点为空，证明走到了最左边，从栈中弹出节点
            // 开始对右子树重复上述过程
            else {
                TreeNode cur = stack.pop();
                // 判断序列是否有序
                if (pre != null && cur.val <= pre.val) {
                    return false;
                }
                pre = cur;
                root = cur.right;
            }
        }
        return true;
    }
}
