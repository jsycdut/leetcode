/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 *
 * https://leetcode.com/problems/4sum/description/
 *
 * algorithms
 * Medium (29.80%)
 * Total Accepted:    215.6K
 * Total Submissions: 722.7K
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * Given an array nums of n integers and an integer target, are there elements
 * a, b, c, and d in nums such that a + b + c + d = target? Find all unique
 * quadruplets in the array which gives the sum of target.
 *
 * Note:
 *
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 *
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 * ⁠ [-1,  0, 0, 1],
 * ⁠ [-2, -1, 1, 2],
 * ⁠ [-2,  0, 0, 2]
 * ]
 *
 *
 */
class Solution {
    // 思路，其实4sum可以看做2sum + 2sum问题
    // 还是先排序，得到形如 -5 -4 -2 0 1 2 8 19的排序结果
    // 首先用一重循环找到第一个2sum，还是双指针，一个在前一个在后，比如-5 和 19
    // 这样遍历找到所有的2sum组合，此时，双指针之间的区域，就是第二个2sum问题，比如与-5和19之间的-4 ~ 8
    // 复杂度大概是O(N^3 + NlogN)，比dfs的O(N^4)稍好一些，另外还因为排了序，可以避免重复问题
    // 另外需要注意的就是一定要留足四元组的空间，保证4sum可能的解区域至少有4个元素
    // 此外就是常规的避免重复的手段了

    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 判定边界
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) return list;

        Arrays.sort(nums);
        int sumOuter, sumInner, left, right;
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) continue;
            if (target > 0 && nums[i] > target) break;
            for (int j = len - 1; j > i + 2; j--) {
                if (j + 1 < len && nums[j + 1] == nums[j]) continue;
                sumOuter = nums[i] + nums[j];
                sumInner = target - sumOuter;
                left = i + 1;
                right = j - 1;
                while (left < right) {
                    if (nums[left] + nums[right] > sumInner) {
                        right--;
                        continue;
                    }

                    if (nums[left] + nums[right] < sumInner) {
                        left++;
                        continue;
                    }

                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    list.add(temp);
                    while (++left < right && nums[left] == nums[left - 1]);
                    while (left < --right && nums[right] == nums[right + 1]);
                }
            }
        }
        return list;
    }
}

