/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 *
 * https://leetcode.com/problems/container-with-most-water/description/
 *
 * algorithms
 * Medium (42.54%)
 * Total Accepted:    321.2K
 * Total Submissions: 753.1K
 * Testcase Example:  '[1,8,6,2,5,4,8,3,7]'
 *
 * Given n non-negative integers a1, a2, ..., an , where each represents a
 * point at coordinate (i, ai). n vertical lines are drawn such that the two
 * endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together
 * with x-axis forms a container, such that the container contains the most
 * water.
 * 
 * Note: You may not slant the container and n is at least 2.
 * 
 * 
 * 
 * 
 * 
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In
 * this case, the max area of water (blue section) the container can contain is
 * 49. 
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * 
 */

/*
 * 暴力解法，无奈为之
 * brute force
 * 
 */
class Solution {
    public int maxArea(int[] height) {
        // 边界
        if (height == null) return 0;

        int ans = 0;
        int len = height.length;
        for(int p = 1; p < len; p++) {
            for(int q = 0; q < p; q++) {
                ans = Math.max(ans, (p - q) * Math.min(height[p], height[q]));
            }
        }
        return ans;
    }
}
