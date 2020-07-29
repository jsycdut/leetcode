/*
 * @lc app=leetcode id=160 lang=java
 *
 * [160] Intersection of Two Linked Lists
 *
 * https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 *
 * algorithms
 * Easy (35.32%)
 * Total Accepted:    363.5K
 * Total Submissions: 997.4K
 * Testcase Example:  '8\n[4,1,8,4,5]\n[5,0,1,8,4,5]\n2\n3'
 *
 * Write a program to find the node at which the intersection of two singly
 * linked lists begins.
 * 
 * For example, the following two linked lists:
 * 
 * 
 * begin to intersect at node c1.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA =
 * 2, skipB = 3
 * Output: Reference of the node with value = 8
 * Input Explanation: The intersected node's value is 8 (note that this must
 * not be 0 if the two lists intersect). From the head of A, it reads as
 * [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2
 * nodes before the intersected node in A; There are 3 nodes before the
 * intersected node in B.
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3,
 * skipB = 1
 * Output: Reference of the node with value = 2
 * Input Explanation: The intersected node's value is 2 (note that this must
 * not be 0 if the two lists intersect). From the head of A, it reads as
 * [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes
 * before the intersected node in A; There are 1 node before the intersected
 * node in B.
 * 
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * 
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB =
 * 2
 * Output: null
 * Input Explanation: From the head of A, it reads as [2,6,4]. From the head of
 * B, it reads as [1,5]. Since the two lists do not intersect, intersectVal
 * must be 0, while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 * 
 * 
 * 
 * 
 * Notes:
 * 
 * 
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function
 * returns.
 * You may assume there are no cycles anywhere in the entire linked
 * structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      // 本题可以将两个链表的其中一个首尾相连成环，这样就成了典型的单链表是否有环
      // 以及寻找环入口的问题了
      //
      // 边界判断
      if (headA == null || headB == null) return null;

      // 构造环
      ListNode tailA = headA;
      while (tailA.next != null) tailA = tailA.next;
      tailA.next = headA;

      // 快慢指针
      ListNode runner = headB;
      ListNode walker = headB;

      while (walker != null && runner != null && runner.next != null) {
        walker = walker.next;
        runner = runner.next.next;
        // 快指针追上慢指针
        if (runner == walker) {
          ListNode node = headB;
          // 寻找环入口
          while (node != walker) {
            node = node.next;
            walker = walker.next;
          }

          // 解开环，还原链表结构
          tailA.next = null;
          return node;
        }
      }

      // 两链表不相交，依然解开环
      tailA.next = null;
      return null;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        
        //    |<------L1---->|<---C---->|
        // A: 1 -> 3 -> 5 -> 7 -> 9 -> 11
        //                    /       
        //                   /
        //     B: 2 -----> 4
        //        |<--L2-->|
        // A B各自出发，规定：每次各自都走一步，走到当前链表尾部后(为null)
        // 选择另一条链表的开头，然后把另外一条链表走一遍，到最后
        // A会位于原来B链表的结尾，B会位于原来A链表的结尾，如果两条链表有交集
        // 那么A链表的结尾和B链表的结尾是同一个位置（前面可能有很多相同的位置，比如上面的9和11
        // 所以肯定能相遇
        // 对上面的链表按照股则走如下
        //    |----------走完A链表--------------|----------走完B链表-------------|
        // A: 1 -> 3 -> 5 -> 7 -> 9 -> 11 -> null -> 2 -> 4 -> 7 -> 9 -> 11 -> null
        //
        //    |------走完B链表-----------|-----------------走完A链表-------------|
        // B: 2 -> 4 -> 7 -> 9 -> 11 -> null -> 1 -> 3 -> 5 -> 7 -> 9 -> 11 -> null

        // 对于不相交的链表有如
        // A: 1
        // B: 2 -> 3
        // 那么A的走法为
        //    |--A---|------B---------|
        // A: 1 -> null -> 2 -> 3 -> null
        // B的走法为
        //    |----B-----|-------A----|
        // B: 2 -> 3 -> null -> 1 -> null
        // 最后都会为null的啦
        ListNode node1 = headA;
        ListNode node2 = headB;
        
        while (node1 != node2) {
            node1 = node1 == null ? headB : node1.next;
            node2 = node2 == null ? headA : node2.next;
        }
        
        return node1;
    }
}
