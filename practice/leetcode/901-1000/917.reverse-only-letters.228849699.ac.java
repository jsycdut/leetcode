/*
 * @lc app=leetcode id=917 lang=java
 *
 * [917] Reverse Only Letters
 *
 * https://leetcode.com/problems/reverse-only-letters/description/
 *
 * algorithms
 * Easy (55.99%)
 * Total Accepted:    25.1K
 * Total Submissions: 44.8K
 * Testcase Example:  '"ab-cd"'
 *
 * Given a string S, return the "reversed" string where all characters that are
 * not a letter stay in the same place, and all letters reverse their
 * positions.
 * 
 * 
 * 
 * 
 * 
 * 
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
 * Input: "ab-cd"
 * Output: "dc-ba"
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 * 
 * Example 3:
 * 
 * 
 * Input: "Test1ng-Leet=code-Q!"
 * Output: "Qedo1ct-eeLg=ntse-T!"
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122 
 * S doesn't contain \ or "
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public String reverseOnlyLetters(String S) {
      // 挺简单的一道题，判断不是字母，直接跳过
      // 是的话就交换

      if (S == null || S.length() == 0) return "";

      char[] arr = S.toCharArray();

      int i = 0;
      int j = arr.length - 1;

      while (i < j) {
        if (!validate(arr[i])) {
          i++;  
        } else if (!validate(arr[j])) {
          j--;    
        } else {
          swap(arr, i, j);
          i++;
          j--;
        }

      }

      return new String(arr);
    }

    // 没想到ASCII里面A-Za-z竟然不是连在一起的
    // 'a' <= c && c <= 'Z'没法正确判断是不是字母 
    boolean validate(char c) {
      return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }

    void swap(char[] arr, int i, int j) {
      char temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
}

