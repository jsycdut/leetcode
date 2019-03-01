/*
 * 反转链表2代题目，反转链表中间的内容
 * 1代是从头转到尾，是个舔狗的故事
 * 不得不说，这个题要更有意思些
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
 *
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (34.00%)
 * Total Accepted:    178.7K
 * Total Submissions: 525.5K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * 
 * Example:
 * 
 * 
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
        // 边界条件判断，其实没有必要，因为题目说了1 ≤ m ≤ n ≤ length of list.
        if (head == null) {
            return null;
        }

        // 可以将链表分为三段式
        // head->*->*->||m->*->*->n->||*->*->end
        // head -> m - 1，要保留
        // n + 1 -> end，也要保留
        // m -> n，要反转
        // 然后将这三段缝起来
        ListNode cur = head;
        ListNode bridge = cur;
        ListNode prev = null;
        ListNode start = null;
        ListNode end = null;
        int pos = 1;
        
        while (pos <= n) {
            // 第一段，不用处理，往后跳就完事了
            if (pos < m - 1) {
                pos++;
                cur = cur.next;
                continue;
            }

            // 遇到第一段的结尾，让我们在奇拉比的尾巴上打上飞雷神标记
            if (pos == m - 1) {
                start = cur;
                cur = cur.next;
                end = cur;
                pos++;
                continue;
            }
            
            // 处理没有第一段的特殊情况，就是m=1的情况
            if (end == null) {
                end = cur;
            }

            // 第二部分进行反转
            bridge = cur;
            cur = cur.next;
            bridge.next = prev;
            prev = bridge;
            pos++;
        }

        // 将以end开头prev结尾的并且
        // 已经反转了的第二段和cur开头第三段连接起来（即使第三段为空，无所谓的）
        end.next = cur;

        // 这对应着m=1的那种没有第一段的情况，
        // 就是从开头就开始反转到某个位置
        // 此时就没有第一段，把第二段的开头返回就行了
        if (start == null) {
            return prev;
         }

        // 此时有第一段，把第一段和第二段连接起来，返回原来的head就行了
        start.next = prev;
        return head;
        
    }
}

