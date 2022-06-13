package leetcode94;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// 二叉树的中序遍历
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

public class leetcode94 {
    /**
     * 递归 DFS 中序遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // 创建动态数组， 存储中序遍历的节点值
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        // 1. 结束条件： 当前节点为空
        if (root == null) {
            return;
        }
        // 2. 中序遍历： 先递归找到最左边叶子结点， 然后添加入res结果集中
        // 再返回上一层的父节点， 将值添加入结果集中
        // 再寻找右子节点
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);

    }

    /**
     * 用stack模拟dfs
     * 用于防止SOF
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal01(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }


}
