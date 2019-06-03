/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
 *
 * https://leetcode.com/problems/reverse-linked-list/description/
 *
 * algorithms
 * Easy (52.66%)
 * Total Accepted:    515.7K
 * Total Submissions: 978.7K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * Reverse a singly linked list.
 *
 * Example:
 *
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 *
 *
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you
 * implement both?
 *
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
      // 递归的神仙做法，我喜欢
      if (head == null || head.next == null) return head;

      ListNode newHead = reverseList(head.next);

      head.next.next = head;
      head.next = null;

      return newHead;
    }
    // 常规做法，迭代反转链表
    // public ListNode reverseList(ListNode head) {
    //     if (head == null) {
    //         return null;
    //     }
    //
    //     ListNode prev = null;
    //     ListNode bridge = head;
    //
    //     while (head != null) {
    //         bridge = head;
    //         head = head.next;
    //         bridge.next = prev;
    //         prev = bridge;
    //     }

    //     return prev;
    //
    // }
}


