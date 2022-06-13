package leetcode151;

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
}
