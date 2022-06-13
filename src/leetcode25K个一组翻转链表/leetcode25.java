package leetcode25K个一组翻转链表;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class leetcode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        ListNode dummyHead = new ListNode(0, head);
        ListNode pre = dummyHead, end = dummyHead;

        while (end != null && end.next != null) {
            for(int i = 0; i < k; i++) {
                end = end.next;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
        }
        return dummyHead.next;
    }
    public ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
