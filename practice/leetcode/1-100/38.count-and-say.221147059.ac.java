/*
 * @lc app=leetcode id=38 lang=java
 *
 * [38] Count and Say
 *
 * https://leetcode.com/problems/count-and-say/description/
 *
 * algorithms
 * Easy (39.97%)
 * Total Accepted:    270.2K
 * Total Submissions: 675.9K
 * Testcase Example:  '1'
 *
 * The count-and-say sequence is the sequence of integers with the first five
 * terms as following:
 *
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 *
 *
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the
 * count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a
 * string.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: 1
 * Output: "1"
 *
 *
 * Example 2:
 *
 *
 * Input: 4
 * Output: "1211"
 *
 */
class Solution {
    // 这道题主要是题意
    // 1 读作 1
    // 前面的1叫做1个1，写成11
    // 前面的11叫做两个1，写成21
    // 前面的21叫做1个2，一个1，写成1211
    // 前面的1211叫做一个1，一个2,2个1，就写成111221
    // 从1开始，每次报数的结果是上一次报数的读法
    // 就是从头开始数，如果某个数字x出现个n次，那么就写成nx，只出现一次的x，就写成1x，迭代可解此题
    // 这题是我智商不够用╮(╯▽╰ )╭
    public String countAndSay(int n) {
        String str = "1";
        StringBuilder sb = new StringBuilder();

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < str.length();) {
                int counter = 1;

                // 找字符的重复次数
                while (j + 1 < str.length() && str.charAt(j + 1) == str.charAt(j)) {
                    counter++;
                    j++;
                }

                // 处理完当前字符（不管重复与否，都必须再向前跳一格，代表当前字符已经处理过了）
                // 比如1221处理2的时候，上面的代码完了j还指向第二个2，必须j++去处理下面的1，要不然就重复了
                // 这个j++的代码可以写到for循环里面，但是似乎有点难读（但是又好像可以接受哈）
                j++;
                sb.append(counter).append(str.charAt(j - counter));
            }

            str = sb.toString();
            sb = new StringBuilder();
        }

        return str;
    }
}

