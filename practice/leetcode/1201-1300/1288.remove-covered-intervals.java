/**
 * https://leetcode-cn.com/problems/remove-covered-intervals/solution/
 * 扫描线算法，排序以后逐个遍历，在已知排序过后起点之间的顺序的情况下，只需要比较
 * 终点的大小，只要终点能逃过前面的终点的最大值的魔爪，就是一个存活区间
 */
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (arr1, arr2) -> {
            return arr1[0] == arr2[0] ? arr2[1] - arr1[1] : arr1[0] - arr2[0];
        });
        
        int ans = 0;
        int maxPrev = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] > maxPrev) {
                ans++;
                maxPrev = intervals[i][1];
            }
        }
        
        return ans;
    }
}
