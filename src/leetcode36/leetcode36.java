package leetcode36;

// 有效的数独
public class leetcode36 {
    /**
     * 一次遍历
     * 使用哈希表记录每次数字出现的次数
     */
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][][] jiugongge = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    // 每次的格子中的数字用数字-1来作为索引：字符7的索引是数字6
                    int index = board[i][j] - '1';
                    // 例如现在是第一行第一列是9，就在row[1][8]号位置+1
                    row[i][index]++;
                    col[j][index]++;
                    jiugongge[i / 3][j / 3][index]++;
                    if (row[i][index] > 1 || col[j][index] > 1 || jiugongge[i / 3][j / 3][index] > 1) return false;
                }

            }
        }
        return true;
    }
}
