/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 *
 * https://leetcode.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (40.89%)
 * Total Accepted:    290.5K
 * Total Submissions: 708.1K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 *
 * Example:
 *
 *
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 *
 */
class Solution {
    // 其实思路和15题一样，依然是O(n^2 + nlogn)的算法复杂度, nlogn为排序复杂度
    // 第一轮循环遍历所有的可能，内层依然是双指针，num[i] + nums[left] + nums[right]与target比较
    // 如果三者之和大于target，那说明right过大，该right--，反之就是left过小，该left++
    // 这样才能使三者之和与target的距离减小(距离定义为三者之和与target在一维数轴上的绝对距离)
    // 但是，left右移和right左移的情况下，有可能出现距离不小反大的情况，这就是结束条件
    // 比如nums = {-6, -4, 6, 7, 8, 10} target = 1
    // 外层-6，内层left = -4， right = 10，此时距离为1 ，然后此时三者之和为0，小于1，left左移为6
    // 三者之和10，距离为9，瞬间拉大，此时就是结束这一轮的条件了

    // 头有点晕，昨晚睡太晚了，改天重刷这道题再写思路
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;

        int len = nums.length;
        int i, left, right, sum, result = 0;
        int currentDistance;
        int distance = Integer.MAX_VALUE;
        boolean equal = false;
        Arrays.sort(nums);

        for (i = 0; i < len; i++) {
            if (equal) break;
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) continue;

            left = i + 1;
            right = len - 1;

            while (left < right) {
                 sum = nums[i] + nums[left] + nums[right];
                 currentDistance = Math.max(target, sum) - Math.min(target, sum);

                 if (currentDistance < distance ) {
                     distance = currentDistance;
                     result = sum;
                 }

                 if (sum > target) {
                     right--;
                 } else if (sum < target) {
                     left++;
                 } else {
                     equal = true;
                     break;
                 }
            }
        }
        return result;
    }
}

