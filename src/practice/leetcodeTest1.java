package practice;

public class leetcodeTest1 {
    public int giveGem(int[] gem, int[][] operations) {
        int m = operations.length, n = gem.length;
        if (m == 0) return 0;
        for (int i = 0; i < m; i++) {
            int trans = gem[operations[i][0]] / 2;
//            int trans = operations[i][0] / 2;
//            System.out.println(trans);
            gem[operations[i][0]] -= trans;
            gem[operations[i][1]] += trans;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int x : gem) {
            min = Math.min(min, x);
            max = Math.max(max, x);
//            System.out.print(x + " ");
        }
//        System.out.println("");
//        System.out.println("min " + min);
//        System.out.println("max " + max);
        int res = max - min;
        return res;
    }

    public static void main(String[] args) {
        int[] gem = new int[]{3, 1, 2};
        int[][] operations = new int[][]{{0, 2}, {2, 1}, {2, 0}};
        leetcodeTest1 test = new leetcodeTest1();
        test.giveGem(gem, operations);
    }
}
