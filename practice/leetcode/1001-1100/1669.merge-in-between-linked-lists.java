/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode ans = list1;
        int idx = 0;
        while (idx < a - 1) {
            list1 = list1.next;
            idx++;
        }

        ListNode tail = list1;
        while (idx < b){
            list1 = list1.next;
            idx++;
        }
        ListNode tail2 = list1.next;
        tail.next = list2;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = tail2;

        return ans;
    }
}
