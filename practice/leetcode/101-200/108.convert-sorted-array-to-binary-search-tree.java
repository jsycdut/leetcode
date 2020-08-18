/**
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return dac(nums, 0, nums.length - 1);
    }

    TreeNode dac(int[] nums, int l, int r) {
        if (l > r) return null;
        int mid = (l + r) >>> 1;
        int val = nums[mid];
        TreeNode left = dac(nums, l, mid - 1);
        TreeNode right = dac(nums, mid + 1, r);
        return new TreeNode(val, left, right);
    }
}
