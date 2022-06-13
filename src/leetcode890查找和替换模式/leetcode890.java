package leetcode890查找和替换模式;

import java.util.*;

public class leetcode890 {
    /**
     * 使用映射
     *
     * @param words
     * @param pattern
     * @return
     */
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new LinkedList<>();
        for (String word : words) {
            if (match(word, pattern) && match(pattern, word)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean match(String word, String pattern) {
        Map<Character, Character> map = new HashMap<>();
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char c1 = word.charAt(i), c2 = pattern.charAt(i);
            if (!map.containsKey(c1)) {
                map.put(c1, c2);
            } else {
                if (map.get(c1) != c2) return false;
            }
        }
        return true;
    }

    /**
     * 映射，模拟
     * 更快，也更省空间
     *
     * @param word
     * @param pattern
     * @return
     */
    public List<String> findAndReplacePattern01(String[] word, String pattern) {
        List<String> res = new ArrayList<>();
        int[] map = new int[26], visited = new int[26];
        for (String s : word) {
            Arrays.fill(map, -1);
            Arrays.fill(visited, 0);
            boolean okay = true;
            for (int i = 0; i < pattern.length() && okay; i++) {
                int c1 = s.charAt(i) - 'a', c2 = pattern.charAt(i) - 'a';
                if (map[c1] == -1 && visited[c2] == 0) {
                    map[c1] = c2;
                    visited[c2] = 1;
                } else if (map[c1] != c2) okay = false;
            }
            if (okay) res.add(s);
        }
        return res;
    }
}
