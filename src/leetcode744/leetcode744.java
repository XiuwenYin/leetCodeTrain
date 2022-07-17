package leetcode744;

public class leetcode744 {
    /**
     * 二分，但没那么二分
     */
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        if (letters[right] <= target) { // 由于letters已经排好序，所以直接判断末尾位置是否小于等于target，如果是则直接返回头结点（题目要求）
            return letters[0];
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 这里和一般二分不一样，由于要找到比target大的下一个字符，所以这里和普通二分的判断是反过来的（并且是<=），目的是让mid慢慢接近target
            if (letters[mid] <= target) {
                left++; // 这里也是，和普通二分不一样，是用的left++的形式，目的也是慢慢靠近target，因为target可能不在数组中
            }
            if (letters[mid] > target) { // 这里的判断可以用else替换
                right--;
            }
        }
        return letters[left];
    }
}
