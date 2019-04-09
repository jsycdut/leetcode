/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 *
 * https://leetcode.com/problems/add-binary/description/
 *
 * algorithms
 * Easy (38.49%)
 * Total Accepted:    288.7K
 * Total Submissions: 750.1K
 * Testcase Example:  '"11"\n"1"'
 *
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 *
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 *
 * Example 2:
 *
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 */
class Solution {

    // 从尾到头处理，模拟加法的过程就可以了
    public String addBinary(String a, String b) {

        // 老规矩，判空，虽然题目说了不为空，但是流程还是要走的（防止面试没问输入为空导致代码bug）
        if (a == null || b == null || a.length() == 0 || b.length() == 0) return "";

        // la即lengthOfA，意味字符串a的长度（逃，变量命名太难了...
        int la = a.length();
        int lb = b.length();

        char e, f;
        int len = la > lb ? la : lb;

        int carrier = 0;
        StringBuilder res = new StringBuilder();

        // 按照最长的处理，较短的那个串以0来补位
        for (int i = 1; i <= len; i++) {
            e = la - i < 0 ? '0' : a.charAt(la - i);
            f = lb - i < 0 ? '0' : b.charAt(lb - i);

            if (e == '1' && f == '1') {
                res.append(carrier);
                carrier = 1;
            } else if ((e == '0' && f == '1') || (e == '1' && f == '0')){
                if (carrier == 0) {
                    res.append(1);
                    carrier = 0;
                } else {
                    res.append(0);
                    carrier = 1;
                }
            } else {
                res.append(carrier);
                carrier = 0;
            }
        }

        // 处理可能产生的最后的进位
        if (carrier == 1) res.append(1);

        return res.reverse().toString();
    }
}

