package leetcode86分隔链表;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class leetcode86 {
    /**
     * 双指针
     * 维护两个新的链表，一大一小，最后小末尾接大头顶
     */
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode ptr1 = small;
        ListNode big = new ListNode(0);
        ListNode ptr2 = big;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                ptr1.next = cur;
                ptr1 = ptr1.next;
                cur = cur.next;
            } else {
                ptr2.next = cur;
                ptr2 = ptr2.next;
                cur = cur.next;
            }
        }
        ptr1.next = big.next;
        ptr2.next = null; // 记得最后大末尾断开
        return small.next;
    }
}
