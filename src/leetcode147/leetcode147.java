package leetcode147;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class leetcode147 {
    /**
     * 插入排序（学）（没搞懂）
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {

        ListNode dummy = new ListNode(0); // 创建哑结点
        ListNode sorted = head; // 创建指针，指针左边全部排序好
        dummy.next = head; // 连接哑结点和头节点
        ListNode cur = head.next; // 创建当前指针，用于寻找sort的下一个比它大的节点

        while (cur != null) { // 当当前指针不为null，继续while循环
            if (sorted.val <= cur.val) { // 如果sorted位置val <= 当前位置val，sorted右移
                sorted = sorted.next;
            } else { // 如果不是，则创建pre指针，从头寻找比cur小的最大节点
                ListNode pre = dummy;
                while (pre.next.val <= cur.val) {
                    pre = pre.next; // 如果pre.next比cur小，则pre右移到pre.next，这样就能找到比cur小的最大节点（因为之前已经被sorted过了）
                }
                sorted.next = cur.next; // sorted.next直接连接到cur.next，孤立cur节点
                /* ！！将cur插入到pre的下一位，并且将原本pre的下一位变成cur的下一位（通俗讲解就是cur挤进了pre和pre.next中间）！！*/
                cur.next = pre.next;
                pre.next = cur; // pre右移
            }
            cur = sorted.next; // cur移动到sorted的下一位
        }
        return dummy.next;
    }
}
