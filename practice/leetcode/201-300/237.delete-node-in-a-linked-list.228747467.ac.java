/*
 * @lc app=leetcode id=237 lang=java
 *
 * [237] Delete Node in a Linked List
 *
 * https://leetcode.com/problems/delete-node-in-a-linked-list/description/
 *
 * algorithms
 * Easy (53.26%)
 * Total Accepted:    281.9K
 * Total Submissions: 529.2K
 * Testcase Example:  '[4,5,1,9]\n5'
 *
 * Write a function to delete a node (except the tail) in a singly linked list,
 * given only access to that node.
 * 
 * Given linked list -- head = [4,5,1,9], which looks like following:
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 * Explanation: You are given the second node with value 5, the linked list
 * should become 4 -> 1 -> 9 after calling your function.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [4,5,1,9], node = 1
 * Output: [4,5,9]
 * Explanation: You are given the third node with value 1, the linked list
 * should become 4 -> 5 -> 9 after calling your function.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The linked list will have at least two elements.
 * All of the nodes' values will be unique.
 * The given node will not be the tail and it will always be a valid node of
 * the linked list.
 * Do not return anything from your function.
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
    public void deleteNode(ListNode node) {
      // 解法I：很傻，我怎么会这么做呢？？？
      // 我为什么要去把后面的值都往前移动呢？
      // 解法II才是真正的做法啊
      //
      // ==========太傻了==================
      // 只给出链表中的某个节点，然后让删除这个节点
      // 一开始还真的看不懂，没有前驱，怎么删除当前节点？
      // 后来才想到从当前节点开始，把后面的值依次往前移动
      // 然后把倒数第二个节点的next置为null即可
      //  4 -> 5 -> 1 -> 9 -> null删除5这个节点，过程如下
      //  首先移动值
      //  4 -> 1 -> 9 -> 9 -> null
      //  然后将倒数第二个节点的next置为null
      //  4 -> 1 -> 9 -> null
      //  整体就完成了
      //  p就是倒数第二个节点
      //  这个删除性能有点难以接受啊
      // ListNode p = null;

      // while (node.next != null) {
      //   node.val = node.next.val;
      //   p = node;
      //   node = node.next;
      // }

      // p.next = null;
      
      // 解法II：正确的解法
      node.val = node.next.val;
      node.next = node.next.next;
    }
}

