package leetcode464;

import java.util.HashMap;
import java.util.Map;

public class leetcode464 {
    /**
     * 博弈论
     * 记忆化搜索
     *
     * @param maxChoosableInteger
     * @param desiredTotal
     * @return
     */


    // 记忆化的hashMap,用来记录选择了哪些树的情况，当前玩家的胜负；用以减少时间复杂度
    Map<Integer, Boolean> memo = new HashMap<>();

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // 如果加起来都不能超过的话，都不可能赢，return false
        if ((1 + maxChoosableInteger) * maxChoosableInteger * 0.5 < desiredTotal) return false;
        // 递归判断，判断先手能不能赢，需要注意的是，先手从0开始
        return dfs(maxChoosableInteger, 0, desiredTotal, 0);
    }

    /**
     * @param maxChoosableInteger 供选择的数
     * @param userNum             被选择的数，注意用二进制表示，可能比较难以理解。如0010则表示2已经被选择，0001则表示1已被选择
     * @param desireTotal         累计整数合需要超过的目标值
     * @param curTotal            当前累计整数合
     * @return
     */
    // 解释一下这题移位法两个操作：（userNumbers >> i) & 1 ：判断i+1是否已经被访问； userNumbers | (1 << i)：把i+1标记为访问
    private boolean dfs(int maxChoosableInteger, int userNum, int desireTotal, int curTotal) {
        //如果未曾玩过这种场景，则做下列工作找出这种场景的答案
        if (!memo.containsKey(userNum)) {
            boolean res = false;
            //循环遍历选择每个数的情况，如果循环完所有的情况，都赢不了，那么就输了，因此初始res是输
            for (int i = 0; i < maxChoosableInteger; i++) {
                /*若这个数还没被选择，才往下做逻辑，否则进入下一轮循环(注意这里i是从0开始，所以判断的是第i+1个数的情况)
                 * userNum >> i是指对于当前遍历数字，向右移i位，并和1进行与判断*/
                if (((userNum >> i) & 1) == 0) {
                    //如果选完能直接胜利，那么结果自然为true
                    if (i + 1 + curTotal >= desireTotal) {
                        res = true;
                        break;
                    }
                    //否则的话，递归判断，我选完后，对方选完是不是就输了；对方输了，我自然就赢了
                    if (!dfs(maxChoosableInteger, userNum | (1 << i), desireTotal, curTotal + i + 1)) {
                        res = true;
                        break;
                    }
                }
            }
            memo.put(userNum, res);
        }
        return memo.get(userNum);
    }
}
