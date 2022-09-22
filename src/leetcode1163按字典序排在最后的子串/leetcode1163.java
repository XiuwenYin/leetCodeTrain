package leetcode1163按字典序排在最后的子串;

public class leetcode1163 {
    /**
     * 滑动窗口
     * 最快
     * @param s
     * @return
     */
    public String lastSubstring(String s) {
        int n = s.length();
        if (n == 1) return s;

        char[] arr = s.toCharArray();
        int start = 0, end = 1;
        while (end < n) { // 滑动窗口右端比n小时
            if (arr[start] < arr[end]) { // 1. 遇到比起始字符大的字符时，窗口整体跳到较大字符处
                start = end;
                end++;
            } else if (arr[start] > arr[end]) { // 2. 后续字符小于起始字符时，窗口末端右移
                end++;
            } else { // 3.遇到相等的字符时，分别从两个下标开始对比两个子串
                int temp = 1; // 创建临时增量
                while (end + temp < n) { // 子串滑动窗口右端比n小时
                    if (arr[start] < arr[end + temp]) { // 子串出现较大字符
                        start = end + temp; // 窗口整体移动到 end + temp位置
                        end = end + temp;
                        break;
                    }
                    if (arr[start + temp] < arr[end + temp]) { // 3.1 第二子串较大,窗口起始点跳到第二子串起始处（即第一子串结束处）
                        start = end;
                        break;
                    }
                    if (arr[start + temp] > arr[end + temp]) { // 3.2 第一子串较大，第一子串窗口末端扩到第二子串末端
                        end = end + temp;
                        break;
                    }
                    if (arr[start + temp] == arr[end + temp]) { // 3.3 俩当前子串相等，继续对比俩子串
                        temp++;
                    }
                    if (end + temp >= n) { // 3.4 第二子串窗口末端到顶部，说明未找到比第一子串大的字符，同3.2，结束对比
                        end = end + temp;
                        break;
                    }
                }
                end++;
            }
        }
        return s.substring(start);
    }
}
