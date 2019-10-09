/*
 * @lc app=leetcode id=204 lang=java
 *
 * [204] Count Primes
 *
 * https://leetcode.com/problems/count-primes/description/
 *
 * algorithms
 * Easy (29.71%)
 * Total Accepted:    273.8K
 * Total Submissions: 914.7K
 * Testcase Example:  '10'
 *
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 * Example:
 * 
 * 
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * 
 * 
 */
class Solution {
    // 本题意找出小于n的素数有多少个
    // 判断素数的有朴素算法，线性筛法
    // 6素数法等
    public int countPrimes(int n) {
        boolean[] arr = new boolean[n];

        for (int i = 2; i * i <= n; i++) {
          if (arr[i]) continue;

          for (int j = i * i; j < n; j += i) {
            arr[j] = true;
          } 
        }

        int count = 0;

        for (int i = 2; i < n; i++) {
          if (!arr[i]) count++;
        }

        return count;
    }
}

