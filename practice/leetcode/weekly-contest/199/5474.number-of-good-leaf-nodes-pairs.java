/**
 * leetcode-cn第199周周赛第3题
 * https://leetcode-cn.com/problems/number-of-good-leaf-nodes-pairs/
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
    // 本题本想标记所有节点的高度，然后通过lca找出最近公共祖先然后求出叶子节点间的路径长度
    // 主要是通过递归求lca复杂度高，所以会T
    // 赛后看了题解发现可以标记根节点到所有节点的路径，就像链表一样
    // 然后找lca就很方便了
    public int countPairs(TreeNode root, int distance) {
        if (root == null || distance < 2) return 0;
        
        List<TreeNode> leaves = new ArrayList<>();
        
        Map<TreeNode, String> pathTracks = new HashMap<>();
        pathTracks.put(root, "");
        
        // 常规层次遍历，找出叶子节点，并且给顶点到所有顶点标记路径
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                String footprint = pathTracks.get(node);
                
                // 继续遍历的同时标记路径
                if (node.left != null) {
                    queue.offer(node.left);
                    pathTracks.put(node.left, footprint + "0");
                }
                
                if (node.right != null) {
                    queue.offer(node.right);
                    pathTracks.put(node.right, footprint + "1");
                }
                
                // 叶子节点
                if (node.left == null && node.right == null) leaves.add(node);
            }
        }
        
        // 遍历所有的叶子节点点对，将其从根节点到自身的路径记录进行比较
        // 思路大致就是lca的链表共同长度标记
        int ans = 0;
        for (int i = 0; i < leaves.size(); i++) {
            for (int j = i + 1; j < leaves.size(); j++) {
                TreeNode leaf1 = leaves.get(i);
                TreeNode leaf2 = leaves.get(j);
                String pathTrack1 = pathTracks.get(leaf1);
                String pathTrack2 = pathTracks.get(leaf2);
                
                int fullLength = pathTrack1.length() + pathTrack2.length();
                int commonLength = 0;
                for (int k = 0; k < pathTrack1.length() && k < pathTrack2.length(); k++) {
                    if (pathTrack1.charAt(k) == pathTrack2.charAt(k)) {
                        commonLength += 2;
                    } else {
                        break;
                    }
                }
                
                if (fullLength - commonLength <= distance) ans++;
            }
        }
        
        return ans;
    }
}
