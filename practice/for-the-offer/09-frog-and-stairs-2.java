/*
 * 剑指offer第9题 变态跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * 其实，这可能是跳台阶的最简单的一道题了
 * 设f(n)为青蛙跳上n级台阶的跳法
 * 青蛙可以从0跳n级，1跳n-1级，2跳n-2级，...，n-1跳一级
 * 那么，f(n)=f(n-1) + f(n-2) + ..... + f(1) + 1
 * 其中的1为直接跳n级，这个递推式可以看出，f(n) = 2 * f(n-1)
 * 其中f(1)=1, f(2)=2，所以，从n=2的时候就可以应用递推式了
 */
public class Solution {
    public int JumpFloorII(int target) {
        // 边界
        if (target == 0) {
            return 0;
        }
        
        if (target == 1) {
            return 1;
        }
        
        int t = 1;
        int i = 2;
        for(; i <=target; i++) {
            t = 2 * t;
        }
        
        return t;
        
    }
}
