package leetcode30串联所有单词的子串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode30 {
    /**
     * 朴素哈希表 (双哈希表)
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int n = s.length(), m = words.length, w = words[0].length();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int tol = m * w;
        out : for (int i = 0; i + tol <= n; i++) {
            Map<String, Integer> cur = new HashMap<>();
            String sub = s.substring(i, i + tol);
            for (int j = 0; j < sub.length(); j += w) {
                String item = sub.substring(j, j + w);
                if (!map.containsKey(item)) continue out; // 剪枝操作
                cur.put(item, cur.getOrDefault(item, 0) + 1);
            }
            if (cur.equals(map)) res.add(i);
        }
        return res;
    }

    /**
     * 滑动窗口 + 哈希表
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring01(String s, String[] words) {
        int n = s.length(), m = words.length, w = words[0].length();
        int tol = m * w;
        // 统计 words 中「每个目标单词」的出现次数
        Map<String, Integer> map = new HashMap<>();
        for (String str : words) map.put(str, map.getOrDefault(str, 0) + 1);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < w; i++) {
            // 构建一个当前子串对应的哈希表，统计当前子串中「每个目标单词」的出现次数
            Map<String, Integer> temp = new HashMap<>();
            // 滑动窗口的大小固定是 m * w，每次将下一个单词添加进 temp，上一个单词移出 temp
            for (int j = i; j + w <= n; j += w) {
                String cur = s.substring(j, j + w);
                temp.put(cur, temp.getOrDefault(cur, 0) + 1);
                if (j >= i + tol) {
                    int idx = j - tol;
                    String prev = s.substring(idx, idx + w);
                    if (temp.get(prev) == 1) temp.remove(prev);
                    else temp.put(prev, temp.get(prev) - 1);
                    if (!temp.getOrDefault(prev, 0).equals(map.getOrDefault(prev, 0))) continue;
                }
                if (!temp.getOrDefault(cur, 0).equals(map.getOrDefault(cur, 0))) continue;
                // 上面两个 continue 可以减少 map 之间的 equals 操作
                if (temp.equals(map)) ans.add(j - (m - 1) * w);
            }
        }
        return ans;
    }
}
