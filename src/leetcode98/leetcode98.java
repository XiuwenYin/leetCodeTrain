package leetcode98;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
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

}
