package leetcode23合并K个升序链表;

import java.util.PriorityQueue;

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

public class leetcode23 {
    /*
    堆，优先队列
    将每个链表都加入到堆中，然后利用堆的性质，对堆顶做弹出，弹出堆顶链表后再将链表指针后移，再添加入堆
     */
    public ListNode mergeKLists(ListNode[] lists) {
        // 创建堆（优先队列），创建comparator，因为堆无法比较ListNode的大小
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        // 将所有的链表添加入堆中，堆会对链表头进行自动排序
        for (ListNode x : lists) {
            if (x != null) {
                heap.offer(x);
            }
        }
        // 创建结果集
        ListNode res = new ListNode(0);
        // 创建指针
        ListNode cur = res;
        // 若堆非空，则表示排序弹出未结束
        while (!heap.isEmpty()) {
            // 弹出堆顶链表
            ListNode top = heap.poll();
            // 将堆顶链表元素放入结果集中
            cur.next = top;
            // 指针后移
            cur = cur.next;
            // 如果弹出的链表不为空，则表示链表后面还有元素，再次添加入堆中
            if (top.next != null) {
                heap.offer(top.next);
            }
        }
        return res.next;
    }

    /**
     * 分治
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists01(ListNode[] lists) {
        return partion(lists, 0, lists.length - 1);
    }

    private ListNode partion(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        if (start < end) {
            int mid = start + (end - start) / 2;
            ListNode ln1 = partion(lists, start, mid);
            ListNode ln2 = partion(lists, mid + 1, end);
            return merge(ln1, ln2);
        }
        return null;
    }

    private ListNode merge(ListNode ln1, ListNode ln2) {
        if (ln1 == null) return ln2;
        if (ln2 == null) return ln1;
        if (ln1.val  < ln2.val) {
            ln1.next = merge(ln1.next, ln2);
            return ln1;
        } else {
            ln2.next = merge(ln1, ln2.next);
            return ln2;
        }
    }

    /**
     * 练习
     */
    public ListNode mergeKLists02(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode x : lists) {
            if (x != null) {
                heap.offer(x);
            }
        }
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (!heap.isEmpty()) {
            ListNode top = heap.poll();
            cur.next = top;
            if (top.next != null) heap.offer(top.next);
            cur = top;
        }
        return res.next;
    }
}
