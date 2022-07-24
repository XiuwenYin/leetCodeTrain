package leetcode146实现LRU.练习01;

import java.util.HashMap;
import java.util.Map;

public class practice01 {
}

class Node {
    int key;
    int value;
    Node pre; // 自定义前置节点和后置节点，用于生成双向链表
    Node post;

    public Node() {
    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class DoubleLinkedList{
    Node head;
    Node tail;

    public DoubleLinkedList(){
        head = new Node();
        tail = new Node();

        head.post = tail; // 头节点下一个是尾结点
        tail.pre = head; // 尾结点前一个是头结点
    }

    public void addToHead(Node node) {
        node.pre = head;  // pre <- node ==> head <- node
        node.post = head.post; // node -> node.post ==> node -> head.post
        head.post.pre = node; // head的前一位的后一位原本是head自己，这里变成了 node <- head.post
        head.post = node; // 最后：head -> node -> node.post(原本的head.post); head <- node <- node.post
    }

    public void removeNode(Node node) {
        node.pre.post = node.post; // 本来是 pre -> node -> post，现在是 pre -> post
        node.post.pre = node.pre; // 本来是 pre <- node <- post，现在是 pre <- post
    }

    public void moveToHead(Node node) { // 就是前两个方法一拼接
        removeNode(node);
        addToHead(node);
    }

    public Node removeTail() {
        Node res = tail.pre;
        removeNode(res);
        return res;
    }
}


class LRUCache {

    Map<Integer, Node> cache;
    DoubleLinkedList linkedList;
    int capacity;
    int size;

    public LRUCache(int capacity) {
        cache = new HashMap<>(capacity);
        linkedList = new DoubleLinkedList();
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;
        linkedList.moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) { // 如果为空，则以参数的key, value创建新的node
            node = new Node(key, value);
            cache.put(key, node); // 并放入cache中
            linkedList.addToHead(node); // 并将这个节点移动至最前端
            size++; // 增加size
            if (size > capacity) { // 如果增加完后超出了容量，则删除尾部节点，并在cache map中也删除掉对应的键值对
                Node last = linkedList.removeTail();
                cache.remove(last.key);
                size--; // 记得再减去size
            }
        } else { // 如果节点不为空，则更新节点的value，并将当前节点移动至最前
            node.value = value;
            linkedList.moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */