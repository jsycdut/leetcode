/**
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
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
    int sum = 0;
    // 1ms
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return root;

        // BST的中序遍历是升序的，即左 -> 中 -> 右 升序
        // 这里反向访问，右 -> 中 -> 左就是降序的
        // 把值叠加起来赋值给当前节点就可以了
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);

        return root;
    }

    // 166ms
    public TreeNode convertBST2(TreeNode root) {
        if (root == null) return null;

        LinkedList<Integer> list = new LinkedList<>();
        visit(root, list);
        for (int i = list.size() - 2; i >= 0; i--) {
            list.set(i, list.get(i) + list.get(i + 1));
        }
        rebuild(root, list);
        return root;
    }

    void visit(TreeNode root, LinkedList<Integer> list) {
        if (root == null) return;
        visit(root.left, list);
        list.addLast(root.val);
        visit(root.right, list);
    }

    void rebuild(TreeNode root, LinkedList<Integer> list) {
        if (root == null) return;
        rebuild(root.left, list);
        root.val = list.removeFirst();
        rebuild(root.right, list);
    }
}
