/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
 *
 * https://leetcode.com/problems/rotate-list/description/
 *
 * algorithms
 * Medium (26.86%)
 * Total Accepted:    185.8K
 * Total Submissions: 691.8K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given a linked list, rotate the list to the right by k places, where k is
 * non-negative.
 *
 * Example 1:
 *
 *
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 *
 *
 * Example 2:
 *
 *
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
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
    public ListNode rotateRight(ListNode head, int k) {
      // 边界判断, 仍然题目说了k为整数, 但是作为一名经常刷题的同学
      // 又怎么能忘记判断边界呢??
      if (head == null || head.next == null || k <= 0) return head;

      // 本题是要把倒数第k个开始到链表结尾的所有元素挂到链表的开头
      // 可以先找到倒数第k + 1个节点, 然后把该节点的next置为空
      // 然后把倒数第一个元素的next指向head, 这道题就完了, 其实就是
      // 变形的找链表的倒数第k个节点, 此时这个节点就是新的head
      // 不过这道题还有一个做法, 就是把倒数第一个节点指向第一个节点
      // 形成一个环, 此时这个倒数第一个节点再往前走count - (k % count)
      // 就是把链表旋转k个之后的末节点了
      // 不过感觉代码上来说, 第一种解法要少写点代码, 不过第二种思路更有趣
      ListNode end = head;
      int count = 1;

      while (end.next != null) {
        count++;
        end = end.next;
      }

      end.next = head;

      int distance = count - (k % count);

      int step = 0;
      while (step++ < distance) {
        end = end.next;
      }

      ListNode result = end.next;

      end.next = null;

      return result;
    }
}

