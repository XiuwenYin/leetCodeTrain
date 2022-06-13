package leetcode82;

import java.util.List;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class leetcode82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0, head);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null || cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int temp = cur.next.val;
                while (cur.next != null && cur.next.next.val == temp) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
