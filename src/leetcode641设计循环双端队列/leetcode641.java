package leetcode641设计循环双端队列;

public class leetcode641 {
}

/**
 * 数组模拟
 * 双指针
 */
class MyCircularDeque {
    int[] deque;
    int head = 0;
    int tail;
    int size = 0;
    int length;

    public MyCircularDeque(int k) {
        deque = new int[k];
        tail = k - 1;
        length = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        deque[head = head == 0 ? length - 1 : head - 1] = value; // 头指针左移 (与一般人思路不一样
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        deque[tail = tail == length - 1 ? 0 : tail + 1] = value; // 尾指针右移
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        head = head == length - 1 ? 0 : head + 1; // 无需实际删除，仅需移动指针即可
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        tail = tail == 0 ? length - 1 : tail - 1;
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return deque[head];
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return deque[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == length;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */