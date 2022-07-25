package leetcode460LFU缓存;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class leetcode460 {

}

/**
 * 自定义节点，用于存储key,val，并且维护当前节点的频次，用于更新
 */
class Node {
    int key;
    int value;
    int freq = 1;
    Node pre; // 自定义前置节点和后置节点，用于生成双向链表
    Node post;

    public Node() {
    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class DoubleLinkedList {
    Node head;
    Node tail;

    public DoubleLinkedList() {
        head = new Node();
        tail = new Node();

        head.post = tail; // 头节点下一个是尾结点
        tail.pre = head; // 尾结点前一个是头结点
    }

    public void removeNode(Node node) {
        // 当前节点的前一位的后一位，本来应该是这个节点，为了删除这个节点，选择链接去下一个节点：pre -> node -> post... ==>  pre -> post...
        node.pre.post = node.post;
        node.post.pre = node.pre; // 同理，双向链表双指向 pre <- node <- post... ==> pre <- post...
    }

    public void addNode(Node node) {
        // 每次新增节点增加在head下一位
        node.post = head.post; // head -> head.post ==> head -> head.post， node -> head.post
        head.post.pre = node; // head下一个的前一个本是head，现在改为node
        head.post = node; // head下一个本是head.post，现在改为node
        node.pre = head; // node前一个本为空，现在改为head
    }

}

/**
 * 解法 — 自定义双向链表
 * HashMap<Integer, Node> cache 存缓存的内容;
 * min 是最小访问频次;
 * HashMap<Integer, DoublyLinkedList> freqMap 存每个访问频次对应的 Node 的双向链表
 * 只不过将 JDK 自带的 LinkedHashSet 双向链表实现改成了自定义的双向链表 DoublyLinkedList，减少了一些哈希相关的耗时）
 *
 * 与146LRU很类似，区别在于LRU是一个一维状态，而LFU由于多了freq这个参数变成了二维状态（多条链表形成一个面）
 */
class LFUCache {
    Map<Integer, Node> cache;  // 存储缓存的内容
    Map<Integer, DoubleLinkedList> freqMap; // 存储每个频次对应的双向链表（假设有3个节点都用了2次，但这仍然有先后顺序，所以如果需要删除则删除频次2的链表中tail节点的前一位）
    int size;
    int capacity;
    int min; // 存储当前最小频次

    public LFUCache(int capacity) {
        cache = new HashMap<>(capacity);
        freqMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        freqInc(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return; // 如果没有容量直接返回
        Node node = cache.get(key); // 从缓存map中拉取当前key的节点
        if (node != null) { // 如果节点为空，则将当前空节点的val设置为value
            node.value = value;
            freqInc(node); // 增加节点使用频率
        } else {
            if (size == capacity) { // 如果当前容量不足，则开始删除最不经常使用的节点
                DoubleLinkedList minFreqLinkedList = freqMap.get(min); // 从频次表获取最不经常使用的双向链表
                cache.remove(minFreqLinkedList.tail.pre.key); // 从缓存map中移除最不经常使用的node，即为tail指针的前一位
                minFreqLinkedList.removeNode(minFreqLinkedList.tail.pre); // 这里不需要维护min, 因为下面add了newNode后min肯定是1；或者实现一个removeTail()方法，在LRU中有写
                size--; // 更新size
            }
            // 如果容量充足或者已经删除完最不经常使用的节点之后
            Node newNode = new Node(key, value); // 创建新节点
            cache.put(key, newNode); // 放入缓存map
            DoubleLinkedList linkedList = freqMap.get(1); // 获取频率使用为1的双向链表
            if (linkedList == null) { // 如果为空则new出来一个
                linkedList = new DoubleLinkedList();
                freqMap.put(1, linkedList); // 放入频次表
            }
            linkedList.addNode(newNode); // 将新节点加入双向链表
            size++; // 更新size
            min = 1; // 更新min
        }
    }

    public void freqInc(Node node) {
        // 从原freq对应的链表里移除, 并更新min
        int freq = node.freq; // 获取当前节点的freq
        DoubleLinkedList linkedList = freqMap.get(freq); // 拉取频次表中对应的双向链表
        linkedList.removeNode(node); // 从链表中删除当前节点，因为这个节点频次增加了所以不在这个链表中了
        if (freq == min && linkedList.head.post == linkedList.tail) { // 如果频次最小并且linkedList中仅有头尾节点
            min = freq + 1; // 更新最小频次
        }
        // 加入新freq对应的链表
        node.freq++;
        linkedList = freqMap.get(freq + 1);
        if (linkedList == null) {
            linkedList = new DoubleLinkedList();
            freqMap.put(freq + 1, linkedList);
        }
        linkedList.addNode(node);
    }
}