/*
 * @lc app=leetcode id=93 lang=java
 *
 * [93] Restore IP Addresses
 *
 * https://leetcode.com/problems/restore-ip-addresses/description/
 *
 * algorithms
 * Medium (30.84%)
 * Total Accepted:    132.1K
 * Total Submissions: 428K
 * Testcase Example:  '"25525511135"'
 *
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 *
 * Example:
 *
 *
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 *
 *
 */
class Solution {
    // 点分十进制的IP地址由三个点分割为4部分，比如0.0.0.0
    // 且每一部分都不会超过3位数，并且每一部分都满足 0 <= val <= 255
    // 所以在遍历字符串前3位表示第一个点的位置
    // 遍历后三位放一个点，剩下的部分放一个点
    // 三个点将字符串分割为4部分，检查对应的值是否合理就行了
    // 复杂度的话，真不好想，难（逃
    public List<String> restoreIpAddresses(String s) {
        // 边界检查
        List<String> list = new ArrayList<>();
        if (s == null) return list;
        int len = s.length();
        if (len == 0 || len > 12) return list;

        // 将字符串分三部分遍历并检查合法性
        for (int i = 0; i < 3; i++) {
            for (int j = len - 1; j > len - 4 && j > i + 2; j--) {
                for (int k = i + 1; k < j - 1; k++) {
                     String first = s.substring(0, i + 1);
                     String second = s.substring(i + 1, k + 1);
                     String third = s.substring(k + 1, j);
                     String fourth = s.substring(j, len);
                     if (check(first) && check(second) && check(third) && check(fourth)) {
                         list.add(first + "." + second + "." + third + "." + fourth);
                     }
                }
            }
        }

        return list;

    }

    boolean check(String str) {
        // 有点坑，处理01这种能被parseInt正确处理但不合法的字符串
        if (str.length() > 1 && str.charAt(0) == '0') return false;

        int val = Integer.parseInt(str);
        return (0 <= val) && (val <= 255);
    }
}

