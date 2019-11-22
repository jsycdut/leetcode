class Solution {
    // 本题是周赛题（题号一般大于1000），leetcoe-cli暂时还不支持题号大于1000的题目生成模板
    // URL：https://leetcode.com/problems/ugly-number-iii/
    // 本题考查二分搜索 + 容斥原理 + gcd（最大公约数） + lcm（最小公倍数）
    // 算出某个值内“丑数”的个数，如果大了，就往小的范围搜，反之往大的范围搜
    // 查找的时候，采用容斥原理，具体参考下方题解
    //
    // 题解[1]：给出了比较好的二分模板，非常不错，求gcd和lcm的略晦涩
    // url: https://leetcode.com/problems/ugly-number-iii/discuss/387539/cpp-Binary-Search-with-picture-and-Binary-Search-Template
    // 
    // 题解[2]: 绘图非常不错，但是最后二分代码不是很好，其他求gcd和lcm都比较好
    // url: https://leetcode.com/problems/ugly-number-iii/discuss/387780/C%2B%2B-Java-Binary-Search-with-Venn-Diagram-Explain-Math-Formula
    
    // 求最大公约数gcd
    long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
    
    // 求最小公倍数lcm
    long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }
    
    // 容斥原理求某个值n拥有的“丑数”个数
    long count(long n, long a, long b, long c) {
        return (n / a + n / b + n / c) 
            - n / lcm(a, b) 
            - n / lcm(b, c) 
            - n / lcm(c, a) 
            + n / lcm(a, lcm(b, c));
    }
    
    public int nthUglyNumber(int n, int a, int b, int c) {
        int lo = 1;
        int hi = 2 * 1000000000;
        
        // 二分搜索求解
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            
            int count = (int)count(mid, a, b, c);
            
            if (count >= n) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
            
        }
        
        return lo;
    }
}
