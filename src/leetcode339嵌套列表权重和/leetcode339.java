package leetcode339嵌套列表权重和;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class leetcode339 {
}



class Solution {
    public interface NestedInteger {
        // Constructor initializes an empty nested list.
//        public NestedInteger();

        // Constructor initializes a single integer.
//        public NestedInteger(int value);

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    /**
     * DFS
     * 每次深度 + 1，用自带的函数判断是不是int，是就用当前深度 * 值加在res上，不是就继续recursive
     *
     * @param nestedList
     * @return
     */
    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }

    private int dfs(List<NestedInteger> nestedList, int deepth) {
        int res = 0;
        for (NestedInteger x : nestedList) {
            if (x.isInteger()) res += x.getInteger() * deepth;
            else res += dfs(x.getList(), deepth + 1);
        }
        return res;
    }

    /**
     * BFS
     * 同理类似
     * @param nestedList
     * @return
     */
    public int depthSum01(List<NestedInteger> nestedList) {
        Queue<NestedInteger> q = new ArrayDeque<>(nestedList); // 构造时直接填入
        int res = 0, deepth = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                NestedInteger temp = q.poll();
                if (temp.isInteger()) res += temp.getInteger() * deepth;
                else q.addAll(temp.getList()); // 使用addAll()函数来添加所有的NestedInteger
            }
            deepth += 1;
        }
        return res;
    }
}