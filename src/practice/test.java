package practice;

import java.util.*;

public class test {

}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        if (sum % 2 != 0) {
            System.out.println(-1);
        } else {
            int target = sum / 2;
            int[][] dp = new int[n][target + 1];
            for (int i = target; i >= arr[0]; --i) dp[0][i] = arr[0];
            for (int i = 1; i < n; ++i)
                for (int j = 0; j <= target; ++j) {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= arr[i]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - arr[i]] + arr[i]);
                    }
                }
            int temp = dp[n - 1][target];
            if (temp != target) System.out.println(-1);
            else {
                System.out.println(temp);
                int j = target;
                boolean[] visited = new boolean[n];
                for (int i = n - 1; i >= 1; i--) {
                    if (dp[i][j] != dp[i - 1][j]) {
                        j = j - arr[i];
                        visited[i] = true;
                    }
                }
                if (j != 0) {
                    visited[0] = true;
                }
                boolean start = false;
                for (int i = 0; i < n; ++i) {
                    if (visited[i]) {
                        if (!start) {
                            System.out.print(arr[i]);
                            start = true;
                        } else System.out.print(" " + arr[i]);

                    }
                }
                System.out.println();
                start = false;
                for (int i = 0; i < n; ++i) {
                    if (!visited[i]) {
                        if (!start) {
                            System.out.print(arr[i]);
                            start = true;
                        } else System.out.print(" " + arr[i]);
                    }
                }
            }
        }
    }
}


class Main01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] data = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
            sum += data[i];
        }
        if (sum % 2 == 1 || n == 1) {
            System.out.println(-1);
            return;
        }
        int target = sum / 2;
        // 转换为0-1背包问题
        // 创建二维状态数组，行：糖果索引，列：容量，dp[i][j] 表示从数组的 前i袋糖果
        // 范围内选取若干个正整数（可以是 0 个），是否存在一种选取方案使得被选取的正整数的和等于 j。初始时，dp 中的全部元素都是false。
        boolean[][] dp = new boolean[n + 1][target + 1];
        // 如果不选取任何正整数，则被选取的正整数等于 0。因此对于所有 0≤i<n，都有 dp[i][0]=true
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (j - data[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - data[i - 1]];
                }
            }
        }
        //通过dp可以判断选择前几袋糖果是否可以找到和为target
        // 并且我们可以通过下面的判断直接得到选了哪些糖果（结果可能有多种，这是按遍历顺序得到的)
        List<Integer>resLi=new ArrayList<>();
        while (target>0){
            for (int i = 0; i <= n; i++) {
                //找到第一个满足target的糖果，肯定选择了此袋糖果
                if(dp[i][target]){
                    resLi.add(data[i-1]);
                    //更新target
                    target=target-data[i-1];
                    //下次遍历直接到前n-1袋即可
                    n=i-1;
                    break;
                }
            }
        }
        Map<Integer,Integer>map=new HashMap<>();
        for (int i=0;i<data.length;i++){
            map.put(data[i],map.getOrDefault(data[i],0)+1);
        }
        //下面处理输出
        System.out.println(sum/2);
        for (int i=0;i<resLi.size();i++) {
            if(i==0){
                System.out.print(resLi.get(i));
                map.put(data[i],map.get(data[i])-1);
            }else {
                System.out.print(" "+resLi.get(i));
                map.put(data[i],map.get(data[i])-1);

            }

        }
        List<Integer>resHan=new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            if(map.get(data[i])>0){
                resHan.add(data[i]);
                map.put(data[i],map.get(data[i])-1);
            }
        }
        System.out.println();
        for (int i = 0; i <resHan.size() ; i++) {
            if(i==0){
                System.out.print(resHan.get(i));

            }else {
                System.out.print(" "+resHan.get(i));

            }
        }
    }
}
