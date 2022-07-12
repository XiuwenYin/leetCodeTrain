package leetcode199;

import java.util.*;

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

public class leetcode199 {
    /**
     * BFS
     */
    public List<Integer> rightSideView(TreeNode root) {
        // 同样使用广度优先搜索一般模板
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            res.add(queue.peek().val);
            // 此处反向添加
            // 先 right 后 left，这样就使得每次出队列的都是最右侧的节点，所以适用一般模板
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
            }
        }
        return res;
    }

    /**
     * bfs
     * 自己写的，觉得更好
     * 就朴素bfs，每次遍历前放置一个val用于存储temp.val
     * 每次遍历完后必定会将最右的节点的val赋值给val，然后放入结果集即可
     * @param root
     * @return
     */
    public List<Integer> rightSideView01(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int val = Integer.MAX_VALUE;
            for(int s = 0; s < size; s++) {
                TreeNode temp = q.poll();
                if (temp.left != null) q.offer(temp.left);
                if (temp.right != null) q.offer(temp.right);
                val = temp.val;
            }
            res.add(val);
        }
        return res;
    }
}
