package leetcode767重构字符串;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class leetcode767 {
    public String reorganizeString(String s) {
        int n = s.length();
        // 统计 有多少个字母 和 出现次数
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = s.charAt(i) - 'a';
            hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
        }
        // 将 字母-个数 加入进优先队列，按照个数降序排列
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            heap.add(new int[]{entry.getKey(), entry.getValue()});
        }
        //每次弹出优先队列前面两个元素，拼接结果
        StringBuilder sb = new StringBuilder();
        while (heap.peek()[1] > 0) {
            // 获取当前频率最高的
            int[] first = heap.poll();
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == (char)(first[0] + 'a')) {
                if (heap.isEmpty()) {
                    // 不存在频率第二高的字母
                    return "";
                }
                int[] second = heap.poll();
                if (second[1] <= 0) {
                    return "";
                }
                //拼接第二个字母, 将第一第二个字母放入 heap
                sb.append((char) (second[0] + 'a'));
                heap.add(first);
                second[1]--;
                heap.add(second);
            } else {
                //拼接第一个字母
                sb.append((char) (first[0] + 'a'));
                first[1]--;
                heap.add(first);
            }
        }
        return sb.toString();
    }
}
