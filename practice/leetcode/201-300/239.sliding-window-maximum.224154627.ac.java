/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 *
 * https://leetcode.com/problems/sliding-window-maximum/description/
 *
 * algorithms
 * Hard (37.61%)
 * Total Accepted:    150.4K
 * Total Submissions: 398.5K
 * Testcase Example:  '[1,3,-1,-3,5,3,6,7]\n3'
 *
 * Given an array nums, there is a sliding window of size k which is moving
 * from the very left of the array to the very right. You can only see the k
 * numbers in the window. Each time the sliding window moves right by one
 * position. Return the max sliding window.
 *
 * Example:
 *
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 *
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * ⁠1 [3  -1  -3] 5  3  6  7       3
 * ⁠1  3 [-1  -3  5] 3  6  7       5
 * ⁠1  3  -1 [-3  5  3] 6  7       5
 * ⁠1  3  -1  -3 [5  3  6] 7       6
 * ⁠1  3  -1  -3  5 [3  6  7]      7
 *
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty
 * array.
 *
 * Follow up:
 * Could you solve it in linear time?
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return new int[0];

        int[] ans = new int[nums.length - k + 1];

        // 解法1，暴力解法O(M * K)，M为nums长度，K为窗口大小k
        // for (int i = 0; i < nums.length - k + 1; i++) {
        //     int max = Integer.MIN_VALUE;
        //     for (int j = 0; j < k; j++) {
        //         max = Math.max(max, nums[i + j]);
        //     }
        //     ans[i] = max;
        // }
        //
        // return ans;

        // 解法2，双端队列
        // 思路：由于只需要找到窗口里面的最大值
        // 所以只需要维护一个双端队列，其特点是：队首始终保留着窗口里面的最大值，然后依次递减，
        // 遍历nums数组，每次新出现一个值的时候，如果比队列尾端的小，则不管这个值
        // 反之，从队列尾部开始，把所有比新值小的一一移除，然后将将这个新值扔进去（因为我们只关心窗口里面较大的值）
        // 如果队列头部值的索引恰好是要移除的值的索引，就将其去掉(因为这个值不在窗口里面了)
        // 此时，队列头部的值就是窗口里面的最大值了
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) deque.removeLast();

            deque.addLast(i);

            if (deque.getFirst() == i - k) deque.removeFirst();

            if (deque.getLast() >= k - 1) ans[i + 1 - k] = nums[deque.getFirst()];
        }

        return ans;
    }
}

