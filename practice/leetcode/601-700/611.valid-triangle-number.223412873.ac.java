/*
 * @lc app=leetcode id=611 lang=java
 *
 * [611] Valid Triangle Number
 *
 * https://leetcode.com/problems/valid-triangle-number/description/
 *
 * algorithms
 * Medium (44.70%)
 * Total Accepted:    34.6K
 * Total Submissions: 77.3K
 * Testcase Example:  '[2,2,3,4]'
 *
 * Given an numsay consists of non-negative integers,  your task is to count the
 * number of triplets chosen from the numsay that can make triangles if we take
 * them as side lengths of a triangle.
 *
 * Example 1:
 *
 * Input: [2,2,3,4]
 * Output: 3
 * Explanation:
 * Valid combinations are:
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 *
 *
 *
 * Note:
 *
 * The length of the given numsay won't exceed 1000.
 * The integers in the given numsay are in the range of [0, 1000].
 *
 *
 *
 */
class Solution {
    // 排序后，任取两个数作为两边，找到小于两边之和的最大的数字
    // 该数字距离两边较大的值之间的距离就是在选定这两条边的情况下能组成的三角形的个数
    // 遍历所有的两个数作为两边的情况即可
    // 其实这个思路就是O(N^3)的穷举最里面的循环改为二分搜索而已
    // O(N^2LogN + NLogN)，仅仅比穷举的O(N^3)好一点
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int len = nums.length;
        int ans = 0;
        Arrays.sort(nums);

        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len; j++) {
                int k = binarySearch(nums, j, nums[i] + nums[j]);
                ans += (k - j);
            }
        }

        return ans;
    }

    // 注意这里的二分写法，是寻求从下界lb开始，不大于target的最大数的索引
    // 用普通的mid加减1确定解的方法很难做，这种上下界的办法是很好的
    int binarySearch(int[] nums, int lb, int target) {
        int ub = nums.length;

        while (ub - lb > 1)  {
            int mid = (lb + ub) >>> 1;

            if (nums[mid] < target) {
                lb = mid;
            } else {
                ub = mid;
            }
        }

        return lb;
    }
}


