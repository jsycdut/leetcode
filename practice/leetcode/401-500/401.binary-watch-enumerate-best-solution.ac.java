/*
 * @lc app=leetcode id=401 lang=java
 *
 * [401] Binary Watch
 *
 * https://leetcode.com/problems/binary-watch/description/
 *
 * algorithms
 * Easy (45.08%)
 * Total Accepted:    60.4K
 * Total Submissions: 134K
 * Testcase Example:  '0'
 *
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and
 * the 6 LEDs on the bottom represent the minutes (0-59).
 * Each LED represents a zero or one, with the least significant bit on the
 * right.
 * 
 * For example, the above binary watch reads "3:25".
 * 
 * Given a non-negative integer n which represents the number of LEDs that are
 * currently on, return all possible times the watch could represent.
 * 
 * Example:
 * Input: n = 1Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04",
 * "0:08", "0:16", "0:32"]
 * 
 * 
 * Note:
 * 
 * The order of output does not matter.
 * The hour must not contain a leading zero, for example "01:00" is not valid,
 * it should be "1:00".
 * The minute must be consist of two digits and may contain a leading zero, for
 * example "10:2" is not valid, it should be "10:02".
 * 
 * 
 */
class Solution {
    // 和之前的暴力dfs不同，本次也是暴力
    // 但是暴力的枚举数量少很多很多，只需要枚举所有的小时和分钟的组合
    // 然后在里面找出1的个数和num相同的即可
    // 之前dfs 150ms，而本解法，只需要1ms
    // 所以，在能缩小枚举空间的情况下，尽量的缩小枚举空间
    // 另外，这里cal方法，是用于检查一个数字有多少个1的好办法
    // 其实就是以前数字电路课上看到的除2取余法（逃，好好学习
    public List<String> readBinaryWatch(int num) {
      List<String> list = new ArrayList<String>();
      if (num < 0 || num > 10) return list;
        
      for (int i = 0; i < 12; i++) {
          for (int j = 0; j < 60; j++) {
              if (cal(i) + cal(j) == num) {
                  list.add("" + i + ":" + (j > 9 ? j : "0" + j));
              }
        }
      }
      return list;
    }

    public int cal(int i) {
        int res = 0;
        while (i > 0) {
            res += (i % 2);
            i /= 2;
        }
        return res;
    }
}

