package leetcode876;
// 链表的中间节点
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

public class leetcode876 {
    /**
     * 快慢指针法
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        // 画图可得知结束条件是 fast == null（偶数个节点）和 fast.next == null（奇数个节点）
        while(fast != null && fast.next != null) {
            // 慢指针一次走一步，快指针一次走两步，结束时，慢指针必定在中间节点
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
