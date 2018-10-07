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
        int sum = 0;
        int carry =0;
        ListNode head = null;
        ListNode p=null;
        while(l1!=null || l2!=null){
            int x = l1 != null?l1.val:0;
            int y = l2 != null?l2.val:0;
            sum = (x+y+carry) %10;
            carry = (x+y+carry)/10;
            if(p==null){
                p = new ListNode(sum);
                head = p;
            }else{
                p.next = new ListNode(sum);
                p = p.next;
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            
        }
        
        if(carry!=0){
            p.next = new ListNode(carry);
        }
        return head;
    }
}