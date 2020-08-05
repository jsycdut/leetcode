/**
 * 打家劫舍I: https://leetcode-cn.com/problems/house-robber
 * 打家劫舍II: https://leetcode-cn.com/problems/house-robber-ii/
 * 打家劫舍III： https://leetcode-cn.com/problems/house-robber-iii/
 *
 * 本题为打家劫舍的第3题，其实就是一个后序遍历，从左右子节点到根节点走一遍
 * 每个节点分两种情况记录其最大得分（抢到的钱），即抢当前节点可以获得到的最大值，
 * 和不抢当前节点获得的最大值，使用HashMap记录每个节点在两种情况下的最大得分，然后
 * 递归走到根节点就完事了
 *
 * 如果抢当前节点，那么只能是当前节点的值 + 两个子节点都是不抢的情况下两者值之和
 * 如果不抢当前节点，那么直接就是左右子节点在各自抢或者不抢情况下的最大值之和
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
    Map<TreeNode, Integer> robbed = new HashMap<>();
    Map<TreeNode, Integer> unRobbed = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) return 0;

        dfs(root);
        return Math.max(robbed.get(root), unRobbed.get(root));
    }

    void dfs(TreeNode root) {
        if (root == null) return;
        
        dfs(root.left);
        dfs(root.right);

        int robbedLeft = robbed.getOrDefault(root.left, 0);
        int robbedRight = robbed.getOrDefault(root.right, 0);
        int unRobbedLeft = unRobbed.getOrDefault(root.left, 0);
        int unRobbedRight = unRobbed.getOrDefault(root.right, 0);

        robbed.put(root, root.val + unRobbedLeft + unRobbedRight);
        unRobbed.put(root, Math.max(robbedLeft, unRobbedLeft) + Math.max(robbedRight, unRobbedRight));
    }
}
