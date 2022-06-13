package leetcode143重排链表;

import java.util.List;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class leetcode143 {
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode mid = findMidNode(head);
        ListNode n1 = head;
        ListNode n2 = mid.next;
        mid.next = null;
        n2 = reverseNode(n2);
        mergeNode(n1, n2);

    }

    public ListNode findMidNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseNode(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public void mergeNode(ListNode n1, ListNode n2) {
        ListNode n1Temp, n2Temp;
        while (n1 != null && n2 != null) {
            n1Temp = n1.next;
            n2Temp = n2.next;

            n1.next = n2;
            n1 = n1Temp;

            n2.next = n1;
            n2 = n2Temp;
        }
    }
}
