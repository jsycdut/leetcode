/*
 * 剑指offer第8题 青蛙跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 
 * 其实就是变形版的fibonacci，假设此时青蛙在第n个台阶
 * 那么它必定是从n-1或者n-2台阶上来的（毕竟这只青蛙每次只能跳一级或者两级）
 * 那么f(n) = f(n-1) + f(n-2);
 * 只需要简单知道f(1)和f(2)即可
 * 这道题当然也可以递归...
 */
public class Solution {
    public int JumpFloor(int target) {
        // 边界
        if (target == 1) return 1;
        if (target == 2) return 2;
        
        int p = 1;
        int q = 2;
        int i = 3;
        int ans = 0;
        
        for (; i <= target; i++) {
            ans = p + q;
            p = q;
            q = ans;
        }
        return ans;
    }
}
