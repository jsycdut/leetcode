/*
 * @lc app=leetcode id=445 lang=java
 *
 * [445] Add Two Numbers II
 *
 * https://leetcode.com/problems/add-two-numbers-ii/description/
 *
 * algorithms
 * Medium (50.02%)
 * Total Accepted:    89.8K
 * Total Submissions: 179.4K
 * Testcase Example:  '[7,2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The most significant digit comes first and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the
 * lists is not allowed.
 * 
 * 
 * 
 * Example:
 * 
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 * 
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      // 题目说了不为空，但边界检查必不可少
      if (l1 == null) return l2;
      if (l2 == null) return l1;

      // 解法I：反转链表再相加，最朴素的思想
      // 注意最后可能有个进位，在不准更改链表结构的时候
      // 这种做法是无效的，面试的时候一定要问一下，能否更改链表结构
      ListNode newL1 = reverse(l1);
      ListNode newL2 = reverse(l2);

      ListNode result = null;
      ListNode helper = null;

      int carrier = 0;

      while (newL1 != null || newL2 != null) {
        int val1 = newL1 == null ? 0 : newL1.val;
        int val2 = newL2 == null ? 0 : newL2.val;

        int sum = val1 + val2 + carrier;
        carrier = sum / 10;

        sum = sum % 10;

        if (result == null) {
          result = new ListNode(sum);
          helper = result;
        } else {
          helper.next = new ListNode(sum);
          helper = helper.next;
        }

        newL1 = newL1 != null ? newL1.next : null;
        newL2 = newL2 != null ? newL2.next : null;
      }

      if (carrier != 0) {
        helper.next = new ListNode(carrier);
      }

      return reverse(result);
        
    }

    // 反转链表
    ListNode reverse(ListNode head) {
      ListNode prev = null;
      ListNode bridge = null;

      while (head != null) {
        bridge = head;
        head = head.next;
        bridge.next = prev;
        prev = bridge;
      }

      return prev;
    }
}

