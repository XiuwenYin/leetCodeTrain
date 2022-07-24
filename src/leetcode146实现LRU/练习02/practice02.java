package leetcode146实现LRU.练习02;

import java.util.HashMap;
import java.util.Map;

public class practice02 {
}

class Node {
    int key;
    int value;

    Node pre;
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

    public DoubleLinkedList() {
        head = new Node();
        tail = new Node();

        head.post = tail;
        tail.pre = head;
    }

    public void addToHead(Node node) {
        node.pre = head;
        node.post = head.post;
        head.post.pre = node;
        head.post = node;
    }

    public void removeNode(Node node) {
        node.pre.post = node.post;
        node.post.pre = node.pre;
    }

    public void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    public Node removeLast() {
        Node last = tail.pre;
        removeNode(last);
        return last;
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
        if (node == null) {
            node = new Node(key, value);
            cache.put(key, node);
            linkedList.addToHead(node);
            size++;
            if (size > capacity) {
                Node last = linkedList.removeLast();
                cache.remove(last.key);
                size--;
            }
        } else {
            node.value = value;
            linkedList.moveToHead(node);
        }
    }
}

