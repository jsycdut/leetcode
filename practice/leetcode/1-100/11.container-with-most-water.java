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
class Solution {
    // 双指针，位于0, height.length - 1
    // 此时确保了距离最大，接下来要扩大面积
    // 只能是通过移动两个指针之一，来扩大y值，而面积是和较小的y有关的
    // 要移动两者y值较小的那个，因为这样才能增大面积扩大的趋势
    // 如果移动y值较大的那个，那么他带来收益的可能性是要小于移动y值较小的那个的带来的收益
    // 因为，在横轴距离都是减1的情况下，移动较小的y，更有可能把两个y值的较小值调大
    // 这种更有可能，是解决本题的关键
    // 切忌，不能通过移动谁之后面积大来判断，那样只是当前步最优，不是全局最优
    // 这种解法，只需要O(n)的复杂度，很棒!!!
    public int maxArea(int[] height) {
        if (height == null) return 0;
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while (i < j) {
            max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
