package leetcode144;

import java.util.ArrayList;
import java.util.List;

// 二叉树的前序遍历
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

/**
 * 递归
 */
public class leetcode144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        // 创建动态数组用于存储二叉树的先序遍历
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        // 1. 结束条件：当当前节点为空，直接返回
        if (root == null) {
            return;
        }
        // 2. 若不为空，则添加当前节点值到动态数组中
        // 3. 先添加当前节点的值，再递归走到左子叶添加，再递归到右子叶添加，即为先序遍历
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);

    }
}
