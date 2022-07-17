package leetcode558四叉树交集;

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {
    }

    public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
}

public class leetcode558 {
    public Node intersect(Node t1, Node t2) {
        if (t1.isLeaf && t2.isLeaf) { // 如果二者都是叶子结点
            if (t1.val) return t1; // 逻辑或，所以找1，val = true代表1
            else if (t2.val) return t2;
            else return t1;
        }
        Node ans = new Node();
        ans.topLeft = intersect(t1.isLeaf ? t1 : t1.topLeft, t2.isLeaf ? t2 : t2.topLeft);
        ans.topRight = intersect(t1.isLeaf ? t1 : t1.topRight, t2.isLeaf ? t2 : t2.topRight);
        ans.bottomLeft = intersect(t1.isLeaf ? t1 : t1.bottomLeft, t2.isLeaf ? t2 : t2.bottomLeft);
        ans.bottomRight = intersect(t1.isLeaf ? t1 : t1.bottomRight, t2.isLeaf ? t2 : t2.bottomRight);

        boolean a = ans.topLeft.isLeaf && ans.topRight.isLeaf && ans.bottomLeft.isLeaf && ans.bottomRight.isLeaf;
        boolean b = ans.topLeft.val && ans.topRight.val && ans.bottomLeft.val && ans.bottomRight.val;
        boolean c = ans.topLeft.val || ans.topRight.val || ans.bottomLeft.val || ans.bottomRight.val;

        ans.isLeaf = a && (b || !c);
        ans.val = ans.topLeft.val;
        if (ans.isLeaf) ans.topLeft = ans.topRight = ans.bottomLeft = ans.bottomRight = null;
        return ans;
    }
}
