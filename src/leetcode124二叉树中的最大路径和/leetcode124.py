# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def maxPathSum(self, root: TreeNode) -> int:
        self.ans = -1000  # 或者 float("-inf") 不要用0x80000000
        self.path = []  # 存储路径
        self.dfs(root)
        print(self.path)
        return self.ans

    def dfs(self, root):  # 返回从该根节点到叶节点最大路径和
        if root is None: return 0, []
        left, leftPath = self.dfs(root.left)
        right, rightPath = self.dfs(root.right)

        if root.val + left + right > self.ans:
            self.ans = root.val + left + right
            self.path = leftPath + [root.val] + rightPath

        if left > 0 and left > right:
            res = left + root.val
            path = leftPath + [root.val]
        elif right > 0 and right > left:
            res = right + root.val
            path = [root.val] + rightPath
        else:
            res = root.val
            path = [root.val]

        if self.ans < res:
            self.ans = res
            self.path = path

        return res, path  # res 是路径和，path 是路径数组
