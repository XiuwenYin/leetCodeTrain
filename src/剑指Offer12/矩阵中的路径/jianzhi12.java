package 剑指Offer12.矩阵中的路径;

public class jianzhi12 {
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

    private boolean dfs(char[][] board, char[] arr, int row, int col, int index) {
        int m = board.length, n = board[0].length;
        if (row < 0 || row >= m || col < 0 || col >= n || board[row][col] != arr[index]) return false;
        if (index == arr.length - 1) return true;
        board[row][col] = ' ';

        boolean res = dfs(board, arr, row + 1, col, index + 1)
                || dfs(board, arr, row - 1, col, index + 1)
                || dfs(board, arr, row, col + 1, index + 1)
                || dfs(board, arr, row, col - 1, index + 1);

        board[row][col] = arr[index];
        return res;
    }
}
