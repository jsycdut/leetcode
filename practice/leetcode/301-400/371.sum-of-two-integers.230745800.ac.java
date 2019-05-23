/*
 * @lc app=leetcode id=371 lang=java
 *
 * [371] Sum of Two Integers
 *
 * https://leetcode.com/problems/sum-of-two-integers/description/
 *
 * algorithms
 * Easy (50.95%)
 * Total Accepted:    133.4K
 * Total Submissions: 261.9K
 * Testcase Example:  '1\n2'
 *
 * Calculate the sum of two integers a and b, but you are not allowed to use
 * the operator + and -.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: a = 1, b = 2
 * Output: 3
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: a = -2, b = 3
 * Output: 1
 * 
 * 
 * 
 * 
 */
class Solution {
    public int getSum(int a, int b) {
      // 利用位运算实现加法
      // 其实就是利用异或保存不带进位的结果x
      // 然后用与运算求得进位结果然后左移一位得到y
      // 然后将y加到x上，其实就是继续前面的步骤
      // 下面的a保存了a和b不带进位加法的结果
      // b保存的就是进位
      // 比如2 + 3
      //      1 0    2
      //  +   1 1    3
      // ---------  
      //      0 1   异或
      //  + 1 0 0   进位
      // ---------  
      //    1 0 1   异或
      //  + 0 0 0   进位
      // ---------  
      //    1 0 1   和为5
      //
      // ==============================================================================================================
      //
      // 解法I：迭代做法，比较好理解
      // while (b != 0) {
      //   a = a ^ b; // 做异或运算，得到不带进位的结果
      //   b = ((a ^ b) & b) << 1; // a先和b做异或，之后仍和b做异或，得到自身a，再和b做与运算并左移一位，就得到了进位
      // }
      //
      // return a;
      //
      //
      // ==============================================================================================================
      //
      // 解法II：递归做法，很简练

      return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
}


