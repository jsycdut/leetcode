/**
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
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
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return Collections.emptyList();
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> ans = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                list.add(node.val);
                for (Node child : node.children) {
                    if (child != null) queue.offer(child);
                }
            }
            
            ans.add(list);
        }
        
        return ans;
    }
}
