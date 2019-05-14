/*
 * @lc app=leetcode id=142 lang=java
 *
 * [142] Linked List Cycle II
 *
 * https://leetcode.com/problems/linked-list-cycle-ii/description/
 *
 * algorithms
 * Medium (31.86%)
 * Total Accepted:    211.3K
 * Total Submissions: 663.1K
 * Testcase Example:  '[3,2,0,-4]\n1'
 *
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.
 * 
 * To represent a cycle in the given linked list, we use an integer pos which
 * represents the position (0-indexed) in the linked list where tail connects
 * to. If pos is -1, then there is no cycle in the linked list.
 * 
 * Note: Do not modify the linked list.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the
 * second node.
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the
 * first node.
 * 
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 * 
 * 
 * 
 * 
 * 
 * 
 * Follow up:
 * Can you solve it without using extra space?
 * 
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
      // 又是一道开眼界的题
      // 之前是判断是否有环，快的走两步，慢的走一步，在慢的进入环之后
      // 快的早就不知道在环里面不知道走了多少圈了，可能是0，也可能是n圈
      // 这取决于环的长度和进入环之前的那一段路径的长度
      //
      // 假设链表如图
      //
      // a->b->c->d
      //      /    \
      //      i     e
      //      |     |
      //      h<-g<-f
      //
      // 当慢指针到c的时候，快指针在e，顺时针沿e到c，总共有5步距离
      // 所以，快指针一定能在5步追到慢指针，原因如下
      // 设慢指针进入环的时候,快指针顺时针到慢指针的距离为x
      // 慢指针每次只走一步，快指针每次走两步，快慢指针各走一次，两者之间的距离就缩短1
      // 所以总共走x次快指针就可以追到慢指针，由于快慢指针之间的最大距离是环的长度n
      // 所以最多走n次，快指针就可以追到慢指针
      // 所以，快指针在慢指针进入环的时候，在两圈之内一定能追上慢指针
      // 
      // 将指针相遇的时候的各段距离抽象如下
      // 
      // start-----a----entry-------b-----meet-point
      //                  |                       |
      //                  |                       |
      //                   \                     /
      //                    ---------c-----------
      // 含义如下
      // start: 链表起点
      // entry: 环的入口
      // meet-point: 快慢指针的相遇地点
      // a：起点到入口的距离
      // b：入口到相遇地点的距离
      // c：相遇地点顺时针到环入口的距离
      // 
      // 设环的周长为p，则有p = b + c
      // 假设快指针追上慢指针的时候，他已经在环里面跑了n圈
      // 那么在遇上的时候，快指针所走过的距离 fast = a + n * p + b
      // 对应的，在相遇时，慢指针走的距离是 slow = a + b
      // 在时间相同的情况下，由于快指针的速度是慢指针的2倍
      // 所以有 fast = 2 * slow
      // a + n * p + b = 2 * (a + b)
      // 化简有 n * p = a + b;
      // 所以a + b这段距离一定是周长的整数倍
      // n * p = a + b => a = n * p - b => a = (n - 1) * p + c
      // 所以a里面有1个c，加上整数个周长
      //
      // 所以利用这个情况，在快指针追到慢指针之后，将慢指针指向链表开头
      // 两个指针齐步走，每次都走一步，在慢指针走过a的距离来到entry的时候
      // 快指针必定走了(n - 1)圈，回到了之前快慢指针的相遇点，此外还另外走了c的距离
      // 来到entry，快慢指针相等可以作为判断慢指针走了距离a那么长的一个衡量
      // 也是结束齐步走的条件
      //
      // 上面说的逆时针是针对我画的这个图，逆时针也是可以的，只是c的下一个节点是h而已
      // 不必太在意
      //
     
      if (head == null) return null;

      ListNode p = head;
      ListNode q = head;

      while (p.next != null && q.next != null && q.next.next != null) {
        p = p.next;
        q = q.next.next;

        if (p == q) {
          p = head;

          while (p != q) {
            p = p.next;
            q = q.next;
          }

          return p;
        }
      }

      return null;
    }
}

