package leetcode1190;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class leetcode1190 {
    public String reverseParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.push(i); // 压下标
            }
            if (arr[i] == ')') {
                reverse(arr, stack.pop() + 1, i - 1); // 弹出下标用于辅助函数
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '(' && arr[i] != ')') {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            right--;
            left++;
        }
    }
}
