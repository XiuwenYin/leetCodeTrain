package leetcode99恢复二叉搜索树;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class leetcode99 {
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        TreeNode x = null;
        TreeNode y = null;
        //扫面遍历的结果，找出可能存在错误交换的节点x和y
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).val > list.get(i + 1).val) {
                y = list.get(i + 1);
                if (x == null) {
                    x = list.get(i);
                }
            }
        }
        //如果x和y不为空，则交换这两个节点值，恢复二叉搜索树
        if (x != null && y != null) {
            int temp = x.val;
            x.val = y.val;
            y.val = temp;
        }
    }
    //中序遍历二叉树，并将遍历的结果保存到list中
    private void dfs(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        dfs(root.left, list);
        list.add(root);
        dfs(root.right, list);
    }
}
