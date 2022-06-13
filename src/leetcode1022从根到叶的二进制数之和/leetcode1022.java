package leetcode1022从根到叶的二进制数之和;

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

/*用一个变量维护到达当前节点时所记录的十进制数，如果该节点是叶子节点，加入答案，结束该轮递归*/
public class leetcode1022 {
    int ans;
    public int sumRootToLeaf(TreeNode root) {
        // int ans = 0
        sumbinary(root, 0);
        return ans;
    }

    public void sumbinary(TreeNode root, int cur){
        if(root == null) return;

        if(root.left == null && root.right == null){
            ans += cur * 2 + root.val;
            return;
        }
        sumbinary(root.left, cur * 2 + root.val);
        sumbinary(root.right, cur * 2 + root.val);
    }
}
