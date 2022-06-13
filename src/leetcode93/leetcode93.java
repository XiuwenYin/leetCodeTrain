package leetcode93;

import java.util.*;

public class leetcode93 {
    /**
     * 回溯
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

    public static void main(String[] args){
//        System.out.println("二维数组的列数：");
        Scanner scan=new Scanner(System.in);
        int r=scan.nextInt();
        int c=scan.nextInt();
        int[][]matrix=new int[r][c];
        scan.nextLine();//用来跳过行列后的回车符
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                matrix[i][j]=scan.nextInt();
//                System.out.print(matrix[i][j]+",");
            }
//            System.out.println("");
        }
    }
}
