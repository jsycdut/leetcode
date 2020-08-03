/**
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/submissions/
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
    public List<Integer> preorder(Node root) {
        if (root == null) return Collections.emptyList();
        
        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        List<Integer> ans = new ArrayList<>();
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            ans.add(node.val);
            int index = node.children.size() - 1;
            while (index >= 0) {
                stack.push(node.children.get(index--));
            }
        }
        
        return ans;
    }
}
