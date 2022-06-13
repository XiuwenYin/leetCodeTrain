package leetcode863;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class leetcode863 {
    Map<Integer, TreeNode> hashMap = new HashMap<>();
    List<Integer> res = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findParents(root);
        findRes(target, null, 0, k);
        return res;
    }
    // 找到当前节点的parent，通过递归，如果子节点不为空，则将子节点的值作为key，当前节点作为val存入hashmap
    public void findParents(TreeNode node) {
        if (node.left != null){
            hashMap.put(node.left.val, node);
            findParents(node.left);
        }
        if (node.right != null) {
            hashMap.put(node.right.val, node);
            findParents(node.right);
        }
    }

    public void findRes(TreeNode node, TreeNode from, int depth, int k) {
        if (node == null) return;
        // 如果深度和k相同，则在结果集添加当前节点值
        if (depth == k) {
            res.add(node.val);
            return;
        }
        // 否则，继续递归寻找，并且每次深度加1
        if (node.left != from) {
            findRes(node.left, node, depth + 1, k);
        }
        if (node.right != from) {
            findRes(node.right, node, depth + 1, k);
        }
        // 第三种情况，使用父节点向上搜索
        if (hashMap.get(node.val) != from) {
            findRes(hashMap.get(node.val), node, depth + 1, k);
        }
    }
}
