package leetcode114二叉树展开为链表;

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


public class leetcode114 {
    /**
     * 也很好用
     * 递归
     * 全局指针
     */
    TreeNode cur; // 当做全局指针

    public void flatten(TreeNode root) {
        if (root == null) return;
        dfs(root);

    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left; // 分别记录当前左右
        TreeNode right = root.right;
        if (cur == null) {
            cur = root;
        } else {
            cur.left = null; // pre左侧为调整为空
            cur.right = root; // 右侧挂上当前root
            cur = root; // 指针挪动到root位置
        }
        dfs(left);
        dfs(right);
    }

    /**
     * 寻找前驱节点 (好用)
     * 官解3
     * @param root
     */
    public void flatten01(TreeNode root) {
        TreeNode cur = root; // 首先定义指针
        while (cur != null) { // 如果指针为空则结束循环
            if (cur.left != null) { // 如果指针左侧不为空，则定义一个ptr指向cur.left
                TreeNode p = cur.left;
                while (p.right != null) { // 此刻如果cur.left的右子树不为空，则ptr一直走到最右下角
                    p = p.right;
                }
                p.right = cur.right; // 在这里，将cur节点的right子树，整个挪动到p的最右下角挂链起来
                cur.right = cur.left; // 并且将cur.left整个挪动为cur.right
                cur.left = null; // cur.left改为空
            }
            cur = cur.right; // cur继续下一位
        }
    }
}
