package practice;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class leetcodeTest2 {
    public int getNumber(TreeNode root, int[][] ops) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        dye(root, ops, 0, hashMap);

        int res = 0;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == 1) res++;
        }
        return res;
    }

    private void dye(TreeNode root,int[][] ops, int index, Map<Integer, Integer> hashMap) {
        if (root == null || index >= ops.length) return;
        int type = ops[index][0];
        if (root.val >= ops[index][1] && root.val <= ops[index][2]) {
//            hashMap.computeIfPresent(root.val, (k, v) -> ops[index][0]);
//            hashMap.put(root.val, ops[index][0]);
            hashMap.put(root.val, hashMap.getOrDefault(root.val, ops[index][0]));
        }
        dye(root.left, ops, index + 1, hashMap);
        dye(root.right, ops, index + 1, hashMap);
    }

    public static void main(String[] args) {
        SoftReference<Integer> num = new SoftReference<>(3);
        WeakReference<Integer> num2 = new WeakReference<>(2);
        ReferenceQueue<String> rq = new ReferenceQueue<>();
        System.gc();
    }

















}
