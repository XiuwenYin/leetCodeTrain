package leetcode636函数的独占时间;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class leetcode636 {
    /**
     * 模拟栈
     */
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Deque<Integer> oprandStack = new ArrayDeque<>();
        int cur = -1;
        for (String log : logs) {
            String[] pars = log.split(":");
            int idx = Integer.parseInt(pars[0]);
            int time = Integer.parseInt(pars[2]);

            if (pars[1].equals("start")) {
                if (!oprandStack.isEmpty()) {
                    res[oprandStack.peekLast()] += time - cur;
                }
                oprandStack.addLast(idx);
                cur = time;
            } else {
                // 此时 log[i]log[i] 的结束时间与上一次记录的当前时间的时长 ts - cur + 1，
                // 必然是该函数的执行时间，将其累加到当前函数中，并更新当前时间。
                int oprating = oprandStack.pollLast();
                res[oprating] += time - cur + 1;
                cur = time + 1;
            }
        }
        return res;
    }
}
