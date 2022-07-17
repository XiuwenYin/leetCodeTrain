package 周赛;

public class leetcode6033 {
    public int minBitFlips(int start, int goal) {
        int res = start ^ goal;
        return Integer.bitCount(res);
    }

    public static void main(String[] args) {
        int x = 10 ^ 7;
        System.out.println(Integer.bitCount(x));
    }
}
