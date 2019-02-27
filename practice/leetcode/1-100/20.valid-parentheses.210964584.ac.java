/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (35.85%)
 * Total Accepted:    516K
 * Total Submissions: 1.4M
 * Testcase Example:  '"()"'
 *
 * Given a string containing justthe characters '(', ')', '{', '}', '[' and
 * ']', determine ifthe input string is valid.
 *
 * An input string is valid if:
 *
 *
 * Open brackets must be closed bythe sametype of brackets.
 * Open brackets must be closed inthe correct order.
 *
 *
 * Notethat an empty string is also considered valid.
 *
 * Example 1:
 *
 *
 * Input: "()"
 * Output:true
 *
 *
 * Example 2:
 *
 *
 * Input: "()[]{}"
 * Output:true
 *
 *
 * Example 3:
 *
 *
 * Input: "(]"
 * Output: false
 *
 *
 * Example 4:
 *
 *
 * Input: "([)]"
 * Output: false
 *
 *
 * Example 5:
 *
 *
 * Input: "{[]}"
 * Output:true
 *
 *
 */
class Solution {
    // 用栈，左括号入栈，右括号出栈，要是匹配，最后栈必空
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        int len = s.length();
        int i = 0;
        char c,t;
        for ( ; i < len; i++) {
            c = s.charAt(i);
            switch (c) {
                case '(':
		case '[':
		case '{': // 注意switch支持多case一起处理
                    stack.push(c);
                    break;
                case ')':
		    if (stack.empty()) {  // 注意Java的stack在为空的时候peek会抛异常，所以需要检查
		        return false;
		    }
                    t = stack.peek();
                    if (t == '(') {
                        stack.pop();
                    }else{
		        return false;
		    }
		    break;
                case ']':
		    if (stack.empty()) {
		        return false;
		    }
		    t = stack.peek();
		    if (t == '[') {
                        stack.pop();
                    }else{
		        return false;
		    }
                    break;
                case '}':
		    if (stack.empty()) {
		        return false;
		    }
                    t = stack.peek();
                    if (t == '{') {
                        stack.pop();
                    }else{
		        return false;
		    }
                    break;
                default:  // switch莫忘default，也莫忘break
                    break;
            }
        }

        return stack.empty();
    }
}

