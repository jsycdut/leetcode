/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
 *
 * https://leetcode.com/problems/palindrome-linked-list/description/
 *
 * algorithms
 * Easy (35.99%)
 * Total Accepted:    258K
 * Total Submissions: 715.8K
 * Testcase Example:  '[1,2]'
 *
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2
 * Output: false
 * 
 * Example 2:
 * 
 * 
 * Input: 1->2->2->1
 * Output: true
 * 
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
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
    public boolean isPalindrome(ListNode head) {
        
        if(head == null){
            return true;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        
        ListNode pre = null;
        
        while(p2!= null && p2.next != null){
            p2= p2.next.next;
            ListNode temp = p1.next;
            p1.next = pre;
            pre = p1;
            p1 = temp;
        }
        if(p2 != null){
            p1 = p1.next;
        }
        
        while(pre != null){
            if(pre.val != p1.val){
                return false;
            }
            
            p1 = p1.next;
            pre = pre.next;
        }
        return true;
        
    }
}
