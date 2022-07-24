package leetcode151颠倒字符串中的单词;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class leetcode151 {
    public String reverseWords(String s) {
        // 如果不用trim()
        // 转换字符串成为char[]
        char[] cArr = s.toCharArray();
        // 定义左指针和右指针
        int left = 0, right = cArr.length - 1;
        // 两个while循环找到左右不为空格的位置
        while (cArr[left] == ' ') {
            left++;
        }
        while (cArr[right] == ' ') {
            right--;
        }
        StringBuilder sb = new StringBuilder();
        // 遍历char[]
        while (left <= right) {
            // 定义变化指针
            int index = right;
            // index指针从右侧倒找第一个空格字符所在位置（确认第一个单词的长度：index到right）
            while (index >= left && cArr[index] != ' ') {
                index--;
            }
            // 将第单词添加进StringBuilder中
            for (int i = index + 1; i <= right; i++) {
                sb.append(cArr[i]);
            }
            // 此判断用于保证在字符串末尾也不会添加空格
            if (left < index) {
                sb.append(' ');
            }
            // 当添加完一个单词之后，将index指针指向下一个非空格字符的位置
            while (left <= index && cArr[index] == ' ') {
                index--;
            }
            // 右指针左移
            right = index;
        }
        return sb.toString();
    }

    /**
     * 双指针 + 双端队列
     */
    public String reverseWords01(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right && s.charAt(left) == ' ') left++;
        while (left < right && s.charAt(right) == ' ') right--;
        Deque<String> deque = new ArrayDeque<>();
        System.out.print(s.substring(left, right + 1));
        while (left <= right) {
            int start = left;
            while (left <= right && s.charAt(left) != ' ') left++;
            deque.offerFirst(s.substring(start, left));
            while (left <= right && s.charAt(left) == ' ') left++;
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(" " + deque.pollFirst());
        }
        return sb.toString().substring(1); // 转换成字符串并删除第一个" "
    }

    /**
     * 最快
     * 创建新字符数组填充。时间复杂度O(n)
     * 从右侧遍历，每次截断一个单词后，新数组从这里向右侧遍历单词的每个字符并添加入结果集，并且在每个单词的末尾添加空格
     */
    public String reverseWords02(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        char[] res = new char[n + 1];
        int i = n - 1, left = 0;
        while (i >= 0) { // 右侧开始向左遍历
            while (i >= 0 && arr[i] == ' ') i--; // 跳过空格
            int right = i;
            while (i >= 0 && arr[i] != ' ') i--;

            //指定区间单词取出(由于i为首字母的前一位，所以这里+1,)，取出的每组末尾都带有一个空格
            for (int j = i + 1; j <= right; j++) {
                res[left] = arr[j];
                left++;
                if (j == right) { // 到单词头部之后增加空格(这个判断写在循环内部的原因是防止最后一个单词多加上一个空格)
                    res[left++] = ' ';
                }
            }
        }
        if (res.length == 0) return "";
        return new String(res, 0, left - 1);
    }
}
