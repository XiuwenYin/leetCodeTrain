package leetcode79单词搜索;

public class leetcode79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        char[] arr = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, arr, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] arr, int r, int c, int index) {
        int m = board.length, n = board[0].length;
        if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] != arr[index]) return false;
        if (index == arr.length - 1) return true;
        board[r][c] = '*'; // 防止走回头路

        boolean res = dfs(board, arr, r + 1, c, index + 1)
                || dfs(board, arr, r - 1, c, index + 1)
                || dfs(board, arr, r, c + 1, index + 1)
                || dfs(board, arr, r, c - 1, index + 1);

        board[r][c] = arr[index];
        return res;
    }
}

/**
 * 神仙
 * 剪枝
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        int z = 0;
        int[] cache = new int[128];
        for (char c : chars) {
            cache[c]++; // 保存word中字符出现的次数
        }
        char startChar = chars[0], endChar = chars[chars.length - 1];
        for (char[] arr : board) {
            for (char c : arr) {
                cache[c]--; // 保存board中字符出现的次数
                if (c == startChar) {
                    z++; // 记录头字符出现的次数
                } else if (c == endChar) {
                    z--; // 记录尾字符出现的次数
                }
            }
        }
        for (int num : cache) {
            if (num > 0) {
                return false; // 如果在word中出现的次数比在board出现的次数多直接判false
            }
        }
        int step = 1, over = word.length(), idx = 0;
        // 如果尾字符出现次数少于头字符出现次数则尾遍历
        if (z > 0) {
            step = -1;
            over = -1;
            idx = word.length() - 1;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, chars, i, j, idx, over, step)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, char[] word, int r, int c, int idx, int over, int step) {
        if (idx == over) {
            return true;
        }
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word[idx]) {
            return false;
        }
        board[r][c] = '*';
        if (dfs(board, word, r + 1, c, idx + step, over, step)
                || dfs(board, word, r - 1, c, idx + step, over, step)
                || dfs(board, word, r, c + 1, idx + step, over, step)
                || dfs(board, word, r, c - 1, idx + step, over, step)) {
            return true;
        }
        board[r][c] = word[idx];
        return false;
    }
}
