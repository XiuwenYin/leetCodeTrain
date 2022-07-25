from typing import List


class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        d = []
        path = []
        for i in range(len(nums)):
            if not d or nums[i] > d[-1]:
                d.append(nums[i])
                tmp = d[:]
                # d数组增加时说明有更长序列出现，此时注意path数组要取自己上一层的序列而不是d数组，注意拷贝问题
                if path:
                    tmp = path[-1]
                    tmp = tmp[:]
                    tmp.append(nums[i])
                path.append(tmp)
                # print(path)
            else:
                # 二分法寻找数组中第一个大于等于target的位置
                left, right = 0, len(d) - 1
                # 最终位置loc
                loc = right
                while left <= right:
                    middle = (left + right) // 2
                    # 要找位置要么是此时mid，要么在mid左边故收缩左边
                    if d[middle] >= nums[i]:
                        loc = middle
                        right = middle - 1
                    else:
                        left = middle + 1
                d[loc] = nums[i]
                # 跟着改变path数组
                path[loc][-1] = nums[i]
        # print(d)
        # print(path)    # path就是各长度下的最优短路径
        return len(d)
