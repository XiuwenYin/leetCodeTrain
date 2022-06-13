package leetcode450;

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

public class leetcode450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) root.left = deleteNode(root.left, key);
        if (key > root.val) root.right = deleteNode(root.right, key);
        if (root.val == key) {
            //如果左子树和右子树都为空，说明这个点是叶节点
            if (root.left == null && root.right == null) return null;
            //左子树为空，右子树有内容
            if (root.left == null && root.right != null) return root.right;
            //右子树为空，左子树有内容
            if (root.left != null && root.right == null) return root.left;
            //左右子树都不为空，是最复杂的情况
            if (root.left != null && root.right != null) {
                TreeNode temp = root.right;
                //找到右子树最小值
                while (temp != null && temp.left != null) temp = temp.left;
                //将右子树最小值和要找的值交换
                int value = root.val;
                root.val = temp.val;
                temp.val = value;
                //然后将这个值删掉
                root.right = deleteNode(root.right, key);
            }
        }
        return root;
    }


    /**
     * 递归思路
     * bst
     * 在以 root 为根的子树中，删除值为 key 的节点，并返回删除节点后的树的根节点
     *
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode01(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.left == null ) return root.right;
            if (root.right == null) return root.left;
            TreeNode temp = root.left;
            while (temp.right != null) temp = temp.right;
            temp.right = root.right;
            return root.left;
        } else if (root.val < key) root.right = deleteNode01(root.right, key);
        else root.left = deleteNode01(root.left, key);
        return root;
    }
}
