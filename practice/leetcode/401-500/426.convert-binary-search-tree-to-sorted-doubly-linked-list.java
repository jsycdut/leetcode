/**
 * https://leetcode-cn.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    Node head = null;
    Node tail = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        tail.right = head;
        head.left = tail;
        return head;
    }

    void dfs(Node root) {
        if (root == null) return;
        dfs(root.left);
        if (head == null) head = root;
        if (tail != null) {
            tail.right = root;
            root.left = tail;
        }
        tail = root;
        dfs(root.right);
    }
}
