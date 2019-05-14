/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
 *
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * algorithms
 * Medium (33.96%)
 * Total Accepted:    352.1K
 * Total Submissions: 1M
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given a linked list, remove the n-th node from the end of list and return
 * its head.
 * 
 * Example:
 * 
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 * 
 * 
 * Note:
 * 
 * Given n will always be valid.
 * 
 * Follow up:
 * 
 * Could you do this in one pass?
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 输入条件检查
        if (n == 0 || head == null){
            return head;
        }
        
        ListNode p = head;
        ListNode q = p;
        
        // 鉴于题目说n有效，所以n最大值为链条长度
        // q直接往后拉开n个身位，p和q总共就n+1个节点
        // 保持阵型，p和q同时往链条尾端拉，直到q碰到链条最后一个节点
        // 此时q为倒数第一个节点，p就是倒数第n+1个节点
        // 直接p.next = p.next.next就删掉了倒数第n个节点
        // 注意，当n恰好为链条长度的时候，q在拉开完身位后就是null了
        // 此时该删除的就是传入的head节点，head = head.next并返回就行了

        // 拉开n个身位
        while (n-- > 0) {
            q = q.next;
        } 

        // 如果拉开n个身位后q已经为空，说明n大于等于链表长度
        // 删除第一个节点并返回
        if (q == null) {
            head = head.next;
            return head;
        }

        // 在拉开n个身位后每次都走一步
        // 直到q在链表结尾，此时p的next就是要删除的倒数第n个节点
        while (q != null && q.next != null) {
            p = p.next;
            q = q.next;
        }

        p.next = p.next.next;
        return head;
    }
}

