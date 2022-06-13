package leetcode399;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];
        int equationSize = equations.size();
        UnionFind unionFind = new UnionFind(2 * equationSize);
        Map<String, Integer> hashMap = new HashMap<>(2 * equationSize);
        int id = 0;
        for (int i = 0; i < equationSize; i++) {
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);
            if (!hashMap.containsKey(var1)) {
                hashMap.put(var1, id);
                id++;
            }
            if (!hashMap.containsKey(var2)) {
                hashMap.put(var2, id);
                id++;
            }
            unionFind.union(hashMap.get(var1), hashMap.get(var2), values[i]);
        }

        int querySize = queries.size();
        for (int i = 0; i < querySize; i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);

            Integer id1 = hashMap.get(var1);
            Integer id2 = hashMap.get(var2);
            if (id1 == null || id2 == null) {
                res[i] = -1.0d;
            } else {
                res[i] = unionFind.isConnected(id1, id2);
            }
        }
        return res;
    }

    private class UnionFind {
        private int[] parent;

        // 节点指向父节点的权重值
        private double[] weight;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            // 对于每个节点来说，此时节点都指向自己，所以权值默认为1.0
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
//            Arrays.fill(weight, 1.0d);
        }

        public void union(int x, int y, double value) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx == rooty) {
                return;
            }
            parent[rootx] = rooty;
            weight[rootx] = weight[y] * value / weight[x];
        }

        /**
         * 路径压缩（path compression）
         *
         * @param x
         * @return 返回根节点（父节点）的id
         */
        public int find(int x) {
            // 如果x不是根节点
            if (x != parent[x]) {
                // 记录当前根节点（父节点）值
                int origin = parent[x];
                parent[x] = find(parent[x]);
                // 使用记录的之前父节点的值来找到之前父节点的权值；并每次都乘等来维护权重值
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public double isConnected(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx == rooty) {
                return weight[x] / weight[y];
            } else {
                return -1.0d;
            }
        }
    }
}

