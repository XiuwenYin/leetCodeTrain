package leetcode589;

// N叉树的前序遍历

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class leetcode589 {
    public List<Integer> preorder(Node root) {
        // 建立 LinkList 用于存放结果
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        // 创建 stack
        Deque<Node> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            // 每次循环都从栈中拉出最后一个（即先进入栈的那个元素）
            Node node = stack.pollLast();
            res.add(node.val);
            // 翻转子节点，保证x1, x2, x3，进入栈后为: x3, x2, x1，保证stack.pollLast()先取出x1
            Collections.reverse(node.children);
            // 将翻转后的子节点添加入栈中
            stack.addAll(node.children);
        }
        return res;
    }
}
