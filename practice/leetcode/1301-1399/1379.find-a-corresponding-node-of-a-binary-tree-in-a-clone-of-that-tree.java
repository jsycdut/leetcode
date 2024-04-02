/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null || cloned == null || target == null) {
            return null;
        }

        if (target == original) {
            return cloned;
        }

        TreeNode l = getTargetCopy(original.left, cloned.left, target);
        if (l != null) {
            return l;
        }

        return getTargetCopy(original.right, cloned.right, target);
    }
}
