package leetcode45跳跃游戏II;

public class leetcode45 {
    public int jump(int[] nums) {
        /*

        题目说明：假设你总是可以到达数组的最后一个位置。
        即一定存在一条路线能够到达最后一个位置，而不是说中间没有 0 ，只是存在可以越过 0 的路线

        贪心算法：找能跳的最远的
        使用 maxPosition 记录目前能够跳到的最高位置
        使用 end 记录这次跳跃的边界，到达边界就跳跃次数 + 1

        过程解析：
        最开始遍历 i = 0, end = 0,因此 step 会进行 step ++，我们可以认为，这是开始起跳，因为必定会落下，因此跳跃次数 + 1
        而 nums[0] 这个数限制了你只能在落脚在某个范围内，假如 nums[0] = 4，那么你只能选择落脚在 [1, 4] 位置，而如果到了边界，那么肯定是一次新的起跳，因此次数需要再 + 1

        从 0 位置开始起跳，你落脚的必定是 [1, 4] 位置中能够跳得更远的，因为根据贪心思想，这样做能够尽可能的减少跳跃次数，因为更加接近最后一个位置
        而在这个过程遍历 [1, 4] 过程中一直记录着最远位置 maxPosition，而你落地在 [1, 4] 之间，落地的那个点也就是 [1, 4] 之间最能够跳得远的那个位置，因此当到达边界的时候，将 end 更新为 maxPosition

        注意：[1, 4] 跳得最远的位置必定不会在 [1, 4] ，因为如果在 [1, 4] ，那么表示根本就出不去 [1, 4] 这个圈
        当然不会是 [4,1,1,1,0,1,2] 这种的，因为如果是这种的，压根过不去这个 0，因此必定第一次起跳必定能够跳出 [1, 4] 这个范围，比如 [4,1,1,1,1,1,0]
        */
        int maxPosition = 0;
        //记录跳跃的次数
        int step = 0;
        int end = 0;
        //这里有个小细节，因为是起跳的时候就 + 1 了，如果最后一次跳跃刚好到达了最后一个位置，那么遍历到最后一个位置的时候就会再次起跳，这是不允许的，因此不能遍历最后一个位置
        for(int i = 0; i < nums.length - 1; i++){
            //一定跳得到，因此不存在 maxPosition < i

            maxPosition = Math.max(maxPosition, i + nums[i]);
            //第一次起跳 或 到达跳跃的边界
            if(i == end){
                //再次起跳
                step++;
                //更新边界
                end = maxPosition;
            }
        }

        return step;
    }
}
