/*
 * @lc app=leetcode id=30 lang=java
 *
 * [30] Substring with Concatenation of All Words
 *
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/
 *
 * algorithms
 * Hard (23.32%)
 * Total Accepted:    127K
 * Total Submissions: 544.3K
 * Testcase Example:  '"barfoothefoobarman"\n["foo","bar"]'
 *
 * You are given a string, s, and a list of words, words, that are all of the
 * same length. Find all starting indices of substring(s) in s that is a
 * concatenation of each word in words exactly once and without any intervening
 * characters.
 *
 * Example 1:
 *
 *
 * Input:
 * ⁠ s = "barfoothefoobarman",
 * ⁠ words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar"
 * respectively.
 * The output order does not matter, returning [9,0] is fine too.
 *
 *
 * Example 2:
 *
 *
 * Input:
 * ⁠ s = "wordgoodgoodgoodbestword",
 * ⁠ words = ["word","good","best","word"]
 * Output: []
 *
 *
 */
class Solution {
    // 两个Hashmap解决这道题，先将words里面的元素放入一个hashmap，K为字符串，V为K在words中出现的次数
    // 设字符串s长度为length，字符串数组words长度为len，words单个成员字符串长度为l（字母l）
    // 从0到length - len  * l，开始遍历，每次遍历的时候，范围为当前位置到之后的len * l
    // 隔长度l取一次子串，放进另一个临时的hashmap，和之前的words组成的hashmap作比较，如果相同
    // 那么就找到了一个解
    public List<Integer> findSubstring(String s, String[] words) {
        // 边界
        if (s == null || s.length() == 0 || words == null || words.length == 0) return Collections.emptyList();

        List<Integer> list = new ArrayList<Integer>();

        // 构造words数组的hashmap，记录每个单词各自出现几次
        Map<String, Integer> judge = new HashMap<String, Integer>();

        for (String str : words) {
             int i = judge.getOrDefault(str, 0);
             judge.put(str, i + 1);
        }

        int length = s.length();
        int len = words.length;
        int l = words[0].length();

        // 遍历s，隔l步长取一个子串，放入临时的嫌疑人map，最后和法官judge作比较
        // 注意第一个for循环的等号
        for (int i = 0; i <= length - len * l; i++) {
            Map<String, Integer> suspect = new HashMap<String, Integer>();

            for (int j = 0; j < len; j++) {
                String str = s.substring(i + j * l, i + j * l + l);

                // 出现了words中没有的单词，肯定没戏
                if (!judge.containsKey(str)) break;

                int k = suspect.getOrDefault(str, 0);
                suspect.put(str, k + 1);
            }

            if (judge.equals(suspect)) list.add(i);
        }

        return list;
    }
}

