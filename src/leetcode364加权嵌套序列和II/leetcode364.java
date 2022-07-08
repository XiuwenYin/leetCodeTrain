package leetcode364加权嵌套序列和II;

import java.util.List;

public class leetcode364 {
}

class Solution {
    interface NestedInteger {
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

    public int depthSumInverse(List<NestedInteger> nestedList) {
        int deepth = getDeepth(nestedList);
        return dfs(nestedList, deepth);
    }

    private int getDeepth(List<NestedInteger> nestedList) {
        int dep = 1;
        for (NestedInteger x : nestedList) {
            if (!x.isInteger()) {
                dep = Math.max(dep, getDeepth(x.getList()) + 1);
            }
        }
        return dep;
    }

    private int dfs(List<NestedInteger> nestedList, int deepth) {
        int res = 0;
        for (NestedInteger x : nestedList) {
            if (x.isInteger()) res += x.getInteger() * deepth;
            else res += dfs(x.getList(), deepth - 1);
        }
        return res;
    }
    Object o = new boolean[2];
}