package leetcode451根据字符出现频率排序;


import java.util.*;

public class leetcode451 {
    /**
     * 映射 + 优先队列
     * 创建Node类用于pq排序
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>(); // 将所有字符映射出现次数放入map
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        /* lambda设定排序规则，按照val进行大顶堆（优先），按照char进行小顶堆（其次）
        即如果频率不一样，则按照频率降序排列；否则按照字母顺序升序排列 */
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (a.v != b.v) return b.v - a.v;
            return a.c - b.c;
        });
        // 获取keySet然后每次new出一个Node放入pq
        for (char c : map.keySet()) {
            pq.offer(new Node(c, map.get(c)));
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Node temp = pq.poll();
            while (temp.v != 0) { // 每次拉扯一个c放入sb，并对频率减去1，直到频率为0；再进行下一个pq的poll()
                sb.append(temp.c);
                temp.v--;
            }
        }
        return sb.toString();
    }

    class Node{
        char c;
        int v;
        public Node(char c, int v) {
            this.c = c;
            this.v = v;
        }
    }


    /**
     * 桶排序
     * @param s
     * @return
     */
    public String frequencySort01(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int maxFreq = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int frequency = map.getOrDefault(c, 0) + 1;
            map.put(c, frequency);
            maxFreq = Math.max(maxFreq, frequency);
        }
        StringBuffer[] buckets = new StringBuffer[maxFreq + 1];
        for (int i = 0; i <= maxFreq; i++) {
            buckets[i] = new StringBuffer();
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            int frequency = entry.getValue();
            buckets[frequency].append(c);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = maxFreq; i > 0; i--) {
            StringBuffer bucket = buckets[i];
            int size = bucket.length();
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < i; k++) {
                    sb.append(bucket.charAt(j));
                }
            }
        }
        return sb.toString();
    }
}
