package leetcode113路径总和II;

import java.util.*;

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

public class leetcode113 {
    List<List<Integer>> res = new LinkedList<>();
    Deque<Integer> deque = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return res;
        dfs(root, targetSum);
        return res;
    }
    private void dfs(TreeNode root, int target) {
        if (root == null) return;
        deque.offer(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList<>(deque));
        }
        dfs(root.left, target);
        dfs(root.right, target);
        // 如果这条路走不通，就直接弹出这个叶子结点
        deque.pollLast();
    }


    /**
     * 回溯
     * 和上面基本一样
     */
    public List<List<Integer>> pathSum01(TreeNode root, int targetSum) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        backtracking(root, res, deque, targetSum);
        return res;
    }
    public void backtracking(TreeNode root, List<List<Integer>> res, Deque<Integer> deque, int targetSum) {
        if (root == null) return;

        deque.offerLast(root.val);

        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                res.add(new LinkedList<>(deque));
            }
        }

        targetSum -= root.val;
        backtracking(root.left, res, deque, targetSum);
        backtracking(root.right, res, deque, targetSum);
        deque.pollLast();
    }

    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();


    /**
     * bfs
     */
    public List<List<Integer>> pathSum02(TreeNode root, int targetSum) {
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queueNode = new LinkedList<TreeNode>();
        Queue<Integer> queueSum = new LinkedList<Integer>();
        queueNode.offer(root);
        queueSum.offer(0);

        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.poll();
            int rec = queueSum.poll() + node.val;

            if (node.left == null && node.right == null) {
                if (rec == targetSum) {
                    getPath(node);
                }
            } else {
                if (node.left != null) {
                    map.put(node.left, node);
                    queueNode.offer(node.left);
                    queueSum.offer(rec);
                }
                if (node.right != null) {
                    map.put(node.right, node);
                    queueNode.offer(node.right);
                    queueSum.offer(rec);
                }
            }
        }

        return ret;
    }

    public void getPath(TreeNode node) {
        List<Integer> temp = new LinkedList<Integer>();
        while (node != null) {
            temp.add(node.val);
            node = map.get(node);
        }
        Collections.reverse(temp);
        ret.add(new LinkedList<Integer>(temp));
    }
}
