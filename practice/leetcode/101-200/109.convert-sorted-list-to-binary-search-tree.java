/**
 * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return divideAndConquer(head, null);
    }

    TreeNode divideAndConquer(ListNode left, ListNode right) {
        if (left == right) return null;
        ListNode mid = findMiddle(left, right);
        TreeNode l = divideAndConquer(left, mid);
        TreeNode r = divideAndConquer(mid.next, right);
        return new TreeNode(mid.val, l, r);
    }

    ListNode findMiddle(ListNode left, ListNode right) {
        ListNode slow = left;
        ListNode fast = left;
        while (fast != right && fast.next != right) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
