/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 *
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (46.12%)
 * Total Accepted:    526.9K
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
    // recursive way to solve link list merge
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
	if (l2 == null) return l1;
        ListNode res = sort(l1, l2);
	return res;
    }

    ListNode sort(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
	if (l2 == null) return l1;

	if (l1.val < l2.val) {
	    l1.next = sort(l1.next, l2);
	    return l1;
	}

	l2.next = sort(l2.next, l1);
	return l2;
    }
}

