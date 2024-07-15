class Solution:
    def maxIncreaseKeepingSkyline(self, grid: List[List[int]]) -> int:
        rows = list(map(max, grid))
        cols = list(map(max, zip(*grid)))
        return sum(min(rows[i], cols[j]) - h for i, row in enumerate(grid) for j, h in enumerate(row))
