package leetcode93;

import java.util.*;

public class leetcode93 {
    /**
     * 回溯
     *
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        List<String> res = new ArrayList<>();
        if (n < 4 || n > 12) {
            return res;
        }
        Deque<String> path = new ArrayDeque<>(4);
        dfs(s, n, 0, 4, path, res);
        return res;
    }

    private void dfs(String s, int n, int begin, int residue, Deque<String> path, List<String> res) {
        if (begin == n) {
            if (residue == 0) {
                res.add(String.join(".", path));
            }
            return;
        }
        for (int i = begin; i < begin + 3; i++) {
            if (i >= n) break;
            if (residue * 3 < n - i) continue;
            if (judgeIPSegment(s, begin, i)) {
                String currentIpSegment = s.substring(begin, i + 1);
                path.addLast(currentIpSegment);

                dfs(s, n, i + 1, residue - 1, path, res);
                path.removeLast();
            }
        }
    }

    private boolean judgeIPSegment(String s, int left, int right) {
        int len = right - left + 1;
        if (len > 1 && s.charAt(left) == '0') { // ip地址如果是两位数或者三位数不能以0开始
            return false;
        }
        int res = 0;
        while (left <= right) { // 将每个位置的数拼接成一个数
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }
        return res >= 0 && res <= 255; // 判断是否合法
    }

    public static void main(String[] args) {
//        System.out.println("二维数组的列数：");
        Scanner scan = new Scanner(System.in);
        int r = scan.nextInt();
        int c = scan.nextInt();
        int[][] matrix = new int[r][c];
        scan.nextLine();//用来跳过行列后的回车符
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = scan.nextInt();
//                System.out.print(matrix[i][j]+",");
            }
//            System.out.println("");
        }
    }
}

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        if (n < 4 || n > 16) return res;
        Deque<String> deque = new ArrayDeque<>();
        dfs(s, n, res, deque, 0, 4);
        return res;
    }

    /**
     * 存在 residue是难点
     * @param residue 剩余格子
     */
    public void dfs(String s, int n, List<String> res, Deque<String> deque, int idx, int residue) {
        if (idx == n) {
            if (residue == 0) { // 当没有格子时
                res.add(String.join(".", deque));
            }
            return;
        }
        for (int i = idx; i < idx + 3; i++) {
            if (i >= n) break;
            if (residue * 3 < n - i) continue;
            if (judge(s, idx, i)) {
                String currentIpSegment = s.substring(idx, i + 1);
                deque.addLast(currentIpSegment);
                dfs(s, n, res, deque, i + 1, residue - 1); // 注意参数，i + 1，格子减一
                deque.removeLast();
            }
        }
    }

    /**
     * 判断就两点：
     * 如果长度大于1则判断是否为0开头，是则返回false
     * 转换成数字并判断是否在 [0, 255] 之间
     */
    public boolean judge(String s, int left, int right) {
        int n = s.length();
        StringBuilder temp;
        if (right + 1 >= n) {
            temp = new StringBuilder(s.substring(left));
        }
        else {
            temp = new StringBuilder(s.substring(left, right + 1));
        }
        if (temp.length() > 1 && temp.charAt(0) == '0') return false;
        int cur = Integer.parseInt(temp.toString());
        return cur >= 0 && cur <= 255;
    }

}
