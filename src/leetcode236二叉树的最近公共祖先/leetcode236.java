package leetcode236二叉树的最近公共祖先;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class leetcode236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //如果left为空，说明这两个节点在 root 结点的右子树上，我们只需要返回右子树查找的结果即可
        //如果left和right都不为空，说明这两个节点一个在 root 的左子树上一个在 root 的右子树上，
        //我们只需要返回 root 结点即可
        return left == null ? root : right == null ? left : root;
    }
}
