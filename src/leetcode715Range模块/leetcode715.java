package leetcode715Range模块;

public class leetcode715 {

}

// 线段树
class RangeModule {

    public RangeModule() {

    }

    public void addRange(int left, int right) {
        // 1 表示覆盖；-1 表示取消覆盖
        update(root, 1, N, left, right - 1, 1);
    }

    public boolean queryRange(int left, int right) {
        return query(root, 1, N, left, right - 1);
    }

    public void removeRange(int left, int right) {
        // 1 表示覆盖；-1 表示取消覆盖
        update(root, 1, N, left, right - 1, -1);
    }

    // *************** 下面是模版 ***************
    class Node {
        Node left, right;
        // 表示当前区间是否被覆盖
        boolean cover;
        int add;
    }

    private int N = (int) 1e9;
    private Node root = new Node();

    public void update(Node node, int start, int end, int l, int r, int val) {
        if (l <= start && end <= r) {
            // 1 表示覆盖；-1 表示取消覆盖
            node.cover = val == 1;
            node.add = val;
            return;
        }
        int mid = (start + end) >> 1;
        pushDown(node, mid - start + 1, end - mid);
        if (l <= mid) update(node.left, start, mid, l, r, val);
        if (r > mid) update(node.right, mid + 1, end, l, r, val);
        pushUp(node);
    }

    public boolean query(Node node, int start, int end, int l, int r) {
        if (l <= start && end <= r) return node.cover;
        int mid = (start + end) >> 1;
        pushDown(node, mid - start + 1, end - mid);
        // 查询左右子树是否被覆盖
        boolean ans = true;
        if (l <= mid) ans = ans && query(node.left, start, mid, l, r);
        if (r > mid) ans = ans && query(node.right, mid + 1, end, l, r);
        return ans;
    }

    private void pushUp(Node node) {
        // 向上更新
        node.cover = node.left.cover && node.right.cover;
    }

    private void pushDown(Node node, int leftNum, int rightNum) {
        if (node.left == null) node.left = new Node();
        if (node.right == null) node.right = new Node();
        if (node.add == 0) return;
        node.left.cover = node.add == 1;
        node.right.cover = node.add == 1;
        node.left.add = node.add;
        node.right.add = node.add;
        node.add = 0;
    }
}