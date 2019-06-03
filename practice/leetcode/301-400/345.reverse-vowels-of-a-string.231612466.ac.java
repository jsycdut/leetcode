/*
 * @lc app=leetcode id=345 lang=java
 *
 * [345] Reverse Vowels of a String
 *
 * https://leetcode.com/problems/reverse-vowels-of-a-string/description/
 *
 * algorithms
 * Easy (41.41%)
 * Total Accepted:    154.8K
 * Total Submissions: 373.7K
 * Testcase Example:  '"hello"'
 *
 * Write a function that takes a string as input and reverse only the vowels of
 * a string.
 * 
 * Example 1:
 * 
 * 
 * Input: "hello"
 * Output: "holle"
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "leetcode"
 * Output: "leotcede"
 * 
 * 
 * Note:
 * The vowels does not include the letter "y".
 * 
 * 
 * 
 */
class Solution {
    public String reverseVowels(String s) {
      // 思路：双指针
      // 先将s保存为char数组，然后遍历
      // 遇见元音字符就交换一把，最后把char数组转为String返回

      if (s == null || s.length() == 0) return "";

      char[] arr = s.toCharArray();

      int left = 0;
      int right = arr.length - 1;

      while (left < right) {
        if (!check(arr[left])) {
          left++;
        } else if (!check(arr[right])) {
          right--;
        } else {
          swap(arr, left, right);
          left++;
          right--;
        }
      }

      return new String(arr);
    }

    // 检查元音字符
    // 不要忘记大写字母和小写字母都有元音（面试忘记考虑这个肯定挂
    // 当然写成if语句什么的也可以，不过switch语句也行
    boolean check(char c) {
      switch(c) {
        case 'a':
        case 'A':
        case 'e':
        case 'E':
        case 'i':
        case 'I':
        case 'o':
        case 'O':
        case 'u':
        case 'U':
          return true;
        default : 
          return false;
      }
    }

    void swap(char[] arr, int i, int j) {
      char temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
}

