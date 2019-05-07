/*
 * @lc app=leetcode id=338 lang=java
 *
 * [338] Counting Bits
 *
 * https://leetcode.com/problems/counting-bits/description/
 *
 * algorithms
 * Medium (64.50%)
 * Total Accepted:    163.9K
 * Total Submissions: 254K
 * Testcase Example:  '2'
 *
 * Given a non negative integer number num. For every numbers i in the range 0
 * ≤ i ≤ num calculate the number of 1's in their binary representation and
 * return them as an array.
 *
 * Example 1:
 *
 *
 * Input: 2
 * Output: [0,1,1]
 *
 * Example 2:
 *
 *
 * Input: 5
 * Output: [0,1,1,2,1,2]
 *
 *
 * Follow up:
 *
 *
 * It is very easy to come up with a solution with run time
 * O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a
 * single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like
 * __builtin_popcount in c++ or in any other language.
 *
 */
class Solution {
    public int[] countBits(int num) {
        if (num < 0) return new int[0];

        int[] ans = new int[num + 1];

        // 方法I: 逐个求解, 就是O(n*sizeof(Integer))的解法
        // for (int i = 0; i <= num; i++) {
        //     ans[i] = cal(i);
        // }

        // 方法II: 3比2多一个1, 5比4多一个1, 所以遇偶数算, 奇数用偶数的结果加1
        // 然而并没有什么优化, 其实时间复杂度和方法I差不多
        // for (int i = 0; i <= num; i++) {
        //     if (i % 2 == 0) {
        //         ans[i] = cal(i);
        //     } else {
        //         ans[i] = ans[i - 1] + 1;
        //     }
        // }

        // 方法III: do it like a boss!!!!
        // O(n)的解法, 首先 i = (i - 1) + 1
        // 将一个数加1, 等价于找到这个数二进制的第一个0的位置
        // 将这个0右边的所有位置为0, 然后将0置为1, 这个1将是这个数二进制中所有1中的最低位
        // i & (i - 1)的结果, 相当于把i的最低位的1右边的所有位置为0, 然后将那个1也置为0
        // 所以i和i & (i - 1)的差别就是最低位的那个1的差别
        // i & (i - 1)运算结果的二进制位刚好比i的二进制位少一个1
        // 所以要求i的二进制有多少个1, 只需要在i & (i - 1)的结果的二进制1的个数上加1就行了
        // 假设i & ( i - 1)有m个1, 那么i就有m + 1个1

        ans[0] = 0;

        for (int i = 1; i <= num; i++) {
            ans[i] = ans[i & (i - 1)] + 1;
        }

        return ans;
    }


    // 计算一个数的二进制表达里面有多少个1
    int cal(int i) {
        int count = 0;

        while (i != 0) {
            i &= (i - 1);
            count++;
        }

        return count;
    }
}

