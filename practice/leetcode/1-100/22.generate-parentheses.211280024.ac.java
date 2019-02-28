/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 *
 * https://leetcode.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (53.10%)
 * Total Accepted:    300.9K
 * Total Submissions: 566.6K
 * Testcase Example:  '3'
 *
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * 
 * 
 * For example, given n = 3, a solution set is:
 * 
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 */
class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        recursive(new char[ 2 * n], 0, list);
        return list;
    }

    // 完全暴力做法，递归，穷举出2 ^ (2 * n)中可能，然后一一验证序列的合法性
    // 突然明白，这样的递归就是不断的在让程序分岔
    private void recursive(char[] arr, int position, List<String> list) {
        if (position == arr.length) {
            if (check(arr)) {
            list.add(new String(arr));
        }
        return;
    } else {
        arr[position] = '(';
        recursive(arr, position + 1, list);
        arr[position] = ')';
        recursive(arr, position + 1, list);
    }
    }

    // 愚蠢的用栈来验证仅有()两种符号的括号序列，有更好的办法的    
    private boolean check(char[] arr) {
        Stack<Character> stack = new Stack<Character>();
        int len = arr.length;
        int i = 0;
        char c;

        for (; i < len; i++) {
            c = arr[i];
            switch (c) {
                case '(':
                stack.push(c);
                break;
            case ')':
                if (!stack.empty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
                break;
            default:
                break;
            }
        }
        return stack.empty();
    }
}

