/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 *
 * https://leetcode.com/problems/next-permutation/description/
 *
 * algorithms
 * Medium (30.23%)
 * Total Accepted:    224.8K
 * Total Submissions: 743.4K
 * Testcase Example:  '[1,2,3]'
 *
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 */
class Solution {
    public void nextPermutation(int[] nums) {
        // 解法1：常规思路
        // 题意是让寻找到一个比当前数组中数字更大的下一个全排列
        // 比如 1 2 3的所有全排列是
        // 1 2 3
        // 1 3 2
        // 2 1 3
        // 2 3 1
        // 3 1 2
        // 3 2 1
        // 比2 3 1更大的全排列就是3 1 2
        // 肯定是不能把全部的全排列整出来然后再找下一个全排列的
        // 这个时候就是考眼力见的时候了，要想找到下一个更大的全排列
        // 就该从数组末尾开始，向数组头部逐步靠近，下一个更大的全排列，
        // 应该和上一个全排列最大程度的相似，意思就是排列的前面n个字符应该尽最大可能的相同
        // 其实，可以将数组从后往前的数字画成一个折线图，如果折线图一直是下降的
        // 那么把最后两个数交换位置就可以了，如果从后往前是上升的，
        // 如果到头都是上升，说明排列是3 2 1这样的最大排列，直接把数组排序就完事了
        // 但是如果从后往前是先升后降，那么下降点就很重要的，该点前面就是最大可能相同的所有字符
        // 这个时候在下降点右边所有数中，找到大于下降点的所有数中的最小值，然后交换该值和下降点
        // 然后把下降点右边的数字从小到大排序就可以了。
        //
        //
        // 数组里面的数字可能形成的折线图如下（注意仅考虑从后往前的顺序
        //
        //                       ===index==
        //    0 ------------------------------------- length - 1
        //
        //    1. 从后往前只升不降，数组从小到大排序就完事
        //
        //                       \
        //                        \
        //                         \
        //                          \
        //    ---------------------------------------------------------
        //    2. 从后往前先升后降，*就是下降点，~就是比下降点大的所有值中的最小值
        //       两者应该交换，然后排序下降点后面的所有数字
        //       才能拿到比当前大的全排列中的最小值
        //
        //                     /\
        //                    *  \
        //                        ~
        //                         \
        //    ---------------------------------------------------------
        //    3. 从后往前只有下降，这是最简答的情况，直接把最后两个数换位子就行了
        //
        //                           /
        //                          /
        //                         /
        //

        if (nums == null || nums.length <= 1) return;

        int index = nums.length - 1;

        // 上面的情况3
        if (nums[index] > nums[index - 1]) {
            swap(nums, index, index - 1);
            return;
        }

        // 找情况1 2 中的下降点
        while (index - 1 >= 0 && nums[index] <= nums[index - 1]) {
            index--;
        }

        if (index == 0) { // 情况1
            sort(nums, 0, nums.length - 1);
        } else { // 情况2
            int i;
            for (i = index; i < nums.length; i++) {
                if (nums[i] <= nums[index - 1]) break;
            }

            swap(nums, index - 1, i - 1);
            sort(nums, index, nums.length - 1);
        }

    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 冒泡局部排序
    void sort(int[] arr, int start, int end) {
        if (start >= arr.length) return;

        for (int i = start + 1; i <= end; i++) {
            for (int j = start; j <= end - (i - start); j++) {
                if (arr[j] > arr[j + 1]) swap(arr, j, j + 1);
            }
        }
    }
}

