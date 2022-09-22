package 剑指Offer36.二叉搜索树与双向链表;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

public class jianzhi36 {
    Node tail, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        head.left = tail;
        tail.right = head;
        return head;
    }

    public void dfs(Node cur) {
        if (cur == null) return;

        dfs(cur.left);

        if (tail != null) tail.right = cur; // 第二次到这里应该会实现这一步，tail实际上一直在head的左边
        else head = cur;

        cur.left = tail; // 第一次到这里的话是头尾相连
        tail = cur;
        dfs(cur.right);
    }
}

