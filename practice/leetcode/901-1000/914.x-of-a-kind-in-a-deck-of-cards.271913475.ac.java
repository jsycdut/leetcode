/*
 * @lc app=leetcode id=914 lang=java
 *
 * [914] X of a Kind in a Deck of Cards
 *
 * https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/description/
 *
 * algorithms
 * Easy (33.94%)
 * Total Accepted:    24.6K
 * Total Submissions: 72.4K
 * Testcase Example:  '[1,2,3,4,4,3,2,1]'
 *
 * In a deck of cards, each card has an integer written on it.
 * 
 * Return true if and only if you can choose X >= 2 such that it is possible to
 * split the entire deck into 1 or more groups of cards, where:
 * 
 * 
 * Each group has exactly X cards.
 * All the cards in each group have the same integer.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3,4,4,3,2,1]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[3,3],[4,4]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [1,1,1,2,2,2,3,3]
 * Output: false
 * Explanation: No possible partition.
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: [1]
 * Output: false
 * Explanation: No possible partition.
 * 
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: [1,1]
 * Output: true
 * Explanation: Possible partition [1,1]
 * 
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: [1,1,2,2,2,2]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[2,2]
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= deck.length <= 10000
 * 0 <= deck[i] < 10000
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
 */
class Solution {
    // 这道题就是简单的求所有牌面出现的次数
    // 然后求所有次数的最大公约数
    // 如果这个最大公约数 >= 2，则true，否则false
    // 其实就是考察一个gcd
    public boolean hasGroupsSizeX(int[] deck) {
      // Map<Integer, Integer> map = new HashMap<>();
      // for (int i : deck) map.put(i, map.getOrDefault(i, 0) + 1);

      // int factor = map.get(deck[0]);
      // for (int i : map.values()) factor = gcd(factor, i);

      // return factor >= 2;

      // 下面采用位图的做法来统计牌面出现的次数要快一些
      // 因为免去了使用map
      // 注意题干说的
      // 1 <= deck.length <= 10000
      // 0 <= deck[i] < 10000
      // 所以用一个长度不大于10000的数组就可以统计了
      int[] bitmap = new int[10001];
      for (int i : deck) bitmap[i]++;

      int factor = 0;
      for (int i : bitmap) {
        if (i != 0) {
          factor = gcd(factor, i);
        }
      }

      return factor >= 2;
    }

    int gcd(int a, int b) {
      return a == 0 ? b : gcd(b % a, a);
    }
}

