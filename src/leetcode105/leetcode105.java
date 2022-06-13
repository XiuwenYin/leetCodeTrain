package leetcode105;

import java.util.HashMap;
import java.util.Map;

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

public class leetcode105 {
    private Map<Integer, Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<>();
        for (int i = 0; i < preorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return constructTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode constructTree (int[] preorder, int preorderLeft, int preorderRight, int[] inorder, int inorderLeft, int inotderRight) {
        if (preorderLeft > preorderRight) return null;
        // 前序遍历第一个数字就是根节点
        int preorderRoot = preorderLeft;
        // 在中序遍历中找到根节点
        int inorderRoot = indexMap.get(preorder[preorderRoot]);

        TreeNode root = new TreeNode(preorder[preorderRoot]);
        // 获取左子树的长度
        int leftTreeSize = inorderRoot - inorderLeft;

        root.left = constructTree(preorder, preorderLeft + 1, preorderLeft + leftTreeSize, inorder, inorderLeft, inorderRoot - 1);
        root.right = constructTree(preorder, preorderLeft + leftTreeSize + 1, preorderRight, inorder, inorderRoot + 1, inotderRight);
        return root;
    }
}
