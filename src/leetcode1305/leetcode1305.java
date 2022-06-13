package leetcode1305;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

public class leetcode1305 {
    List<Integer> res = new ArrayList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
//        List<Integer> res = new ArrayList<>();
        BFS(root1);
        BFS(root2);
        res.sort((a, b)-> a - b);
        return res;
    }
    private void BFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
                res.add(temp.val);
            }
        }
    }
}
