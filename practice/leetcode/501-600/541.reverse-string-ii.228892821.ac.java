/*
 * @lc app=leetcode id=541 lang=java
 *
 * [541] Reverse String II
 *
 * https://leetcode.com/problems/reverse-string-ii/description/
 *
 * algorithms
 * Easy (45.36%)
 * Total Accepted:    58.7K
 * Total Submissions: 129.4K
 * Testcase Example:  '"abcdefg"\n2'
 *
 * 
 * Given a string and an integer k, you need to reverse the first k characters
 * for every 2k characters counting from the start of the string. If there are
 * less than k characters left, reverse all of them. If there are less than 2k
 * but greater than or equal to k characters, then reverse the first k
 * characters and left the other as original.
 * 
 * 
 * Example:
 * 
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * 
 * 
 * 
 * Restrictions: 
 * 
 * ⁠The string consists of lower English letters only.
 * ⁠Length of the given string and k will in the range [1, 10000]
 * 
 */
class Solution {
    public String reverseStr(String s, int k) {
      // 一遍AC，没啥可说的
      // 就是快慢指针，距离满了2k，就反转前k个字符序列
      // 最后end为数组长度length，所以begin到end的距离为end - begin，而不是end - begin + 1
      // 解法I：想着一次只移动1格，太慢了，应该像解法II一样，一次移动2k个格子
      // if (s == null || s.length() == 0 || k <= 1) return s;
      //
      // char[] arr = s.toCharArray();
      //
      // int begin = 0;
      // int end = 0;
      //
      // while (end < arr.length) {
      //   if (end - begin + 1 == 2 * k) {
      //     reverse(arr, begin, begin + k - 1);
      //     end++;
      //     begin = end;
      //   } else {
      //     end++;
      //   }
      // }
      //
      // if (end - begin < k) {
      //   reverse(arr, begin, end - 1);
      // } else {
      //   reverse(arr, begin, begin + k - 1);
      // }
      //
      // return new String(arr);
      //
      // ==================================================
      //
      // 解法II：每次跳动2k个格子，效率更高

      if (s == null || s.length() == 0 || k <= 1) return s;

      char[] arr = s.toCharArray();
      
      int i = 0;
      int j = 0;
      int len = arr.length;

      while (i < len) {
        j = Math.min(i + k - 1, len - 1);
        reverse(arr, i, j);
        i += 2 * k;
      }

      return new String(arr);


    }

    void reverse(char[] arr, int i, int j) {
      while (i < j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
        i++;
        j--;
      }
    }
}

