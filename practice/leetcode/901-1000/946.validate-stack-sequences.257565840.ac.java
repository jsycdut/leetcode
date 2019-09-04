/*
 * @lc app=leetcode id=946 lang=java
 *
 * [946] Validate Stack Sequences
 *
 * https://leetcode.com/problems/validate-stack-sequences/description/
 *
 * algorithms
 * Medium (58.12%)
 * Total Accepted:    18.1K
 * Total Submissions: 31.2K
 * Testcase Example:  '[1,2,3,4,5]\n[4,5,3,2,1]'
 *
 * Given two sequences pushed and popped with distinct values, return true if
 * and only if this could have been the result of a sequence of push and pop
 * operations on an initially empty stack.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * Output: true
 * Explanation: We might do the following sequence:
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * Output: false
 * Explanation: 1 cannot be popped before 2.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 0 <= pushed.length == popped.length <= 1000
 * 0 <= pushed[i], popped[i] < 1000
 * pushed is a permutation of popped.
 * pushed and popped have distinct values.
 * 
 * 
 * 
 */
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
      // 用栈，在入栈的时候准备出栈
      // 出栈的条件是栈顶元素与当前出栈元素相等
      // 否则只入栈不出栈
      // 如果出栈顺序合理
      // 那么最后栈必空
      int index = 0;
      int len = popped.length;

      ArrayDeque<Integer> pushStack = new ArrayDeque<>();

      for (int i = 0; i < len; i++) {

        pushStack.offer(pushed[i]);

	// 保证index不越界和栈不空
	while (!pushStack.isEmpty() && index < len && popped[index] == pushStack.getLast()) {
	  pushStack.removeLast();
	  index++;
	}
      }

      return pushStack.isEmpty();
    }
}

