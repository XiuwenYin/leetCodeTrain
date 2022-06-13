package leetcode50;

public class leetcode50 {
    public double myPow(double x, int n) {
        if (x == 0 || x == 1) return x;
        if (n < 0) return 1/ pow(x, -n);
        return pow(x, n);
    }

    private double pow(double x, int n){
        if (n == 0) return 1;
        double y = pow(x, n / 2); // 先取一半
        if (n % 2 == 0) return y * y; // 如果是偶数的power，就直接 y * y
        else return y * y * x; // 如果是奇数的power，就直接y * y * x;

    }
}
