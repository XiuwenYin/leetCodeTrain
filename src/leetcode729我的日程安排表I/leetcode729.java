package leetcode729我的日程安排表I;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode729 {
}

class MyCalendar {
    List<int[]> list = new ArrayList<>();
    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        end--;
        for (int[] x : list) {
            int left = x[0], right = x[1];
            if (start > right || end < left) continue;
            else return false;
        }
        list.add(new int[]{start, end});
        return true;
    }


}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */