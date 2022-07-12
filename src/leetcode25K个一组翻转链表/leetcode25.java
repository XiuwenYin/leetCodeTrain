package leetcode25K个一组翻转链表;

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

public class leetcode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            // 找到分割位置
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;

            // 开始确认分割链表
            ListNode start = pre.next;
            ListNode next = end.next;

            // 分割 + 翻转 + 拼接
            end.next = null;
            pre.next = reverse(start);
            start.next = next;

            // 调整指针位置
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
