package leetcode1570两个稀疏向量的点积;

import java.util.ArrayList;
import java.util.List;

public class leetcode1570 {
}

class SparseVector {

    List<int[]> list;

    SparseVector(int[] nums) {
        list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) list.add(new int[]{i,nums[i]});
//            list.add(new int[]{i, nums[i]});
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        if (vec.list.size() > list.size()) return vec.dotProduct(this);
        int dot = 0;
        for (int i = 0; i < vec.list.size(); i++) {
            int index = vec.list.get(i)[0];
            int value = vec.list.get(i)[1];
//            dot += value * list.get(index)[1];
            dot += value * binary(index, 0, list.size() - 1);
        }
        return dot;
    }

    public int binary(int index, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid)[0] == index) return list.get(mid)[1];
            if (list.get(mid)[0] < index) left = mid + 1;
            else right = mid - 1;
        }
        return 0;
    }

}
