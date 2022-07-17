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
        board[r][c] = ' '; // 防止走回头路

        boolean res = dfs(board, arr, r + 1, c, index + 1)
                || dfs(board, arr, r - 1, c, index + 1)
                || dfs(board, arr, r, c + 1, index + 1)
                || dfs(board, arr, r, c - 1, index + 1);

        board[r][c] = arr[index];
        return res;
    }
}
