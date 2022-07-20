package leetcode105从前序与中序遍历序列构造二叉树;

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

    /**
     * 练习
     */
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree01(int[] preorder, int[] inorder) {
        for (int i = 0; i < preorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public TreeNode dfs(int[] preorder, int pleft, int pright, int[] inorder, int ileft, int iright) {
        if (pleft > pright) return null;
        int proot = pleft;
        int iroot = map.get(preorder[proot]);

        TreeNode root = new TreeNode(preorder[proot]);
        int leftSize = iroot - ileft;

        root.left = dfs(preorder, pleft + 1, pleft + leftSize, inorder, ileft, iroot - 1);
        root.right = dfs(preorder, pleft + leftSize + 1, pright, inorder, iroot + 1, iright);
        return root;
    }
}
