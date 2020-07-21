/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/ 
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
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) return Collections.emptyList();
        
        return generate(1, n);
    }
    
    List<TreeNode> generate(int start, int end) {
        List<TreeNode> ans = new LinkedList<>();
        if (start > end) {
            ans.add(null);
            return ans;
        }
        
        for (int root = start; root <= end; root++) {
            List<TreeNode> leftTrees = generate(start, root - 1);
            List<TreeNode> rightTrees = generate(root + 1, end);
            
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode current = new TreeNode(root);
                    current.left = leftTree;
                    current.right = rightTree;
                    ans.add(current);
                }
            }
        }
        
        return ans;
    }
}
