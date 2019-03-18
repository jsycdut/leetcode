/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 *
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (46.11%)
 * Total Accepted:    526.3K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
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
    // easy one, there is no need to explain...
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode res = new ListNode(-1);
            ListNode head = res;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    res.next = l1;
                    l1 = l1.next;
                } else {
                    res.next = l2;
                    l2 = l2.next;
                }
                res = res.next;
            }

            // a small trick
            if (l1 == null) l1 = l2;

            while (l1 != null) {
                res.next = l1;
                l1 = l1.next;
                res = res.next;
            }

            return head.next;
    }
}

