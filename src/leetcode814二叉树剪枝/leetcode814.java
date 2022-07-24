package leetcode814二叉树剪枝;

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

public class leetcode814 {
    /**
     * 根据题意，我们将原函数 pruneTree 作为递归函数，递归函数的含义为「将入参 root 中的所有不包含 1 的子树移除，并返回新树头结点」。
     *
     * 不失一般性的考虑任意节点作为入参该如何处理：我们可以递归处理左右子树，并将新左右子树重新赋值给 root。
     * 由于当前节点 root 的左右子树可能为空树，因此我们要增加递归函数入参为空的边界处理。
     *
     * 当递归操作完成后，若左右节点任一值不为空（说明当前节点 root 不为叶子节点），我们可以直接返回 root，
     * 否则根据 root 的值是否为 0 来决定返回空树还是 root 本身。
     */
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left != null || root.right != null) return root;
        return root.val == 1 ? root : null;
    }
}
