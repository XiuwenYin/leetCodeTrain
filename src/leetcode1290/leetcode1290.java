package leetcode1290;

import java.util.ArrayList;
import java.util.Collections;

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

public class leetcode1290 {
    /**
     * 动态数组添加转换
     */
    public int getDecimalValue(ListNode head) {
        ListNode curr = head;
        ArrayList<Integer> list = new ArrayList<>();
        int res = 0;
        while(curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        // 反转数组
        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            // 位运算：每次都向左移动i位
            // 举例：由于是倒序遍历，第1次遍历的数字就是结果的第一位（个位），所以向左移动0位（i = 0）
            // 第二次遍历的数字就是结果的第二位（十位），所以向左移动1位（i = 1）
            res += list.get(i) << i;
        }
        return res;
    }

    /**
     * 位运算
     */
    public int getDecimalValue02(ListNode head) {
        ListNode curr = head;
        int res = 0;
        while (curr != null){
            // 每次节点向下个节点移动，即为二进制数字向下一位移动
            // 每次res向左移动一位
            res <<= 1;
            res += curr.val;
            curr = curr.next;
        }
        return res;
    }
}
