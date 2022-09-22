package leetcode655输出二叉树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

public class leetcode655 {
    public List<List<String>> printTree(TreeNode root) {
        //获取高度
        int height = getHeight(root);
        String[][] ans = new String[height][(1 << height) - 1];
        for (String[] arr : ans) {
            Arrays.fill(arr, "");
        }
        List<List<String>> res = new ArrayList<>();
        dfs(ans, root, 0, 0, ans[0].length);
        for (String[] arr : ans) {
            res.add(Arrays.asList(arr));
        }
        return res;
    }

    /**
     * 填充数组
     *
     * @param ans  数组
     * @param root 根节点
     * @param i    第几行
     * @param l    左节点
     * @param r    右节点
     */
    private void dfs(String[][] ans, TreeNode root, int i, int l, int r) {
        if (root == null) {
            return;
        }
        ans[i][(l + r) / 2] = "" + root.val;
        dfs(ans, root.left, i + 1, l, (l + r) / 2);
        dfs(ans, root.right, i + 1, (l + r + 1) / 2, r);
    }

    /**
     * 获取树的高度
     *
     * @param root
     * @return
     */
    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
