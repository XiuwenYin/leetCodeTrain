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
    /**
     * 双指针
     * @param head
     * @param n
     * @return
     */
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

    /**
     * 朴素计数
     */
    public ListNode removeNthFromEnd01(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode slow = dummyHead, fast = dummyHead;
        int cnt = 0;
        while (fast != null) {
            fast = fast.next;
            cnt++;
        }
        int loc = cnt - n - 1;
        while (loc != 0) {
            slow = slow.next;
            loc--;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}
