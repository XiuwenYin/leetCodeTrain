package leetcode21;

import java.util.PriorityQueue;

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
            } else {
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

    /**
     * 优先队列（小顶堆）
     * ！！推荐用这个！！
     * 好理解
     * 先将list1和list2塞入pq，然后弹出堆顶元素挂载在dummyHead的指针cur上
     * 然后查看弹出的堆顶元素是否有next，有的话就继续塞入pq，直到pq为空为止
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists01(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) return list1 == null ? list2 : list1; // 添加了边界值判断，防止阴间测试用例gank
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        pq.offer(list1);
        pq.offer(list2);
        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            cur.next = temp;
            cur = cur.next;
            if (temp.next != null) pq.offer(temp.next);
        }
        return dummyHead.next;
    }
}

