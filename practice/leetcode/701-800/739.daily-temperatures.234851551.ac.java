/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 *
 * https://leetcode.com/problems/daily-temperatures/description/
 *
 * algorithms
 * Medium (60.02%)
 * Total Accepted:    67.9K
 * Total Submissions: 113.1K
 * Testcase Example:  '[73,74,75,71,69,72,76,73]'
 *
 * 
 * Given a list of daily temperatures T, return a list such that, for each day
 * in the input, tells you how many days you would have to wait until a warmer
 * temperature.  If there is no future day for which this is possible, put 0
 * instead.
 * 
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76,
 * 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * 
 * 
 * Note:
 * The length of temperatures will be in the range [1, 30000].
 * Each temperature will be an integer in the range [30, 100].
 * 
 */
class Solution {
    public int[] dailyTemperatures(int[] T) {
      if (T == null || T.length == 0) return new int[0];
      
      // 本题可以用暴力法，但是这不是一个好的办法
      // 可以维持一个递增栈，里面保存元素索引
      // 从后往前访问T的元素t，如果栈里的索引对应的数组元素比t小
      // 就可以把栈里保存的的索引消除掉，直到遇到栈为空或者比t大的元素
      // 这里之所以可以消除的原因是：从后往前，如果元素都比自己小
      // 那么就是没有比自己大的元素，也就是自己比之后的元素都大
      // 删除栈里的元素会不会对前面没有处理过的元素有影响呢？答案是不会
      // 因为前面的元素在找到比他大的已经被删除掉的元素的之前，一定会碰见当前元素
      // 这不会影响结果，下面用示例解释这个做法
      //
      // T：输入数组
      // ans：结果，保存的是比自己大的那个数的索引（写代码可以直接写索引差）
      // stack：比当前数都大的数的索引，是个栈，且栈顶离的数离自己最近
      // *：当前正在处理的数
      //
      // 初始状态
      // T:     [73, 74, 75, 71, 69, 72, 76, 73]
      // ans:   [0, 0, 0, 0, 0, 0, 0, 0, 0]
      // stack: []
      //                                     *
      // T:     [73, 74, 75, 71, 69, 72, 76, 73]
      // ans:   [0, 0, 0, 0, 0, 0, 0, 0, 0]
      // stack: [7]
      //                                 *
      // T:     [73, 74, 75, 71, 69, 72, 76, 73]
      // ans:   [0, 0, 0, 0, 0, 0, 0, 0, 0]
      // stack: [6]
      //                             *
      // T:     [73, 74, 75, 71, 69, 72, 76, 73]
      // ans:   [0, 0, 0, 0, 0, 6, 0, 0]
      // stack: [6, 5]
      //                         *
      // T:     [73, 74, 75, 71, 69, 72, 76, 73]
      // ans:   [0, 0, 0, 0, 5, 6, 0, 0]
      // stack: [6, 5, 4]
      //                     *
      // T:     [73, 74, 75, 71, 69, 72, 76, 73]
      // ans:   [0, 0, 0, 5, 5, 6, 0, 0]
      // stack: [6, 5, 3]
      //                 *
      // T:     [73, 74, 75, 71, 69, 72, 76, 73]
      // ans:   [0, 0, 6, 5, 5, 6, 0, 0]
      // stack: [6, 2]
      //             *
      // T:     [73, 74, 75, 71, 69, 72, 76, 73]
      // ans:   [0, 2, 6, 5, 5, 6, 0, 0]
      // stack: [6, 2, 1]
      //         *
      // T:     [73, 74, 75, 71, 69, 72, 76, 73]
      // ans:   [1, 2, 6, 5, 5, 6, 0, 0]
      // stack: [6, 2, 1, 0]
      //
      // 最后ans替换为索引
      // ans:   [1, 1, 4, 2, 1, 1, 0, 0]
      //
      
      int[] ans = new int[T.length];

      Deque<Integer> stack = new ArrayDeque<Integer>();

      for (int i = T.length - 1; i >= 0; i--) {
        while (stack.size() > 0 && T[stack.peek()] <= T[i]) stack.pop();
        ans[i] = stack.size() > 0 ? stack.peek() - i : 0;
        stack.push(i);
      }

      return ans;
    }
}

