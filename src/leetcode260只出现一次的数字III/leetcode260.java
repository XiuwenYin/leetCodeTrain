package leetcode260只出现一次的数字III;

public class leetcode260 {
    /**
     * 位运算（记不住，老实哈希表计数吧）
     *
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        int xor = 0; // 定义异或
        for (int num : nums) {
            xor ^= num;
        }

        // 为什么要取最低有效位？
        // 因为它是我们对两个数字划分的一种方式，当两个数字的异或某位值为1时，必然存在两个数字在此位上的值不相同
        // 我们取最低有效位，其实是一种划分，其实取任意一位都可以
        // 因为位运算中，取最低位的1比较方便，所以可选的情况下通常选取最低位

        // 举例：5（100）B 2(10)B 3（11）B 3（11）B
        // 答案[5,2],异或是：(110)B

        // 最低有效位对应的值是 2（10）B
        // 对于5 此位是0，对于2 此位是1，就可以把两个数分开

        // 然后我们就想，这个方式有没有不成立的情况呢？
        // 1. 当这两个数相等的时候，不成立，找不到最低有效位。但是他们相等是违背“出现一次”的题目要求的

        // 2. 当剩余数字出现两次在两个分类中各一种的情况下不成立。
        // 但这个是不可能的，对于同一个数字，它的某个数位是不会变化的，所以最终只能归为一类

        // 因为该数字总体上会出现偶数次，所以它的每个数位的1也会出现两次，又只能归为一类
        // 最终必然抵消，不会对结果产生影响

        // 上述例子中， 3 因为和  2（10）B 与 2（10）B 非0，和2划分为一类
        //3(11)B 与 2（10）B 是0，划分为另一类
        // type1=[2,3,3] type2=[5]
        // 第一部分异或得到2，第二部分异或得到5，从而返回结果

        // 综上，可以通过获取最低有效位把两个数分开

        // 防止溢出
        // 因为二进制有正负0，负零用于多表示一位负数，这个负数如果取相反数，会产生溢出，所以不能用 a & (-a) 取最低有效位
        // 负0的特点是第一位是1，其余位是0，所以它的最低有效位就是自己
        int lsb = (xor == Integer.MIN_VALUE ? xor : xor & (-xor));
        int type1 = 0, type2 = 0;
        for (int num : nums) {
            if ((num & lsb) != 0) {
                type1 ^= num;
            } else {
                type2 ^= num;
            }
        }
        return new int[]{type1, type2};
    }


    /**
     * ！！最速解法！！
     * @param nums
     * @return
     */
    public int[] singleNumber02(int[] nums) {
        int ret = 0;
        for (int i : nums) {
            ret ^= i;
        }
        // 取到ret最右边的一个1的位置
        int rightOne = ret & (~ret + 1);

        int temp = 0;
        for (int i : nums) {
            if ((rightOne & i) != 0) {
                temp ^= i;
            }
        }

        int[] result = new int[2];
        result[0] = temp;
        result[1] = ret ^ temp;
        return result;

    }

}
