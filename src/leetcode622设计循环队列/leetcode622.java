package leetcode622设计循环队列;

import java.util.Arrays;
import java.util.List;

public class leetcode622 {
    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
        circularQueue.enQueue(1); // 返回 true
        circularQueue.enQueue(2); // 返回 true
        circularQueue.enQueue(3); // 返回 true
        circularQueue.enQueue(4); // 返回 false，队列已满
        circularQueue.Rear(); // 返回 3
        circularQueue.isFull(); // 返回 true
        circularQueue.deQueue(); // 返回 true
        circularQueue.enQueue(4); // 返回 true
        circularQueue.Rear(); // 返回 4


    }
}

/**
 * 要求：不使用内置队列库
 * 链表实现（这个好记）
 * 这个和LRU和LFU比简单多了
 */
class MyCircularQueue {
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

    private ListNode head;
    private ListNode tail;
    private int cap;
    private int size;

    public MyCircularQueue(int k) {
        cap = k;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        ListNode node = new ListNode(value);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        head = head.next;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return head.val;
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return tail.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == cap;
    }
}

/**
 * 数组实现
 */
class MyCircularQueue01 {

    private int[] arr;
    private int size;
    private int head, end;

    public MyCircularQueue01(int k) {
        arr = new int[k + 1];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        arr[end] = value;
        end = (end + 1) % arr.length;
        size++;
        return true;
    }


    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        head = (head + 1) % arr.length;
        size--;

        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return arr[head];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[(end - 1 + arr.length) % arr.length];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return (end + 1) % arr.length == head;
    }
}