class Solution {
    public int findChampion(int[][] grid) {
        // 打擂台，假设ans = 0，那么其余grid[i][ans]都应该是0
        // 如果某个不为0说明它被打败了，更新答案继续冲
        int ans = 0;
        for (int i = 1; i < grid.length; i++) {
            if (grid[i][ans] == 1) {
                ans = i;
            }
        }

        return ans;
    }
}
