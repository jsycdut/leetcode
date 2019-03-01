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
        // 边界检查 
        if (head == null) {
            return null;
        }
        
        // 只需两个节点就可以完成反转链表
        // so easy
        ListNode prev = null;
        ListNode bridge = head;
        
        while (head != null) {
            bridge = head;
            head = head.next;
            bridge.next = prev;
            prev = bridge;
        }

        return prev;
        
    }
}

