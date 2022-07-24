package leetcode106从中序与后序遍历序列构造二叉树;

import java.util.HashMap;
import java.util.Map;

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

public class leetcode106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = inorder.length;
        // 将中序遍历放到map中
        for (int i = 0; i < n; ++i) {
            map.put(inorder[i], i);
        }
        return myBuildTree(map, inorder, 0, n - 1, postorder, 0, n - 1);
    }

    public TreeNode myBuildTree(Map<Integer, Integer> map, int[] inorder, int ileft, int iright, int[] postorder, int pleft, int pright) {
        if (ileft > iright) {
            return null;
        }
        // 根节点在后序遍历中的下标
        int proot = pright;
        // 根节点在中序遍历中的根节点
        int iroot = map.get(postorder[proot]);
        // 左子树的长度
        int leftSize = iroot - ileft;
        // 建立根节点
        TreeNode root = new TreeNode(postorder[proot]);
        root.left = myBuildTree(map, inorder, ileft, iroot - 1, postorder, pleft, pleft + leftSize - 1);
        root.right = myBuildTree(map, inorder, iroot + 1, iright, postorder, pleft + leftSize, pright - 1);
        return root;
    }
}
