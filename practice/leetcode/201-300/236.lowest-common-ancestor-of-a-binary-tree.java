/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;

        // 后续遍历处理，从叶子节点或者p或者q进行处理
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        if (l != null && r != null) {
            return root;
        } else if (l != null) {
            return l;
        } else if (r != null) {
            return r;
        } else {
            return null;
        }
    }
}

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
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // a b

        f(root, p, q);
        return ans;
         
    }

    boolean f(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null) return false;
        // 自底向上的查找，那么找到的第一个就是lca的结果
        boolean l= f(node.left, p, q);
        boolean r = f(node.right, p, q);
        // 左子树找到了，右子树也找到了，就是他了
        if (l && r) ans = node;

        // 当前节点就是其中pq中的一个，然后子树里面找到了另一个，就是他了
        if ((node.val == p.val || node.val == q.val) && (l || r)) ans = node;
        // 上面的两行if为什么不会覆盖结果？因为if里面的条件肯定是不能满足

        // 向上传递结果，如果当前节点是p或者q，或者子树里面是否有p或者q
        return node.val == p.val || node.val == q.val || l || r;
    }
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 根到节点的路径，做成链表，前面的N个肯定是相同的，离根最远的那个节点就是lca
        List<TreeNode> a = new ArrayList<>();
        find(root, p, a);
        List<TreeNode> b = new ArrayList<>();
        find(root, q, b);
        for (TreeNode t : a)
            System.out.println(t.val);
        for (TreeNode t : b)
            System.out.println(t.val);
        TreeNode ans = null;
        for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
            if (a.get(i) != b.get(i))
                break;
            ans = a.get(i);
        }

        return ans;
    }

    boolean find(TreeNode root, TreeNode p, List<TreeNode> path ) {
        path.add(root);
        if (root == p) return true;
        if (root.left != null) {
            boolean b = find(root.left, p, path);
            if (!b) {
                path.remove(path.size() - 1) ;
            } else {
                return true;
            };
        }

        if (root.right != null) {
            boolean b = find(root.right, p, path)   ;
            if (!b) {
                path.remove(path.size() - 1) ;
            } else {
                return true;
            };
        }

//      path.remove(path.size() - 1);
//        int  last = path.size() - 1;
//        if (last >= 0 && path.get(last) == p) path.remove(path.last)
        return false;

    }
}
