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
	// Runtime: 5 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
        // Memory Usage: 38.1 MB, less than 10.44% of Java online submissions for Remove Nth Node From End of List.
        while (n-- > 0){
            q = q.next;
        }
        if (q == null){
            head = head.next;
            return head;
        }
        while(q != null && q.next != null){
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return head;
    }
}
