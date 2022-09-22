package leetcode234回文链表;

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

public class leetcode234 {
    /**
     * 最快
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode pre = null;
        // 这一步将整条链表从中间分割为两部分，前半部分已经翻转，pre和slow分别从中间指向左右方向
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode cur = slow;
            slow = slow.next;
            cur.next = pre;
            pre = cur;
        }
        if (fast != null) slow = slow.next;
        while (pre != slow) { // 如果二者相等（地址），则说明指向了null
            if (pre.val != slow.val) return false;
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }
}
