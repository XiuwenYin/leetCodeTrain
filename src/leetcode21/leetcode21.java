package leetcode21;

// 合并两个有序链表
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

public class leetcode21 {
    /**
     * 迭代
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 1. 创建哨兵节点 preHead
        ListNode preHead = new ListNode();
        // 将第一位设定为 -1
        preHead.val = -1;
        // 创建哨兵节点指针 prev
        ListNode prev = preHead;
        // 当 list1 和 list2 都不为空时，比较大小，将小的一位传递给 prev.next，并将小的list指向下一位，判断语句结束后，prev也指向下一位
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                prev.next = list1;
                list1 = list1.next;
            }else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        // 当循环完毕，最多只能有一个list并未指向为空，
        // 此时三目运算：判断 list1 是否为空，若为空，prev.next指向 list2，若不为空，prev.next指向 list1
        prev.next = list1 == null ? list2 : list1;
        // 返回哨兵节点的下一位，因为第一位是-1
        return preHead.next;
    }
}
