package leetcode733图像渲染;

public class leetcode733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length, n = image[0].length;
        if (image[sr][sc] != 0) dfs(image, sr, sc, newColor);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int newColor) {
        int m = image.length, n = image[0].length;
        if (image[r][c] == 0) return;
        if (r < 0 || r >= m || c < 0 || c >= n || image[r][c] == newColor) return;
        image[r][c] = newColor;
        dfs(image, r + 1, c, newColor);
        dfs(image, r - 1, c, newColor);
        dfs(image, r, c + 1, newColor);
        dfs(image, r, c - 1, newColor);
    }
}
