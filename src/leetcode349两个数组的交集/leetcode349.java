package leetcode349两个数组的交集;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        //遍历 nums1
        for (int i : nums1) {
            set1.add(i);
        }
        //遍历nums2，判断哈希表中是否存在该元素
        for (int i : nums2) {
            if (set1.contains(i)) {
                set2.add(i);
            }
        }
//         return set2.stream().mapToInt(Integer::intValue).toArray(); // 一句话，但是超慢
        int[] resArr = new int[set2.size()];
        int index = 0;
        for (int i : set2) {
            resArr[index++] = i;
        }
        return resArr;
    }
}
