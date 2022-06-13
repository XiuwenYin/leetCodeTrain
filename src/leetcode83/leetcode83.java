package leetcode83;

// 删除排序链表中的重复元素
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

public class leetcode83 {
    /**
     * 迭代
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        // 设定 curr 指针指向当前节点
        ListNode curr = head;
        while (curr.next != null) {
            // 如果当前节点值等于下一个节点的值，删除下一个节点
            if (curr.val == curr.next.val){
                curr.next = curr.next.next;
            } else {
                // 如果不相同，则curr指向下一个节点
                curr = curr.next;
            }
        }
        return head;
    }
}