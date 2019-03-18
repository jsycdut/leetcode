/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (33.28%)
 * Total Accepted:    351.7K
 * Total Submissions: 1.1M
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
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
    // NlogK solution, K 为数组的长度
    // N 为所有节点的长度
    // 其实这道题就是合并两个链表的延伸，只是将两个链表换成了n个链表
    // 解决思路就是将n个链表两两一组，然后合并，合并完了再合并
    // 这个过程看起来就像从二叉树的叶子节点不断往上，最终合并成树根的样子。
    //
    // 其实解决这道题还有一个损招，就是取出所有的节点中的数据
    // 扔到数组里面，排个序，然后再取出来，形成链表，不过这绝对是最损的招，不知道会不会OOME(Out of memory error)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
	return sort(lists, 0, lists.length - 1);
    }

    ListNode sort(ListNode[] lists, int lo, int hi) {
        if (lo >= hi) return lists[lo];
	int mid = (hi -lo) / 2 + lo;
	ListNode l1 = sort(lists, lo, mid);
	ListNode l2 = sort(lists, mid + 1, hi);
	return merge(l1, l2);
    }

    // 合并两个有序链表的递归写法
    ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
	if (l2 == null) return l1;
	
	if (l1.val < l2.val) {
	    l1.next = merge(l1.next, l2);
	    return l1;
	}

	l2.next = merge(l2.next, l1);
	return l2;
    }
}

