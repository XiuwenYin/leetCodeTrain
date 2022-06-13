package leetcode203;

// 移除链表元素
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

public class leetcode203 {
    /**
     * 递归
     */
    public ListNode removeElements(ListNode head, int val) {
        // 递归终止条件是链表为空
        if (head == null) {
            return head;
        }
        head.next = removeElements(head.next, val);
        // 如果当前节点等与目标值，则当前节点被下一个节点替换
        if (head.val == val) {
            head = head.next;
            return head;
        } else {
            return head;
        }
    }

    /**
     * 迭代
     */
    public ListNode removeElements02(ListNode head, int val) {
        // 创建哑结点，当前值为0
        ListNode dummyHead = new ListNode(0);
        // 将哑结点和head相连
        dummyHead.next = head;
        // 创建 prev 指针
        ListNode prev = dummyHead;
        // while循环判断 prev.next是否为空，因为当前节点必定不为空（为0）
        while (prev.next != null) {
            // 当达成删除条件时
            if (prev.next.val == val) {
                // 此为删除语句
                prev.next = prev.next.next;
            } else {
                // 若不等于，则prev指向下一个节点
                prev = prev.next;
            }
        }
        // 返回哑结点的下一位
        return dummyHead.next;
    }

}
