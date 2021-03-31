/**
 * https://leetcode-cn.com/problems/subsets-ii/
 * https://leetcode-cn.com/problems/subsets-ii/solution/zi-ji-ii-by-leetcode-solution-7inq/
 */
class Solution {
  List<List<Integer>> ans;
  List<Integer> temp;
  int[] array;
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    if (nums == null || nums.length == 0) return Collections.emptyList();
    ans = new ArrayList<>();
    temp = new ArrayList<>();
    array = nums;
    Arrays.sort(array);
    traverse(false, 0);
    return ans;
  }

  /**
   * 核心思路：排序后，如果相邻两个元素值相同，并且没有选择前一个元素
   * 那么必定会造成重复，因为前一个元素在在最终遍历完成之前，肯定会被选中
   */
  void traverse(boolean choosePrevious, int step) {
    if (step == array.length) {
      ans.add(new ArrayList<>(temp));
      return;
    }

    traverse(false, step + 1);

    int index = temp.size();
    if (step - 1 >= 0 && array[step] == array[step - 1] && !choosePrevious) return;
    temp.add(array[step]);
    traverse(true, step + 1);
    temp.remove(index);
  }
}
