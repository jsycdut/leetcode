/**
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }
    
    void dfs(Node root, List<Integer> list) {
        if (root == null) return;
        for (Node node : root.children) {
            dfs(node, list);
        }
        list.add(root.val);
    }
}
