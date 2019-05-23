/*
 * @lc app=leetcode id=989 lang=java
 *
 * [989] Add to Array-Form of Integer
 *
 * https://leetcode.com/problems/add-to-array-form-of-integer/description/
 *
 * algorithms
 * Easy (44.60%)
 * Total Accepted:    14.2K
 * Total Submissions: 31.9K
 * Testcase Example:  '[1,2,0,0]\n34'
 *
 * For a non-negative integer X, the array-form of X is an array of its digits
 * in left to right order.  For example, if X = 1231, then the array form is
 * [1,2,3,1].
 * 
 * Given the array-form A of a non-negative integer X, return the array-form of
 * the integer X+K.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: A = [1,2,0,0], K = 34
 * Output: [1,2,3,4]
 * Explanation: 1200 + 34 = 1234
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: A = [2,7,4], K = 181
 * Output: [4,5,5]
 * Explanation: 274 + 181 = 455
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: A = [2,1,5], K = 806
 * Output: [1,0,2,1]
 * Explanation: 215 + 806 = 1021
 * 
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * Output: [1,0,0,0,0,0,0,0,0,0,0]
 * Explanation: 9999999999 + 1 = 10000000000
 * 
 * 
 * 
 * 
 * Note：
 * 
 * 
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * If A.length > 1, then A[0] != 0
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
      List<Integer> list = new ArrayList<>();

      // 这种题其实意义不大，感觉唯一要考的点就是最后可能有个进位了
     
      // A判空
      if (A == null || A.length == 0) {
        list.add(K);
        return list;
      }

      // 转为字符数组来操作
      // 当然一位一位的从K身上剥离数字也未尝不可
      char[] B = String.valueOf(K).toCharArray();

      int m = A.length - 1;
      int n = B.length - 1;

      int carrier = 0;

      while (m != -1 || n != -1) {
        int a = m == -1 ? 0 : A[m];
        int b = n == -1 ? 0 : B[n] - '0';

        int sum = (a + b + carrier) % 10;
        list.add(sum);

        carrier = (a + b + carrier) / 10;

        m = m == -1 ? -1 : --m;
        n = n == -1 ? -1 : --n;

      }

      if (carrier != 0) list.add(carrier);
     
      Collections.reverse(list);

      return list;
    }
}

