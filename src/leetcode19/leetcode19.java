package leetcode19;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class leetcode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.val = 0;
        dummyHead.next = head;
        ListNode prev = dummyHead, curr = head;
        for (int i = 0; i < n; i++) {
            curr = curr.next;
        }
        while (curr != null) {
            curr = curr.next;
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return dummyHead.next;
    }
}
