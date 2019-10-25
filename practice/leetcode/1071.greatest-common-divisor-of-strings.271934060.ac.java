/*
 * @lc app=leetcode id=1071 lang=java
 *
 * [1071] Greatest Common Divisor of Strings
 *
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/description/
 *
 * algorithms
 * Easy (53.92%)
 * Total Accepted:    13.5K
 * Total Submissions: 25K
 * Testcase Example:  '"ABCABC"\n"ABC"'
 *
 * For strings S and T, we say "T divides S" if and only if S = T + ... + T  (T
 * concatenated with itself 1 or more times)
 * 
 * Return the largest string X such that X divides str1 and X divides str2.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= str1.length <= 1000
 * 1 <= str2.length <= 1000
 * str1[i] and str2[i] are English uppercase letters.
 * 
 * 
 */
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // https://leetcode.com/problems/greatest-common-divisor-of-strings/discuss/303781/JavaPython-3-3-codes-each%3A-Recursive-iterative-and-regex-w-brief-comments-and-analysis.
        if (str1.length() < str2.length()) { return gcdOfStrings(str2, str1); } // make sure str1 is not shorter than str2.
        else if (!str1.startsWith(str2)) { return ""; } // shorter string is not common prefix.
        else if (str2.isEmpty()) { return str1; } // gcd string found.
        else { return gcdOfStrings(str1.substring(str2.length()), str2); } // cut off the common prefix part of str1. 
    }
}

// 我当时想到的最原始的解法
// 能解，但是复杂度太高
// 从0开始不断取子串，然后逐步重复自己看是否能和目标字符串重合
// 如果能那么就找到了对应的X
//
// 然后就是两个x的个数的最大公因数就是这个题的解了
//
// 比如ABCABCABC可以有3个ABC
// ABCABC有2个ABC
// 所以X是ABC
// 3和2的gcd是1，所以结果是一个ABC
//
// ABABABAB有4个AB
// ABAB有2个AB
// 4和2的gcd为2，所以结果是2个AB，即ABAB
// class Solution {
//     public String gcdOfStrings(String str1, String str2) {
//         if (str1 == null || str2 == null) return "";
//         String x41 = str1;
//         String x42 = str2;
// 
//         boolean found1 = false;
//         for (int i = 1; i <= str1.length() / 2; i++) {
//             if (!found1) {
//                 String temp = str1.substring(0, i);
//                 String increase = temp;
//                 while (increase.length() <= str1.length()) {
//                     if (increase.equals(str1)) {
//                         x41 = temp;
//                         found1 = true;
//                         break;
//                     }
//                     increase += temp;
//                 }
//             }
//         }
// 
//         boolean found2 = false;
//         for (int i = 1; i <= str2.length() / 2; i++) {
//             if (!found2) {
//                 String temp = str2.substring(0, i);
//                 String increase = temp;
//                 while (increase.length() <= str2.length()) {
//                     if (increase.equals(str2)) {
//                         x42 = temp;
//                         found2 = true;
//                         break;
//                     }
//                     increase += temp;
//                 }
//             }
// 
//         }
// 
//         if (!x41.equals(x42)) return "";
// 
//         int times = gcd(str1.length() / x41.length(), str2.length() / x42.length());
//         String ans = "";
// 
//         for (int i = 0; i < times; i++) ans += x41;
// 
//         return ans;
// 
//     }
// 
//     int gcd(int a, int b) {
//         return a == 0 ? b : gcd(b % a, a);
//     }
// }

