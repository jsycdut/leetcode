/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 *
 * https://leetcode.com/problems/combination-sum/description/
 *
 * algorithms
 * Medium (49.43%)
 * Total Accepted:    372.8K
 * Total Submissions: 747.6K
 * Testcase Example:  '[2,3,6,7]\n7'
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a
 * target number (target), find all unique combinations in candidates where the
 * candidate numbers sums to target.
 * 
 * The same repeated number may be chosen from candidates unlimited number of
 * times.
 * 
 * Note:
 * 
 * 
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * ⁠ [7],
 * ⁠ [2,2,3]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
      // List<List<Integer>> result = new ArrayList<List<Integer>>();
      // 没必要写成上面那样，因为Java 7可以自动类型推断
      List<List<Integer>> result = new ArrayList<>();

      List<Integer> recorder = new ArrayList<>();

      Arrays.sort(candidates);
      dfs(candidates, target, 0, recorder, result);

      return result;
    }

    void dfs(int[] candidates, int target, int step, List<Integer> recorder, List<List<Integer>> result) {
      if (target == 0) {
        // result.add(new ArrayList<Integer>(recorder));
	// 也没必要写成上面那样，因为recorder自己有类型信息，Java 7依然可以推断
	
        result.add(new ArrayList<>(recorder));
	return;
      }

      // step代表递归深度，在这里是数组的长度
      // 当前深度可以使用该数字0-N次，下面看起来是使用了1-N次
      // 但是由于add和remove的使用，导致最后在本轮进入下一轮的最后一次时
      // add和remvoe次数相等，等于使用当前数字0次
      for (int i = step; i < candidates.length; i++) {
	if (candidates[i] > target) return;
        recorder.add(candidates[i]);
        dfs(candidates, target - candidates[i], i, recorder, result);
        recorder.remove(recorder.lastIndexOf(candidates[i]));
      }
    }
}

/**
 * solution in 2021
 */
class Solution2 {
  // 使用全局变量，来减少递归时带的参数个数
  LinkedList<Integer> temp;
  List<List<Integer>> ans;
  int[] array;

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    if (candidates == null || candidates.length == 0) 
        return Collections.emptyList();

    array = candidates;
    temp = new LinkedList<>();
    ans = new ArrayList<>();

    traverse(0, 0, target);
    return ans;
  }

  void traverse(int step, int sum, int target) {

    if (step == array.length || sum > target) return;
    if (sum == target) {
      ans.add(new ArrayList<>(temp));
      return;
    }

    // 使用LinkedList直接访问链表的最后一个元素
    traverse(step + 1, sum, target);
    temp.addLast(array[step]);
    traverse(step, sum + array[step], target);
    temp.removeLast();
  }
}
