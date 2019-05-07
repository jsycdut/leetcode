/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 *
 * https://leetcode.com/problems/merge-sorted-array/description/
 *
 * algorithms
 * Easy (35.49%)
 * Total Accepted:    355.5K
 * Total Submissions: 1M
 * Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 *
 * Note:
 *
 *
 * The number of elements initialized in nums1 and nums2 are m and n
 * respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to
 * m + n) to hold additional elements from nums2.
 *
 *
 * Example:
 *
 *
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 *
 *
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 说是easy题，但我竟然比做medium的题多WA了好几次
        // 这种题就是要考虑特殊情况，否则很容易掉坑里

        // 解法I：思路很好，但是代码实现还不够优秀
        // 建议直接看解法I的优化版，这里考虑的不周到
        // 这里的&&用得不好，只要nums1一方的数据先用完了
        // 就需要手动给nums1补充数据， 不好

        // int i = m - 1;
        // int j = n - 1;
        // int count = 1;

        // while (i >= 0 && j >= 0) {
        //     if (nums1[i] >= nums2[j]) {
        //         nums1[m + n - count] = nums1[i];
        //         i--;
        //     } else {
        //         nums1[m + n - count] = nums2[j];
        //         j--;
        //     }

        //     count++;
        // }

        // 当nums1数组比nums2数组提前用光的时候
        // 说明要么nums1的m为0
        // 要么nums1在靠近头部的值比nums2靠近头部的值要大些，比如[4, 5, 6, 0, 0, 0] [1, 2, 3]
        // 此时4 5 6去填充后面的三个0，i为-1，说明nums1靠近头部的值要比nums2靠近头部的值要大些
        // 如果j提前为-1，说明j头部的值要大些，而且j已经用完了，说明nums2 里面的值都复制到了nums1
        // 同时由于nums1本身有序，所以nums1不需要再做操作了
        // 把剩余的nums2数组复制过来

        // if (i == -1 && j != -1) {
        //     for (int k = 0; k <= j; k++) {
        //         nums1[k] = nums2[k];
        //     }
        // }

        // 解法I：优化版
        // 使用||，当两方全部用完，才会停止，
        // 当某个值已经用过后，或者当一方提前用光后
        // 使用Integer.MIN_VALUE来作为补充的值

        int i = m - 1;
        int j = n - 1;
        int target = m + n - 1;

        while (i >= 0 || j >= 0) {
            int v1 = (i >= 0) ? nums1[i] : Integer.MIN_VALUE;
            int v2 = (j >= 0) ? nums2[j] : Integer.MIN_VALUE;

            if (v1 >= v2) {
                i--;
                nums1[target--] = v1;
            } else {
                j--;
                nums1[target--] = v2;
            }
        }



        // 解法II： API作弊
        // 只需要把nums2从尾到头复制到nums1尾部
        // 然后调用Arrays.sort(int[] a, int fromIndex, int toIndex)
        // 把nums1的[0, m + n - 1]排个序就完了

        // 下面的这个写法，省略了很多步骤
        // 注意排序函数的的toIndex是不被包含在排序中的
        // 就和String.substring一样
        // for (; m < m + n; m++) {
        //     nums1[m] = nums2[-1 + n--];
        // }

        // Arrays.sort(nums1, 0, m);
    }
}


