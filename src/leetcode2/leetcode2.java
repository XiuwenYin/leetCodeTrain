package leetcode2;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

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

public class leetcode2 {
    /**
     * 模拟
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode res = new ListNode(0); // 创建空链表
        ListNode cur = res; // 创建指针
        while (l1 != null || l2 != null) { // 只要l1或者l2任意一方不为空，就进行下去
            int x = l1 == null ? 0 : l1.val; // 获取当前位置的数字
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry; // 将当前局部解定义

            carry = sum / 10; // 更新进位
            sum %= 10; // 取余，不会伤害到个位上的数字

            cur.next = new ListNode(sum); // 创建链表的下一位
            cur = cur.next; // 更新指针
            if (l1 != null) l1 = l1.next; // 更新 l1 l2
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1) { // 个位数和个位数相加最多进位就是10
            cur.next = new ListNode(1);
        }
        return res.next;
    }


    public ListNode addTwoNumbers01(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;

            cur.next = new ListNode(sum);
            cur = cur.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return res.next;
    }


    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        System.out.println(s);
        String[] arr = s.split(" ");
        double sum = 0.0, cnt = 0.0;
        System.out.println(arr.length);
        for (int i = 0; i < arr.length; i++) {
            int len = arr[i].length();
            sum += len;
            cnt++;
            System.out.println(arr[i]);
        }
        double num= sum / cnt;
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        String res = df.format(num);
        System.out.println(res);
    }
}
