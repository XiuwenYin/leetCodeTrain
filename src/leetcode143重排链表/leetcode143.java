package leetcode143重排链表;

import java.util.List;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class leetcode143 {
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode mid = findMidNode(head);
        ListNode n1 = head;
        ListNode n2 = mid.next;
        mid.next = null;
        n2 = reverseNode(n2);
        mergeNode(n1, n2);

    }

    public ListNode findMidNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseNode(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public void mergeNode(ListNode n1, ListNode n2) {
        ListNode n1Temp, n2Temp;
        while (n1 != null && n2 != null) {
            n1Temp = n1.next;
            n2Temp = n2.next;

            n1.next = n2;
            n1 = n1Temp;

            n2.next = n1;
            n2 = n2Temp;
        }
    }
}

/**
 * 练习
 * 本质就是三部分：找中点，切割中点后部分并翻转，一个接一个拼接两段链表
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode mid = findMid(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null; // 切割
        l2 = reverse(l2);
        merge(l1, l2);
    }

    /**
     * 快慢指针找中点
     */
    public ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 辅助指针翻转（迭代）
     */
    public ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 辅助指针merge
     * l1(旧) -> l2(旧) -> l1(新)
     */
    public void merge(ListNode l1, ListNode l2) {
        ListNode t1, t2;
        while (l1 != null && l2 != null) {
            t1 = l1.next;
            t2 = l2.next;

            l1.next = l2;
            l1 = t1;

            l2.next = l1;
            l2 = t2;
        }
    }
}