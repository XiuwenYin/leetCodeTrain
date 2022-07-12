package leetcode3无重复字符的最长子串;

import java.util.*;

public class leetcode3 {
    /**
     * 读题！其实很简单！
     * 要找到不重复的最长子串的话
     * 取start = 0， end = 0；end往下走，
     * 每次经历的 c = s.charAt(end)，找看看c在map中出现过没有，如果没有就把c为key，end为val放入
     * 如果出现过，那么代表子串已经开始重复了，就要重新开始定义start的位置，每次用Math.max
     * 并且每次循环都更新res的长度，也是用MAth.max
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int res = 0;
        Map<Character, Integer> hashMap = new HashMap<>();
        for (int start = 0, end = 0; end < n; end++) {
            char c = s.charAt(end);
            if (hashMap.containsKey(c)) {
                // 因为重复了，所以更新的start值需要对比get结果位置+1的值
                start = Math.max(hashMap.get(c) + 1, start);
            }
            res = Math.max((end - start + 1), res);
            hashMap.put(c, end);
        }
        return res;
    }

    /**
     * 使用set去重
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring01(String s) {
        int n = s.length();
        int left = 0;
        int res = 0;
        Set<Character> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            while (!hashSet.add(c)) hashSet.remove(s.charAt(left++));
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

    /**
     * 自己写的
     * map + 滑动窗口
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring02(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int res = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = arr[i];
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.get(c) > 1) {
                char temp = arr[left];
                map.put(temp, map.get(temp) - 1);
                left++;
            }

            res = Math.max(res, i - left + 1);
        }
        return res;
    }


    public static void main(String[] args) {
//        System.out.println("二维数组的列数：");
        Scanner scan = new Scanner(System.in);
        int r = scan.nextInt();
        int c = scan.nextInt();
        int[][] matrix = new int[r][c];
        scan.nextLine();//用来跳过行列后的回车符
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = scan.nextInt();
//                System.out.print(matrix[i][j]+",");
            }
//            System.out.println("");
        }
    }
}
