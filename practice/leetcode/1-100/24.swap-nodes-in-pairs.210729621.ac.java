/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 *
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (43.06%)
 * Total Accepted:    279.9K
 * Total Submissions: 649.9K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 *
 *
 *
 * Example:
 *
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
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
    public ListNode swapPairs(ListNode head) {
	// 边界检查
	if (head == null || head.next == null) {
	    return head;
	}
	// 由于交换时两两一组
	// 每组之间就要用胶水粘起来，否则就会出现断点的情况
	// 比如 1 2 3 4，处理3 4时，有2->1->3，然后3 4交换后4->3, 3->null，虽然4->3，但是没有任何点连着4
	// 此时为2->1->3->null, 同时4->3，所以要用pre补这个缺
	// dummy用于保存交换链子开头两个节点后的头结点
        ListNode dummy = new ListNode(-1);
	ListNode pre = new ListNode(0);
        ListNode newHead = null;
	while (head != null && head.next != null) { // 当前节点存在且下一个节点存在，才有交换的意义
	    newHead = head.next;
	    pre.next = newHead;
	    head.next = newHead.next;
	    newHead.next = head;
	    pre = head;

	    if (dummy.next == null) { // 处理头两个节点交换，将此时的链子头结点保存在dummy的next中
	        dummy.next = newHead;
	    }
	    if (head.next != null) { // head此时已经调位成功，只有下一个节点存在，才有必要继续处理
	        head = head.next;
	    }
	}
	return dummy.next;
    }
}

