package leetcode1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leetcode1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[0];
    }

    /**
     * 字符串形式的数组转为int数组
     * @param args
     */
    public static void main(String[] args) {
        String list = "[1,2,3,4,5]";
        list = list.substring(1, list.length() - 1); // 切割中括号
        String[] strings = list.split(","); // 分割字符

        int[] array = Arrays.asList(strings).stream().mapToInt(Integer::parseInt).toArray(); // 转为array数组

        for (int x : array) {
            System.out.println(x);
        }
    }
}

