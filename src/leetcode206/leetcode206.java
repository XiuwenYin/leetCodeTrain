package leetcode206;

// 翻转链表
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

public class leetcode206 {
    /**
     * 迭代
     */
    public ListNode reverseList(ListNode head) {
        // 创建 prev指向链表反向的最后一位null（正向的第一位的前一位），curr指向当前位置
        ListNode prev = null, curr = head;
        // 当当前位置不为空（curr不为空）
        while (curr != null) {
            // 创建临时变量 next 记录 curr的下一位
            ListNode next = curr.next;
            // 当前curr指向前一位（第一次循环的话是第一位指向第一位的前一位，也就是指向null，即为反向后的最后一位）
            curr.next = prev;
            // prev移动到下一位，即移动到当前位
            prev = curr;
            // curr移动到下一位，即当前位移动到下一位，开启新一轮循环
            curr = next;
        }
        // 返回 prev
        return prev;
    }
}
