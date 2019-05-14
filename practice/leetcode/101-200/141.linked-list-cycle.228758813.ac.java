/*
 * @lc app=leetcode id=141 lang=java
 *
 * [141] Linked List Cycle
 *
 * https://leetcode.com/problems/linked-list-cycle/description/
 *
 * algorithms
 * Easy (36.72%)
 * Total Accepted:    397.6K
 * Total Submissions: 1.1M
 * Testcase Example:  '[3,2,0,-4]\n1'
 *
 * Given a linked list, determine if it has a cycle in it.
 * 
 * To represent a cycle in the given linked list, we use an integer pos which
 * represents the position (0-indexed) in the linked list where tail connects
 * to. If pos is -1, then there is no cycle in the linked list.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the
 * second node.
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the
 * first node.
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Follow up:
 * 
 * Can you solve it using O(1) (i.e. constant) memory?
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
    public boolean hasCycle(ListNode head) {
      // 快慢指针解决单链表带环问题
      // 快的每次走两步，慢的走1步
      // 这样在环里面，快的总会追上慢的
      // 如果p或者q的next是null，说明遇上了结尾
      // q.next.next也是一样的，也说明链表是有结尾的
      //
      // 快慢指针还可以解决下面的问题
      // 1. 求链表中间的节点，也是快指针每次走两步，慢的走一步，快的到头，慢的就在中间
      // 2. 求链表1/3处的节点，其实第一题就是求链表1/2处的节点，要求1/3处的节点，快的每次走3步，慢的走一步就行了
      // 3. 求链表倒数第k个节点，慢的先不动，让快的指针走到k的位置，然后大家每次都走一步，快的到头了，慢的就是倒数第k个
      //
      if (head == null) return false;

      ListNode p = head;
      ListNode q = head;

      while (p.next != null && q.next != null && q.next.next != null) {
        p = p.next;
        q = q.next.next;
        if (p == q) return true; // 对象的==比较的是内存地址，内存地址一致，比val相等更有说服力
      }
      
      return false;
      }
}

