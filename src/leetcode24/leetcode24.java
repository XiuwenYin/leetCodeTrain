package leetcode24;

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

public class leetcode24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    public ListNode swapPairs01(ListNode head) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode temp = dummyHead;
        while (temp.next != null || temp.next.next != null) {
            ListNode n1 = temp.next;
            ListNode n2 = temp.next.next;
            temp.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            temp = n1;
        }
        return dummyHead.next;
    }
}
