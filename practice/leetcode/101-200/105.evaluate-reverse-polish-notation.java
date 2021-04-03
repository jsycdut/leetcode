class Solution {
  public int evalRPN(String[] tokens) {
    if (tokens == null || tokens.length == 0) return 0;
    Deque<Integer> stack = new ArrayDeque<>();
    for (String token : tokens) {
      switch (token) {
        case "+": stack.push(stack.pop() + stack.pop());
                  break;
        case "-": int subtrahend = stack.pop(); // 减数
                  int minuend = stack.pop(); // 被减数
                  stack.push(minuend - subtrahend);
                  break;
        case "*": stack.push(stack.pop() * stack.pop());
                  break;
        case "/": int divisor = stack.pop(); // 除数
                  int dividend = stack.pop(); // 被除数
                  stack.push(dividend / divisor);
                  break;
        default:  stack.push(Integer.valueOf(token));
                  break;
      }
    }

    return stack.pop();
  }
}
