/*
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
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
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        dfs(map, root);
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        pq.addAll(map.entrySet());
        int max = -1;
        List<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            int value = entry.getValue();
            if (value >= max) {
                max = value;
                list.add(entry.getKey());
            } else {
                break;
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) ans[i] = list.get(i);
        return ans;
    }

    void dfs(Map<Integer, Integer> map, TreeNode root) {
        if (root == null) return;
        dfs(map, root.left);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        dfs(map, root.right);
    }
}
