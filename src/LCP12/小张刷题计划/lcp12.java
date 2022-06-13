package LCP12.小张刷题计划;

public class lcp12 {
    public int minTime(int[] time, int m) {
//        int left = 0, right = Integer.MAX_VALUE;
        int left = 0, right = 0;
        for (int x : time) {
            left = Math.max(left, x);
            right += x;
        }
        while(left <= right) {
            int mid = left + (right - left) / 2;
            //如果这个时间限制可以在规定天数里面完成刷题计划
            if(check(time, mid, m)) {
                //向左缩小查找范围
                right = mid - 1;
            }else {
                //反之 向右缩小查找范围
                left = mid + 1;
            }
        }
        return left;
    }

    boolean check(int[] time, int target, int m) {
        int maxTime = 0;
        int total = 0;
        //如果第一天就都做完了
        //后续代码不会将days进行递增 应该初始化为1
        int days = 1;
        //是否使用过了场外援助
        boolean helper = true;
        for(int i = 0; i < time.length; i++) {
            //维护花费时间最长的题目
            maxTime = Math.max(maxTime, time[i]);
            //累加这一天的总做题时间
            total += time[i];
            //如果超过当天做题时间限制了
            if(total > target) {
                //如果未使用过场外援助
                if(helper) {
                    //减去耗时最多的题目
                    total -= maxTime;
                    helper = false;
                }else {
                    //超时并且使用过场外援助
                    //得从下一天重新开始了
                    days++;
                    //刷新场外援助
                    helper = true;
                    //当天最大值刷新
                    maxTime = 0;
                    //总计时间刷新
                    total = 0;
                    //最重要的一点也很容易遗忘
                    //这道没有时间做的题目留到下一天重新开始做
                    i--;
                }
            }
        }
        return m >= days;
    }
}
