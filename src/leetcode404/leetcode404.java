package leetcode404;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 左叶子之和
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

public class leetcode404 {
    /**
     * DFS 深度遍历优先
     */
    public int sumOfLeftLeaves(TreeNode root) {
        // 结束条件
        if (root == null) {
            return 0;
        }
        int curVal = 0;
        // 判断是否有下一个左子节点
        // 并且判断当前节点的下一个左节点是否为叶子结点
        // 如果是，则取其值加入到答案中来，如果不是，则定义其值为0
        if (root.left != null && root.left.left == null && root.left.right == null) {
            curVal = root.left.val;
        }
        // 递归，对左右子节点递归和当前值相加即为答案
        return curVal + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    /**
     * BFS
     */
    public int sumOfLeftLeaves02(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                // 判断子节点是否为空，若不判断就添加则会出现空指针
                if (cur.left != null) {
                    // 进一步判断左子节点是否为叶子结点，如果是就将结果添加到 res 中
                    if (cur.left.left == null && cur.left.right == null) {
                        res += cur.left.val;
                    }
                    queue.offer(cur.left);
                }
                // 判断理由同上
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return res;
    }
}
