package leetcode1609奇偶树;

import java.util.ArrayDeque;
import java.util.Deque;

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

public class leetcode1609 {
    /**
     * bfs
     * On On
     * @param root
     * @return
     */
    public boolean isEvenOddTree(TreeNode root) {
        boolean isOdd = true;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            // 其实也可以判定为0或Integer.MAX_VALUE
            int compare = isOdd ? q.peek().val - 1 : q.peek().val + 1;
            for (int s = 0; s < size; s++) {
                TreeNode temp = q.poll();
                int val = temp.val;
                if (isOdd) { // 判断奇偶的同时判断单调性
                    if ((val & 1) == 0 || compare >= val) return false;
                } else {
                    if ((val & 1) != 0 || compare <= val) return false;
                }

                if (temp.left != null) q.offer(temp.left);
                if (temp.right != null) q.offer(temp.right);
                compare = val; // 更新compare为当前val
            }
            isOdd = !isOdd; // 更新奇偶性
        }
        return true;
    }
}
