/*
 * @lc app=leetcode id=454 lang=java
 *
 * [454] 4Sum II
 *
 * https://leetcode.com/problems/4sum-ii/description/
 *
 * algorithms
 * Medium (49.91%)
 * Total Accepted:    59.2K
 * Total Submissions: 118.5K
 * Testcase Example:  '[1,2]\n[-2,-1]\n[-1,2]\n[0,2]'
 *
 * Given four lists A, B, C, D of integer values, compute how many tuples (i,
 * j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 *
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤
 * N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is
 * guaranteed to be at most 231 - 1.
 *
 * Example:
 *
 *
 * Input:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * Output:
 * 2
 *
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 *
 *
 *
 *
 */
class Solution {
    // make 4 sum to double 2 sum, use hashmap to keep the sum of Array A and Array B
    // and all we need to do is traversing the Array C and Array D, check every sum of these two arrays(mark it as key)
    // if we can find (0 - key) in hashmap, we find a valid answer.
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A == null || B == null || C == null || D == null) return 0;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int key, res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                key = A[i] + B[j];
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key, 1);
                }
            }
        }

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                key = 0 - C[i] - D[j];
                if (map.containsKey(key)) {
                    res += map.get(key);
                }
            }
        }
        return res;
    }

}

