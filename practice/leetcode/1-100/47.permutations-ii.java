/**
 * https://leetcode-cn.com/problems/permutations-ii/
 */
class Solution {
    boolean[] visited;
    int[] array;
    List<List<Integer>> ans;
    LinkedList<Integer> holder;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();
        int len = nums.length;
        visited = new boolean[len];
        array = nums;
        Arrays.sort(array);
        ans = new ArrayList<>();
        holder = new LinkedList<>();
        recur();
        return ans;
    }

    void recur() {
        if (holder.size() == array.length){
            ans.add(new ArrayList<>(holder));
            return;
        }

        for (int i = 0; i < array.length; i++) {
            if (!visited[i]){
                if (i - 1 >= 0 && array[i - 1] == array[i] && !visited[i - 1])
		            continue;
                visited[i] = true;
                holder.addLast(array[i]);
                recur();
                holder.removeLast();
                visited[i] = false;
            }
        }
    }
}
