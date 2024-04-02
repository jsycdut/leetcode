/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        if ((n & 1) == 0) {
            // 偶数个，没法凑齐
            return new ArrayList<>();
        }
        if (n == 1) {
            List<TreeNode> ans = new ArrayList<>();
            ans.add(new TreeNode(0));
            return ans;
        }

        List<TreeNode> ans = new ArrayList<>();
        for (int i = 1; i < n - 1; i += 2) {
            // 枚举左右子树的节点个数，注意由于题目限制，这里左右子树的节点数量的增长步长为2
            int l = i;
            // 这里减1是因为总节点个数为n，根节点占据1个，左右子树节点个数之和自然就是n-1了
            int r = n - 1 - i;
            List<TreeNode> ls = allPossibleFBT(l);
            List<TreeNode> rs = allPossibleFBT(r);
            // 组合，所有左右子树节点个数情况的笛卡尔积
            for (TreeNode l0 : ls) {
                for (TreeNode r0 : rs) {
                    TreeNode root = new TreeNode(0);
                    root.left = l0;
                    root.right = r0;
                    ans.add(root);
                }
            }
        }

        return ans;
    }
}
