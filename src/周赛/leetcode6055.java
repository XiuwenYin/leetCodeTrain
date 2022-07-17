package 周赛;

public class leetcode6055 {
    public int convertTime(String current, String correct) {
        int step = 0;
        int h1 = correct.charAt(0) * 10 + correct.charAt(1);
        int h2 = current.charAt(0) * 10 + current.charAt(1);
        int hDiff = h1 - h2;

        int m1 = correct.charAt(3) * 10 + correct.charAt(4);
        int m2 = current.charAt(3) * 10 + current.charAt(4);
        int mDiff = m1 - m2;

        int diff = hDiff * 60 + mDiff;

        while (diff != 0) {
//            int temp = diff;
            if (diff >= 60) {
                step += diff / 60;
                diff %= 60;
            } else if (diff < 60 && diff >= 15) {
                step += diff /15;
                diff %= 15;
            } else if (diff < 15 && diff >= 5) {
                step += diff / 5;
                diff %= 5;
            } else {
                step += diff;
                break;
            }
        }
        return step;
    }
}
