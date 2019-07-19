/*
 * @lc app=leetcode id=292 lang=java
 *
 * [292] Nim Game
 *
 * https://leetcode.com/problems/nim-game/description/
 *
 * algorithms
 * Easy (55.72%)
 * Total Accepted:    187.5K
 * Total Submissions: 336.4K
 * Testcase Example:  '4'
 *
 * You are playing the following Nim Game with your friend: There is a heap of
 * stones on the table, each time one of you take turns to remove 1 to 3
 * stones. The one who removes the last stone will be the winner. You will take
 * the first turn to remove the stones.
 * 
 * Both of you are very clever and have optimal strategies for the game. Write
 * a function to determine whether you can win the game given the number of
 * stones in the heap.
 * 
 * Example:
 * 
 * 
 * Input: 4
 * Output: false 
 * Explanation: If there are 4 stones in the heap, then you will never win the
 * game;
 * No matter 1, 2, or 3 stones you remove, the last stone will always
 * be 
 * removed by your friend.
 */
class Solution {
    // 博弈论的题，一般要么是先手赢，要么是和条件有关系
    // 这个就是和条件有关系，只要石头是4的倍数，你必输
    // 否则必赢
    public boolean canWinNim(int n) {
      return n % 4 != 0;        
    }
}

