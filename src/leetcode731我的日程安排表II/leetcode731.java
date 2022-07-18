package leetcode731我的日程安排表II;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class leetcode731 {
}

class MyCalendarTwo {
    TreeMap<Integer, Integer> cnt;
    public MyCalendarTwo() {
        cnt = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        int res = 0, maxBook = 0;
        /* 在 start 计数 cnt[start] 加 1，表示从 start 预定的数目加 1；
           从 end 计数 cnt[end] 减 1，表示从 end 开始预定的数目减 1 */
        cnt.put(start, cnt.getOrDefault(start, 0) + 1);
        cnt.put(end, cnt.getOrDefault(end, 0) - 1);
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            int freq = entry.getValue();
            maxBook += freq;
            res = Math.max(res, maxBook);
            if (maxBook > 2) { // 如果发现非法，则减去非法区间
                cnt.put(start, cnt.getOrDefault(start, 0) - 1);
                cnt.put(start, cnt.getOrDefault(start, 0) + 1);
                return false;
            }
        }
        return true;
    }
}