import java.util.ArrayList;
import java.util.Stack;
/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 *（注意：这两个序列的长度是相等的）
 *
 */
public class Solution {
    //  
    //  思路如下
    //  不要去想什么把出栈顺序玩出花，也就是说，你不能自己去 构造出栈顺序
    //  而是要按照给出的出栈顺序去出栈，最后栈空，说明出栈顺序正确，否则题目的出栈顺序是错的
    //  
    //
    //  就这么想，出栈目标当前为popA[target]，那么pushA入栈后，碰见popA[target]那是必须出栈的，然后target后移
    //  因为你只能对已经在栈里的数据进行出栈，因为你肯定无法对还没有入栈的元素进行出栈
    //  那么继续把当前target和栈顶元素比对，如果对不上号，说明下一个目标要么还没入栈，要么这个序列已经错了
    //  但是此时无法判断，所以继续pushA的入栈，在pushA全部入栈后，要是出栈顺序正确，那么在最后一个pushA入栈的时候，肯定能恰好对上target
    //  并且，对于栈中剩余的元素，必定和target后面的元素相同，也就是说，肯定能一波带走，如果带不走，出栈顺序就是错的。
    //
    //  要是考所有可能的出栈顺序的话！！！！ 怕我真的是要被一波带走了（逃
    public boolean IsPopOrder(int [] pushA,int [] popA) {
      // 边界判断，虽然题上说了两个序列长度相等，但面试写代码总还是小心点
      // 或者问清楚面试官特殊输入
      if (pushA == null || popA == null || pushA.length != popA.length) return false;
      if (pushA.length == 0 && popA.length == 0) return true;
      
      // 用于存储pushA的数据
      Stack<Integer> stack = new Stack<Integer>();
      int p = pushA.length;
      int target = 0;
      for (int i = 0; i < p; i++) {
          stack.push(pushA[i]);
          while (!stack.empty() && stack.peek() == popA[target]) {
              stack.pop();
              target++;
          }
      }
      
      return stack.empty();
    }
}
