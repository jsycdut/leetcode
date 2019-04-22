/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 *
 * https://leetcode.com/problems/min-stack/description/
 *
 * algorithms
 * Easy (36.49%)
 * Total Accepted:    288.2K
 * Total Submissions: 789.8K
 * Testcase Example:  '["MinStack","push","push","push","getMin","pop","top","getMin"]\n[[],[-2],[0],[-3],[],[],[],[]]'
 *
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 *
 *
 * push(x) -- Push element x onto stack.
 *
 *
 * pop() -- Removes the element on top of the stack.
 *
 *
 * top() -- Get the top element.
 *
 *
 * getMin() -- Retrieve the minimum element in the stack.
 *
 *
 *
 *
 * Example:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 *
 *
 */
class MinStack {

    // 解法1：自己写一个栈结构，但是这样竟然很慢很慢很慢...
    // class MinStack {
    //
    //     private int[] stack;
    //
    //     private int length;
    //
    //     private int min;
    //
    //     private int[] resizedStack;
    //
    //     //initialize your data structure here.
    //     public MinStack() {
    //         length = 0;
    //         min = Integer.MAX_VALUE;
    //         stack = new int[2];
    //
    //     }
    //
    //     public void push(int x) {
    //         length++;
    //
    //         // 栈扩容
    //         if (length > stack.length) {
    //             resizedStack = new int[2 * length];
    //
    //             for (int i = 0; i < length - 1; i++) {
    //                 resizedStack[i] = stack[i];
    //             }
    //
    //             stack = resizedStack;
    //         }
    //
    //         stack[length - 1] = x;
    //     }
    //
    //     public void pop() {
    //         length--;
    //     }
    //
    //     public int top() {
    //         return stack[length - 1];
    //     }
    //
    //     public int getMin() {
    //         min = Integer.MAX_VALUE;
    //         for (int i = 0; i < length; i++) {
    //             min = Math.min(min, stack[i]);
    //         }
    //
    //         return min;
    //     }
    //  }

    // 解法2，利用Java已有的栈结构(作弊，不要脸...
    // 但是这个解法就是快啊，我能说啥...
    // 解题的思路是双栈结构，一个栈做常规的栈操作
    // 另一个栈保存对应栈位置的最小值
    // 两个栈的高度永远是一样的（关键）
    // 在常规栈入栈的时候，检查push的值（设为x）与最小栈栈顶元素（设为y）的关系
    // 如果y < x，那么最小栈压入y，常规栈压入x
    // 否则两个栈都压入x
    // 出栈的时候，两个栈都出栈
    // 取最小值，直接取最小栈的栈顶元素即可

    /** initialize your data structure here. */

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int x) {
        if ((minStack.empty()) || (!minStack.empty() && x <= minStack.peek())) {
            minStack.push(x);
        } else {
            minStack.push(minStack.peek());
        }

        stack.push(x);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


