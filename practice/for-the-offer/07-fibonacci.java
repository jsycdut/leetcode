/**
 *
 * Fibonacci f(1) = 1; f(2) = 1;
 * f(n) = f(n-1) + f(n-2);
 * 不用递归，改用迭代，所谓的动态规划
 *
 * 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0）。 n<=39
 *
 * 一遍过，毫无压力
 */
public class Solution {
    public int Fibonacci(int n) {
        // 边界
        if (n == 0) {
            return 0;
        }
        
        if (n == 1 || n == 2) {
            return 1;
        }
        int p = 1;
        int q = 1;
        int ans = 0;
        for (int i = 3; i <= n; i++) {
            ans = p + q;
            p = q;
            q = ans;
        }
        return ans;
    }
}
