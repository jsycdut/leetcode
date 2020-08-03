/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * 2015年，Homebrew作者Max Howell面试谷歌，来到了第七轮，碰到了此题没做出来结果被拒
 * 然后就有了经典的推文 
 *
 * Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so fuck off.
 *
 * 链接：https://twitter.com/mxcl/status/608682016205344768
 * 此推文引起了不小的轰动和争议，外界对谷歌拒绝Max Howell的原因也是众说纷纭，
 * 直到两年之后的2017年Max Howell在Quora上正面回应此推文
 *
 * https://www.quora.com/Whats-the-logic-behind-Google-rejecting-Max-Howell-the-author-of-Homebrew-for-not-being-able-to-invert-a-binary-tree
 *
 */
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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        
        // swap
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        // apply to children, no need to care about the return value, cause we need the root itself
        invertTree(root.left);
        invertTree(root.right);
        
        // just return root itself
        return root;
    }
}
