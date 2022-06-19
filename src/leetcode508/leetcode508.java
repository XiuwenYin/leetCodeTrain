package leetcode508;

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

public class leetcode508 {
    Map<Integer, Integer> hashMap = new HashMap<>();
    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        posOrder(root);
        Set<Integer> set = hashMap.keySet();
        int n = 0;
        for (Integer key : set) {
            if (hashMap.get(key) == max){
                n++;
            }
        }
        int[] ans = new int[n];
        n = 0;
        for (Integer key : set) {
            if (hashMap.get(key) == max) {
                ans[n++] = key;
            }
        }
        return ans;
    }
    public int posOrder(TreeNode root){
        if (root == null) return 0;
        int left = posOrder(root.left);
        int right = posOrder(root.right);
        int sum = left + right + root.val;
        hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
        max = Math.max(max, hashMap.get(sum));
        return sum;
    }
}

class leetcode508_1 {
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> list = new ArrayList<>();
        for (int k : map.keySet()) {
            if (map.get(k) == max) list.add(k);
        }
        int n = list.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) ans[i] = list.get(i);
        return ans;
    }

    int dfs(TreeNode root) {
        if (root == null) return 0;
        int cur = root.val + dfs(root.left) + dfs(root.right);
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        max = Math.max(max, map.get(cur));
        return cur;
    }
}
