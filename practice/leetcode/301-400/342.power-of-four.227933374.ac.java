/*
 * @lc app=leetcode id=342 lang=java
 *
 * [342] Power of Four
 *
 * https://leetcode.com/problems/power-of-four/description/
 *
 * algorithms
 * Easy (40.19%)
 * Total Accepted:    111.7K
 * Total Submissions: 277.8K
 * Testcase Example:  '16'
 *
 * Given an integer (signed 32 bits), write a function to check whether it is a
 * power of 4.
 *
 * Example 1:
 *
 *
 * Input: 16
 * Output: true
 *
 *
 *
 * Example 2:
 *
 *
 * Input: 5
 * Output: false
 *
 *
 * Follow up: Could you solve it without loops/recursion?
 */
class Solution {
    public boolean isPowerOfFour(int num) {
        // 解法I：老实人做法（迭代）
        // a如果是b的幂，那么当a对b取余的时候，结果为0，同时a更新为a/b
        // 如果不为0了，此时a应该为1，否则就不是幂
        //
        // if (num <= 0) return false;
        //
        // while (num % 4 == 0) {
        //     num /= 4;
        // }
        //
        // return num == 1;

        // 解法II：少写一两行代码的递归解法
        // if (num <= 0) return false;
        // if (num == 1) return true;
        // if (num % 4 != 0) return false;
        //
        // return isPowerOfFour(num / 4);

        // 解法III：秀儿啊，真秀啊，幂转对数，有一手
        // 这里利用了换底公式，num如果是4的幂，那么算出来肯定是一个double的整数，转为int后不会缺失精度
        // 如果不是4的幂，那么转为int后就会缺失精度
        // return num > 0 && (int)(Math.log10(num) / Math.log10(4)) - Math.log10(num) / Math.log10(4) == 0;

        // 解法IV：全场最骚做法
        // 如果num是4的幂，必须是2的幂，4的幂的二进制表示上，1只在奇数位上出现
        // 找一个数t，它的奇数位全是1，偶数位全是0，t和num两个一与，结果应该与num也就是4的幂相同
        // 否则就不是4的幂，这个奇数位全是1，偶数位全是0的数，应该是01010101010101010101010101010101
        // 鬼知道十进制是多少，但是可以写成16进制啊，那就是ox55555555
        //
        return num > 0 && (num & num -1) == 0 && (num & 0x55555555) == num;
    }
}

