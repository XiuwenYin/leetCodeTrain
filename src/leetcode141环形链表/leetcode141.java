package leetcode141环形链表;

import java.util.HashMap;
import java.util.Map;

// 环形链表
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}


public class leetcode141 {
    /**
     * 使用哈希表存储ListNode出现次数
     */
    public boolean hasCycle(ListNode head) {
        Map<ListNode, Integer> hashMap = new HashMap<ListNode, Integer>();
        while (head != null) {
            hashMap.put(head, hashMap.getOrDefault(head, 0) + 1);
            if (hashMap.containsValue(2)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针
     * 慢指针在head
     * 快指针在head.next
     */
    public boolean hasCycle02(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 快慢指针练习
     * 更简洁
     * @param head
     * @return
     */
    public boolean hasCycle03(ListNode head) {
        if (head == null) return false;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }


    /**
     * 快慢指针
     * 但是把起点都改成了head
     */
    public boolean hasCycle04(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head, fast = head;
        do {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        while (fast != null && fast.next != null);
        return false;
    }





}
