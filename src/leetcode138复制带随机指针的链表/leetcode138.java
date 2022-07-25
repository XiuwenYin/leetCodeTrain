package leetcode138复制带随机指针的链表;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class leetcode138 {
    public Node copyRandomList(Node head) {
        for (Node p = head; p != null; p = p.next.next) {  //复制每个节点，并将原链表和复制链表连在一起。
            Node q = new Node(p.val);
            q.next = p.next;
            p.next = q;
        }

        for (Node p = head; p != null; p = p.next.next) {   //复制random指针
            if (p.random != null)
                p.next.random = p.random.next;
        }

        //拆分两个链表，并复原原链表
        Node dummy = new Node(-1), cur = dummy;
        for (Node p = head; p != null; p = p.next) {
            Node q = p.next;
            cur.next = q;
            cur = cur.next;
            p.next = q.next;
        }

        return dummy.next;
    }

}
