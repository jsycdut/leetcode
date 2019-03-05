/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 *
 * https://leetcode.com/problems/roman-to-integer/description/
 *
 * algorithms
 * Easy (51.54%)
 * Total Accepted:    368.2K
 * Total Submissions: 713.9K
 * Testcase Example:  '"III"'
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D
 * and M.
 * 
 * 
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 
 * For example, two is written as II in Roman numeral, just two one's added
 * together. Twelve is written as, XII, which is simply X + II. The number
 * twenty seven is written as XXVII, which is XX + V + II.
 * 
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is
 * written as IV. Because the one is before the five we subtract it making
 * four. The same principle applies to the number nine, which is written as IX.
 * There are six instances where subtraction is used:
 * 
 * 
 * I can be placed before V (5) and X (10) to make 4 and 9. 
 * X can be placed before L (50) and C (100) to make 40 and 90. 
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * 
 * 
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be
 * within the range from 1 to 3999.
 * 
 * Example 1:
 * 
 * 
 * Input: "III"
 * Output: 3
 * 
 * Example 2:
 * 
 * 
 * Input: "IV"
 * Output: 4
 * 
 * Example 3:
 * 
 * 
 * Input: "IX"
 * Output: 9
 * 
 * Example 4:
 * 
 * 
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * 
 */
 /*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 *
 * https://leetcode.com/problems/roman-to-integer/description/
 *
 * algorithms
 * Easy (51.54%)
 * Total Accepted:    368.2K
 * Total Submissions: 713.9K
 * Testcase Example:  '"III"'
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D
 * and M.
 * 
 * 
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 
 * For example, two is written as II in Roman numeral, just two one's added
 * together. Twelve is written as, XII, which is simply X + II. The number
 * twenty seven is written as XXVII, which is XX + V + II.
 * 
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is
 * written as IV. Because the one is before the five we subtract it making
 * four. The same principle applies to the number nine, which is written as IX.
 * There are six instances where subtraction is used:
 * 
 * 
 * I can be placed before V (5) and X (10) to make 4 and 9. 
 * X can be placed before L (50) and C (100) to make 40 and 90. 
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * 
 * 
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be
 * within the range from 1 to 3999.
 * 
 * Example 1:
 * 
 * 
 * Input: "III"
 * Output: 3
 * 
 * Example 2:
 * 
 * 
 * Input: "IV"
 * Output: 4
 * 
 * Example 3:
 * 
 * 
 * Input: "IX"
 * Output: 9
 * 
 * Example 4:
 * 
 * 
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * 
 */
class Solution {
    // 本题的思路是，从左往右处理
    // 依然有前后缀的思想1-10的前缀I 中缀为V 后缀为X
    // 遇见前缀，检查后面是否有中缀和后缀，有的话加上对应的权重，同时后跳两格
    // 这样的办法，在处理的过程中，仅仅会留下单个中缀，加上对应的权重就行了
    public int romanToInt(String s) {
        int i;
        char c;
        int res = 0;
        int len = s.length();
        for (i = 0; i < len; ) {
            c = s.charAt(i);
            if (c == 'M') {
                res += 1000;
                i++;
                continue;
            }
                
            if (c == 'D') {
                res += 500;
                i++;
                continue;
            }

            if (c == 'C') {
                if (i + 1 < len && s.charAt(i + 1) == 'M') {
                    res += 900;
                    i += 2;
                    continue;
                }

                if (i + 1 < len && s.charAt(i + 1) == 'D') {
                    res += 400;
                    i += 2;
                    continue;
                }

                res += 100;
                i++;
                continue;
            }
                
            if (c == 'L') {
                res += 50;
                i++;
                continue;
            }

            if (c == 'X') {
                if (i + 1 < len && s.charAt(i + 1) == 'C') {
                    res += 90;
                    i += 2;
                    continue;
                }

                if (i + 1 < len && s.charAt(i + 1) == 'L') {
                    res += 40;
                    i += 2;
                    continue;
                }

                res += 10;
                i++;
                continue;
            }

            if (c == 'V') {
                res += 5;
                i++;
                continue;
            }

            if (c == 'I') {
                if (i + 1 < len && s.charAt(i + 1) == 'X') {
                    res += 9;
                    i += 2;
                    continue;
                }

                if (i + 1 < len && s.charAt(i + 1) == 'V') {
                    res += 4;
                    i += 2;
                    continue;
                }

                res += 1;
                i++;
                continue;
            }
        }    
        return res;
    }
}


