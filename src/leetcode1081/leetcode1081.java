package leetcode1081;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class leetcode1081 {
    /**
     * 单调栈
     * @param s
     * @return
     */
    public String smallestSubsequence(String s) {
        int n = s.length();
        int[] cnt = new int[26];
        boolean[] visited = new boolean[26];
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            cnt[c]++;
        }
        // 此处单调栈为正向
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            cnt[c - 'a']--;
            if (visited[c - 'a']) continue;
            while (!stack.isEmpty() && c < stack.peek() && cnt[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast()); // 或者不用pollLast()，用poll()或者pop()然后直接在return那里sb.reverse().toString()就行
        }
        return sb.toString();
    }
}
