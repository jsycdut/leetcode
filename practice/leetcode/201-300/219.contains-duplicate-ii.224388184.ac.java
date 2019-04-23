/*
 * @lc app=leetcode id=219 lang=java
 *
 * [219] Contains Duplicate II
 *
 * https://leetcode.com/problems/contains-duplicate-ii/description/
 *
 * algorithms
 * Easy (35.06%)
 * Total Accepted:    192K
 * Total Submissions: 547.6K
 * Testcase Example:  '[1,2,3,1]\n3'
 *
 * Given an array of integers and an integer k, find out whether there are two
 * distinct indices i and j in the array such that nums[i] = nums[j] and the
 * absolute difference between i and j is at most k.
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 *
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 *
 *
 *
 * Example 3:
 *
 *
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 *
 *
 *
 *
 *
 */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 解法1，其实是个窗口，就是让你找长度为k + 1的窗口内有没有重复的元素
        // 时间复杂度大概是O(N) 空间复杂度就是O(K)

        if (nums == null || nums.length <= 1) return false;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            // 先检查set里面有没有当前要加入的元素，有的话，说明重复了
            // 没有的话，就将其加入set，如果加入之后发现元素有k+1个的话
            // 说明当前窗口满了，就需要移除窗口开始处的元素
            // 
            // 这个代码的巧妙就在于，将0->k和k+1->length这两个过程结合起来了
            // 而且代码十分的精简
            // 先形成了k+1个节点的窗口，然后在确保这个窗口没有重复的元素的情况下
            // 将窗口左侧的元素移除，然后下一次循环直接在窗口右侧添加元素就行了
            // 妙啊，比我的分段要来的好多了
            // 不过，这代码和leetcode里面的0ms的代码是一样的啊，为什么我是9ms（哭唧唧
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) set.remove(nums[i - k]);
        }

        return false;
    }
}

