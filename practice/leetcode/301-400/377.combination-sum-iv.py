class Solution:
    def combinationSum4(self, nums: List[int], target: int) -> int:
        res = [1] + [0] * target
        for x in range(1, target+1):
            res[x] = sum(res[x - t] for t in nums if t <= x)
        return res[target]
