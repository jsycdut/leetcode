/*
 * @lc app=leetcode id=12 lang=java
 *
 * [12] Integer to Roman
 *
 * https://leetcode.com/problems/integer-to-roman/description/
 *
 * algorithms
 * Medium (49.73%)
 * Total Accepted:    205K
 * Total Submissions: 411.8K
 * Testcase Example:  '3'
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
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be
 * within the range from 1 to 3999.
 * 
 * Example 1:
 * 
 * 
 * Input: 3
 * Output: "III"
 * 
 * Example 2:
 * 
 * 
 * Input: 4
 * Output: "IV"
 * 
 * Example 3:
 * 
 * 
 * Input: 9
 * Output: "IX"
 * 
 * Example 4:
 * 
 * 
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * 
 */
class Solution {
    // 就是个规律观察题，意义不大
    // 思路就是，不断取余，不断除10，得到各位上的数字
    // 罗马数字也是有规律的，一个数字，可以用前缀，中缀，后缀表示
    // 比如 1-10的前缀是I，中缀是V ，后缀是X
    // 小于4的就是前缀的叠加，比如3为III
    // 等于4的就是前缀中缀，IV
    // 等于5的就是中缀, V
    // 大于5小于9的就是中缀+前缀的叠加，比如8,VIII
    // 等于9的就是前缀后缀IX
    //
    // 10-100的前缀是X，中缀是L，后缀是C
    // 100-1000的前缀是C，中缀是D， 后缀是M
    //
    // 按照这个规律，处理每个数字就行了
    // 注意的是，大于1000的，除完了1000后，还剩个千位的M没处理，补上就是了
    // 另外注意，这样处理是从后往前，其顺序和最终的表达是反的，所以得到结果的时候要reverse一下
    // 而且，单个数字的表达在reverse的时候又颠倒了，比如原来8为VIII，reverse的时候就成了IIIV
    // 所以，在处理单个结果的时候就要反着放，这样reverse的时候就把姿势调回来了
    public String intToRoman(int num) {
        char[][] marks = {{'I', 'V', 'X'}, {'X', 'L', 'C'}, {'C', 'D', 'M'}}; // 二维数组
        StringBuilder sb = new StringBuilder();
        int i, j;
        for (i = 0; i < marks.length; i++) {
            if (num == 0) break; // 小于1000的，连除3次10，就是1000，就会变0，可以停止了
            int m = num % 10; //取余
            if (m < 4) {
                for (j = 1; j <= m; j++) {
                    sb.append(marks[i][0]);
                }
            }
            
            if (m == 4) {
                sb.append(marks[i][1]); // 注意反着放，下面的类似
                sb.append(marks[i][0]);
            }
            
            if (m == 5) {
                sb.append(marks[i][1]);
            }
            
            if ( 5 < m && m < 9) {
                for(j = 1; j <= m - 5; j++) {
                    sb.append(marks[i][0]);
                }
                sb.append(marks[i][1]);
            }
            
            if (m == 9) {
                sb.append(marks[i][2]);
                sb.append(marks[i][0]);
            }
            
            num = num / 10;
        }
        
        // 处理可能剩余的千位数字
        for (j = 1; j <= num; j++) {
            sb.append('M');
        }
       
        // reverse
        return sb.reverse().toString();
    }
}
