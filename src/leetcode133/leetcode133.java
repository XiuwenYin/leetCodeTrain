package leetcode133;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class leetcode133 {
    /*
    dfs + 哈希表查重
     */
    public Node cloneGraph(Node node) {
        // 查重用哈希表
        Map<Node, Node> hashMap = new HashMap<>();
        return dfs(node, hashMap);
    }

    private Node dfs(Node node, Map<Node, Node> hashMap) {
        // 如果当前节点为空，返回null
        if (node == null) return null;
        // 如果当前节点遍历过了，则用哈希表get当前节点返回
        if (hashMap.containsKey(node)) {
            return hashMap.get(node);
        }
        // 抛开以上两点base cases；创建 newNode，使用当前节点的val，创建空List
        Node newNode = new Node(node.val, new ArrayList<Node>());
        // 放入哈希表，key是当前节点，val是复制节点
        hashMap.put(node, newNode);
        // 对于当前节点的neigh进行forx遍历，对于每个遍历到的节点都进行dfs，并将结果赋值给新变量 newNodeNeigh，
        // 将newNodeNeigh添加给克隆节点newNode
        for(Node n : node.neighbors) {
            Node newNodeNeigh = dfs(n, hashMap);
            newNode.neighbors.add(newNodeNeigh);
        }
        // 返回克隆节点
        return newNode;
    }

    /*
    bfs + 哈希表
     */
    public Node cloneGraph01(Node node) {
        if (node == null) return null;
        Map<Node, Node> hashMap = new HashMap<Node, Node>();
        Queue<Node> queue = new LinkedList<>();

        Node newNode = new Node(node.val, new ArrayList<Node>());
        hashMap.put(node, newNode);
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            for (Node n : temp.neighbors) {
                if (hashMap.containsKey(n)) {
                    queue.offer(n);
                    hashMap.put(n, new Node(n.val, new ArrayList<>()));
                }
                // 从哈希表中用temp（如果是第一次循环那temp就是node）获取val，得到的是对应的克隆节点；点出克隆节点的邻居并添加对应的邻居节点
                // 邻居节点来自于每次对于temp的邻居节点进行遍历复制，并每次将 n - 克隆n 放入map中对应
                hashMap.get(temp).neighbors.add(hashMap.get(n));
            }

        }
        return newNode;
    }



}
