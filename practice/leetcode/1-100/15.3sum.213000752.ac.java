/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 *
 * https://leetcode.com/problems/3sum/description/
 *
 * algorithms
 * Medium (23.45%)
 * Total Accepted:    488.8K
 * Total Submissions: 2.1M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the
 * sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 *
 *
 */
class Solution {
    // 思路是，排序，遍历数组，抽出三者中的第一个元素nums[i]
    // 然后在后面的元素里面找和为-nums[i]的两个数，也就是成为了leetcode第一题的2sum，
    // 只不过这次不是hashmap，而是双指针，一开始我就是想用hashmap，想在n平方解决问题
    // 但是却没法去重，排序就是为了使用双指针，找出所有和为-nums[i]的组合，
    // 并且排序之后很容易去重，因为重复的元素挨在一起，很容易就跳过去了
    // 而且排序了之后，一旦第一重循环nums[i] > 0，后面的必定都大于0，所以可以提早结束循环
    // 这个思路是把数组分成了三部分，[0, i - 1] 是已经处理过的，i是正在处理的，[i + 1, len - 1]是要搜寻的解空间
    public List<List<Integer>> threeSum(int[] nums) {

        // 边界检查
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) return res;

        // 排序，为后面的双指针营造条件
        Arrays.sort(nums);
        List<Integer> tmp;
        int len = nums.length;
        int i, left, right;

        for (i = 0; i < len; i++) {
            // 处理第一轮循环的重复数字
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) continue;

            // 由于排序，可以在遇到nums[i] > 0时，就结束循环
            if (nums[i] > 0) break;

            // 规定左右指针
            left = i + 1;
            right = len - 1;

            while (left < right) {
                // 在整体递增的情况下，三者之和大于0，只能说明是right太大
                if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                    continue;
                }

                // left太小
                if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                    continue;
                }

                // 刚好等于0
                // 千万不要做tmp.clear()，然后再添加元素，因为java的引用，所以res最后只会重复最后一个正确结果
                // Java内存模型，引用必须要吃透啊，否则因为想省空间，导致毁灭性的灾难
                tmp = new ArrayList<Integer>();
                tmp.add(nums[i]);
                tmp.add(nums[left]);
                tmp.add(nums[right]);
                res.add(tmp);

                // 排序之后，处理 -1 -1 -1 0 1 1 1 2这样的重复，这写法，很精简
                while (++left < right && nums[left] == nums[left - 1]);
                while (left < --right && nums[right] == nums[right + 1]);

                // 错误代码如下
                // while (++left < right && nums[left] == nums[left - 1]) ++left;
                // while (left < --right && nums[right] == nums[right + 1]) --right;
                // 这样是跳了两格，比如-2 -1 -1 0 1 3，在处理-2 -1 3的解的时候（此时left指向第一个-1）
                // 首先判断语句里面left++，此时left指向第二个-1
                // 发现相同，然后循环体++，此时left指向0，然后再执行判断语句里面的left++了，发现不等，但是此时left已经指向1了
                // 这样left就跳过了0
                // 所以这种写法会导致解的缺失
                // 写太精简的代码，可能会导致脑子转不过来啊！！！ 我需要一只小黄鸭（逃
            }
        }

        return res;
    }
}

