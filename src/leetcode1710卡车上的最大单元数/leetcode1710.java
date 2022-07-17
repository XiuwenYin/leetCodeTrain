package leetcode1710卡车上的最大单元数;

import java.util.Arrays;

public class leetcode1710 {
    /**
     * 贪心
     * boxTypes[x][0] 是对应箱子个数
     * boxTypes[x][1] 是对应箱子中器材的数量
     *
     * @param boxTypes
     * @param truckSize
     * @return
     */
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]); // 对boxTypes中的Unit个数进行降序排列
        int res = 0;
        for (int[] box : boxTypes) {
            int numBox = box[0];
            int numUnit = box[1];
            if (numBox < truckSize) {
                res += numBox * numUnit;
                truckSize -= numBox;
            } else {
                res += truckSize * numUnit;
                return res;
            }
        }
        return res;
    }
}
