package leetcode744;

public class leetcode744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        if (letters[right] <= target) {
            return letters[0];
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left++;
            }
            if (letters[mid] > target) {
                right--;
            }
        }
        return letters[left];
    }
}
