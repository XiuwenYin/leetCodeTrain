package leetcode496下一个更大元素;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// 下一个更大元素
/**
 * 单调栈
 */
public class leetcode496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 创建 hashTable用于存储单调栈结果，key是num2数组元素，value是下一个更大元素
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        // 创建栈，用于单调栈
        Deque<Integer> stack = new LinkedList<Integer>();
        int n1 = nums1.length, n2 = nums2.length;
        // 单调栈模板；反向遍历 nums2
        for (int i = n2 - 1; i >= 0; i--) {
            /*
            若栈非空，且当前 num2的值大于栈最后的值(栈最上面的值)，弹出栈最上面的值
            循环弹出，直到保证此时栈中最上面的值是比当前值要大的；即找到了下一个更大的元素
             */
            while (!stack.isEmpty() && nums2[i] >= stack.peek()) stack.pop();
            // hashMap存储结果，对于最后一位元素，是第一个进栈的，所以必定value是-1
            hashMap.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            // 推进当前的值
            stack.push(nums2[i]);
        }
        int[] res = new int[n1];
        for (int i = 0; i < n1; i++) {
            res[i] = hashMap.get(nums1[i]); // 因为nums1其实是nums2的子集，并且要找到对应的nums2中的位置的nextGreaterElement，所以get(nums1[i])
        }
        return res;
    }

    public int[] nextGreaterElement01(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                stack.pop();
            }
            hashMap.put(nums2[i], stack.isEmpty() ? -1 : stack.peek() );
            stack.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = hashMap.get(nums1[i]);
        }
        return res;
    }
}
