/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 *
 * https://leetcode.com/problems/powx-n/description/
 *
 * algorithms
 * Medium (27.82%)
 * Total Accepted:    309.3K
 * Total Submissions: 1.1M
 * Testcase Example:  '2.00000\n10'
 *
 * Implement pow(x, n), which calculates x raised to the power n (x^n).
 * 
 * Example 1:
 * 
 * 
 * Input: 2.00000, 10
 * Output: 1024.00000
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 2.10000, 3
 * Output: 9.26100
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25
 * 
 * 
 * Note:
 * 
 * 
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−2^31, 2^31 − 1]
 * 
 * 
 */
class Solution {
    // 思路其实很简单，只需要将x乘以n的绝对值次就可以得到结果了
    // 不过当n较大的时候，一个个的乘很慢，会导致TLE
    //
    // 一个有效的思路是通过平方来减少乘法使用的次数
    // 具体的思路是：设y = x ^ n的情况下
    // 在n为偶数的情况下 y = x ^ n = x ^ (n / 2) * x ^ (n / 2)
    // 在n为奇数的情况下 y = x ^ n = x ^ (n / 2) * x ^ (n / 2) * x
    // 所以可以用递归的思路来解，要求 y = x ^ n，先求x ^ (n / 2)，然后根据n的奇偶
    // 适当的乘以x，这道题就可解了，基本上是O(log N)的时间复杂度
    // 使用递归是很好理解的
    public double myPow(double x, int n) {
       // 解法1：递归的写法，这种写法比另外定义一个函数来递归的做法要难得多
       // 主要有两点
       // 1. 直接每次都用myPow(myPow(x, n / 2), 2)可能无法直接考虑到死循环的出现
       //    此时必须考虑到给2一个特殊的出口
       // 2. 当n为Integer.MIN_VALUE的情况下，直接将其取反会导致溢出
       //    而使用 1.0 / x * myPow(1.0 / x, -(n + 1))这种办法来避免溢出
       //    实在是需要点想法的
       // 而单独写个函数来解决的情况，思路会清晰很多，比如每次都是先求myPow(x, n / 2)
       // 然后进行结果的返回不会造成因为直接写myPow(myPow(x, n / 2), 2)的死循环
       // 其次，可以先对n为Integer.MIN_VALUE扩大到long来取绝对值从而避免溢出
       // 将所有的这一切放在一个函数里面操作，需要技巧，这就是高手啊
       if (n == 0) return 1.0;

       if (n < 0) {
           return 1.0 / x * myPow(1.0 / x, -(n + 1));
       }

       // 这个2是递归的重要出口，否则会Stack Overflow
       // 因为在n为2的时候调用为myPow(x, 2)
       // 然后调用一次是myPow(myPow(x, 1), 2) => myPow(x, 2)出现死循环栈溢出
       if (n == 2) return x * x;
        
       if ((n & 1) == 1) {
           return x * myPow(myPow(x, n / 2), 2);
       } else {
           return myPow(myPow(x, n / 2), 2);
       }

        // 解法2：迭代的写法
        // 迭代的想法还是需要点脑细胞的，相当于不断对n二分
        // 但是n是在减小，x在增大，res在times为1之前，保存的都是二分后没被乘上的x的积
        // 相比之下，还是递归的思路更清晰
        // if (n == 0) return 1.0;

        // double res = 1.0d;
        // long times = Math.abs((long)n);

        // while (times > 0) {
        //   if ((times & 1) == 1) {
        //       res *= x;
        //   }

        //   times /= 2;
        //   x *= x;
        // }

        // return n < 0 ? 1.0 / res : res;
    }
}

