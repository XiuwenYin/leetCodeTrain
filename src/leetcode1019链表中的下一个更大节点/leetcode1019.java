package leetcode1019链表中的下一个更大节点;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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

public class leetcode1019 {
    /**
     * 将链表的值放入list中再进行单调栈
     *
     * @param head
     * @return
     */
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>(); // 创建动态数组
        ListNode cur = head; // 创建链表指针
        while (cur != null) { // 如果指针没有指到null就添加当前val进入list
            list.add(cur.val);
            cur = cur.next; // 指针后移
        }
        int n = list.size(); // 获取list大小用于初始化结果集长度
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // 创建双端队列拿来当栈用
        for (int i = n - 1; i >= 0; i--) { // 遍历list
            // 如果栈不为空，且当前list的值大于等于栈顶元素的话，就弹出栈顶元素（维持单调性，栈底最大栈顶最小）
            while (!stack.isEmpty() && list.get(i) >= stack.peek()) {
                stack.pop();
            }
            // 此时如果栈不为空则为下一个最大元素，如果为空就直接放入0
            res[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(list.get(i)); // 压入当前值
        }
        return res;
    }

    /**
     * 先翻转链表，再使用单调栈
     * @param head
     * @return
     */
    public int[] nextLargerNodes01(ListNode head) {
        ListNode tail = reverse(head);
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[tail.val];
        int index = tail.val - 1;
        tail = tail.next;
        while (index >= 0) {
            while (!stack.isEmpty() && tail.val >= stack.peek()) {
                stack.poll();
            }
            res[index--] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(tail.val);
            tail = tail.next;
        }
        return res;
    }

    private ListNode reverse(ListNode head) {
        //之所以返回dummy是为了用dummy.val保存链表的长度
        ListNode dummy = new ListNode(-1);
        int count = 0;
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            count++;
        }
        dummy.val = count;
        dummy.next = pre;
        return dummy;
    }

}
