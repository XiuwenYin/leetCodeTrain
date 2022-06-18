package 剑指OfferII029排序的循环链表;

public class jianzhier029 {

}

class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};


class Solution {
    /**
     * 模拟 + 一次遍历
     * @param head
     * @param insertVal
     * @return
     */
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        // 原链表为空
        if (head == null) {
            node.next = node;
            return node;
        }
        // 原链表只有一个节点
        if (head.next == head) {
            head.next = node;
            node.next = head;
            return head;
        }
        // 原链表超过一个节点，找到新节点放入cur和next之间的位置
        Node cur = head, next = head.next;
        while (next != head) {
            /*cur.val > next.val 且 insertVal > cur.val，
            此时cur 和next分别是循环链表中的值最大的节点和值最小的节点，
            insertVal 大于cur的节点值，因此新节点应该在cur的后面插入，即在cur和next之间插入新节点；
            /*
            cur.val > next.val 且 insertVal < next.val，
            此时cur和next 分别是循环链表中的值最大的节点和值最小的节点，
            insertVal 小于 next 的节点值，因此新节点应该在next 的前面插入，即在cur和next 之间插入新节点*/
            if (insertVal >= cur.val && insertVal <= next.val) break;
            if (cur.val > next.val) {
                if (insertVal > cur.val || insertVal < next.val) break;
            }
            // 指针都向后移一位
            cur = cur.next;
            next = next.next;
        }
        cur.next = node;
        node.next = next;
        return head;
    }
}