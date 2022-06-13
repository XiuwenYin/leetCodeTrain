package leetcode217;

import java.util.HashSet;
import java.util.Set;

public class leetcode217 {
//    public boolean containsDuplicate(int[] nums) {
//        // 使用哈希表
//        HashSet<Integer> res = new HashSet<Integer>();
//        for (int i : nums) {
//            res.add(i);
//        }
//        // 比较结果返回 T or F
//        return nums.length != res.size();
//    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<Integer>();
        for (int x : nums) {
            hashSet.add(x);
        }
        return hashSet.size() != nums.length;
    }

    public static void main(String[] args) {
        int[] x = new int[4];
        x[0] = 1;
        x[1] = 2;
        x[2] = 3;
        x[3] = 4;

        leetcode217 con = new leetcode217();
        boolean b = con.containsDuplicate(x);
        System.out.println(b);


    }
}
