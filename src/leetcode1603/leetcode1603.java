package leetcode1603;

import java.util.HashMap;
import java.util.Map;

// 涉及停车系统
public class leetcode1603 {


}

class ParkingSystem {
    private int big;
    private int medium;
    private int small;
    Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
        hashMap.put(1, big);
        hashMap.put(2, medium);
        hashMap.put(3, small);

    }

    public boolean addCar(int carType) {
        if (carType == 1) {
            if (big > 0) {
                big--;
                return true;
            }

        } else if (carType == 2) {
            if (medium > 0) {
                medium--;
                return true;
            }
        } else if (carType == 3) {
            if (small > 0) {
                small--;
                return true;
            }
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
