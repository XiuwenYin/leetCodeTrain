package practice02;

import java.util.Arrays;
import java.util.Scanner;

public class test2 {
//    public static void main(String[] args) {
    // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
    // please finish the function body here.
    // please define the JAVA output here. For example: System.out.println(s.nextInt());

//        Scanner scan = new Scanner(System.in);
//        int m = scan.nextInt();
//        int n = scan.nextInt();
//        int[] a = new int[]{scan.nextInt()};
//        String s = String.valueOf(scan.nextInt());
//        System.out.println(s);
//        String[] strings = s.split(" ");
//        int[] array = Arrays.asList(strings).stream().mapToInt(Integer::parseInt).toArray();
//        System.out.println(m);
//        System.out.println(n);
//        for (int x : array) {
//            System.out.println(x);
//        }
//    }

    public static void main(String[] args) {
        // 构造数组
        Scanner scan = new Scanner(System.in);
        int r = scan.nextInt();
        int c = scan.nextInt();
        if (r == 0 && c == 0) {
            System.out.println("0");
            return;
        }
        int[][] matrix = new int[r][c];
        scan.nextLine();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int temp = scan.nextInt();
                if (temp == 0) {
                    matrix[i][j] = 999;
                } else {
                    matrix[i][j] = temp;
                }
            }
        }
        if (r == 1 && c == 1) {
            System.out.println(matrix[0][0]);
            return;
        }
        if (matrix[0][0] == 999) {
            System.out.println("0");
            return;
        }
        int res = 0;
        res = dfs(matrix);
        System.out.println(res);
    }

    public static int dfs(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        if (matrix == null || m == 0 || n == 0) return 0;

        int[][] dp = new int[m][n];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + matrix[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
