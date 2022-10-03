package leetcode316去除重复字母;

import java.util.ArrayDeque;
import java.util.Deque;

public class leetcode316 {
    /**
     * 此题与1081相同
     * 单调栈
     *
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        int[] cnt = new int[26];
        boolean[] visited = new boolean[26];
        Deque<Character> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            cnt[c - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            cnt[c - 'a']--;
            if (visited[c - 'a']) continue;
            while (!dq.isEmpty() && c < dq.peek() && cnt[dq.peek() - 'a'] > 0) {
                visited[dq.pop() - 'a'] = false;
            }
            dq.push(c);
            visited[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) sb.append(dq.pollLast());
        return sb.toString();
    }
}
