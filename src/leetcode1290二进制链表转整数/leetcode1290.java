package leetcode1290二进制链表转整数;

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
     * 通俗解释就是每次res先*2（向左移动1位），再加上cur.val（因为cur.val是二进制，不是0就是1，在10进制范围内，所以单一数字直接加在res上不会有进制问题）
     */
    public int getDecimalValue02(ListNode head) {
        ListNode cur = head;
        int res = 0;
        while (cur != null){
            // 每次节点向下个节点移动，即为二进制数字向下一位移动
            // 每次res向左移动一位
            res <<= 1; // 注意！！ 这里计算符号是 <<=，有一个等号在
            res += cur.val;
            cur = cur.next;
        }
        return res;
    }
}
