/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 *
 * https://leetcode.com/problems/permutations/description/
 *
 * algorithms
 * Medium (54.91%)
 * Total Accepted:    373.1K
 * Total Submissions: 679.4K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a collection of distinct integers, return all possible permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3]
 * Output:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
      // dfs写全排列，本应是手拿把攥
      // 但花了半个小时才AC，看来还是要多复习，多写写
      if (nums == null || nums.length == 0) return Collections.emptyList();        

      // 解法I：利用一个链表来保存每次dfs的结果
      // 当然也可以用一个数组来保存每个step的结果
      // 用数组就不存在像链表一样需要取出来的情况了
      // 因为直接把对应的值覆盖到上面数组上面就行了
      // List<List<Integer>> list = new ArrayList<>();
      // List<Integer> res = new ArrayList<>();
      // boolean[] visited = new boolean[nums.length];
      //
      // dfs(0, visited, nums, list, res);
      //
      // return list;
      //
      // ===================================================
      

      // 解法II：优化的DFS
      List<List<Integer>> list = new ArrayList<>();

      optimizedDFS(0, nums, list);
 
      return list;
    }

    // 全排列的本质是每个数依次和自己后面的数交换顺序
    // 注意是只和自己后面的数进行交换，所以必须i从step开始
    void optimizedDFS(int step, int[] arr, List<List<Integer>> list) {
      if (step == arr.length) {
        List<Integer> res = new ArrayList<>();
        for (int i : arr) res.add(i);
        list.add(new ArrayList(res));
        return;
      } 

      for (int i = step; i < arr.length; i++) {
        swap(arr, i, step);
        optimizedDFS(step + 1, arr, list);
        swap(arr, step, i);
      }
    }

    void swap(int[] arr, int i, int j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }

    // 要用的变量太多了，这种写法不够优雅，当然AC是没问题
    // 这种全排列的思想是，有n个数，我头一次取，有n种选择
    // 第二次取，有n-1种选择，选完n次，全排列就完成了
    // 所以要记录哪些是取了的，而且一次全排列取完之后要把数放回
    // 进行下一次的取数
    void dfs(int step, boolean[] visited, int[] arr, List<List<Integer>> list, List<Integer> res) {
      if (step == arr.length) {
        list.add(new ArrayList(res)); // 由于引用的原因，必须把res进行拷贝，否则最后全是空的
        return;
      }

      for (int i = 0; i < arr.length; i++) {
        if (!visited[i]) {
          res.add(arr[i]);
          visited[i] = true;
          dfs(step + 1, visited, arr, list, res);
          visited[i] = false;
          res.remove((Integer)arr[i]);
        }
      }
    }
}


