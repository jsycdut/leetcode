class Solution {
  LinkedList<Integer> temp;
  LinkedList<List<Integer>> ans;
  int[] array;

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    if (candidates == null || candidates.length == 0) return Collections.emptyList();
    temp = new LinkedList<>();
    ans = new LinkedList<>();
    array = candidates;
    Arrays.sort(array);

    traverse(false, 0, 0, target);
    return ans;
  }

  void traverse(boolean choosePrevious, int idx, int sum, int target) {
    if (sum == target) {
      ans.add(new LinkedList<>(temp));
      return;
    }
    
    if (idx == array.length || sum > target) return;

    traverse(false, idx + 1, sum, target);
    
    if (idx > 0 && array[idx] == array[idx - 1] && !choosePrevious) return;
    temp.addLast(array[idx]);
    traverse(true, idx + 1, sum + array[idx], target);
    temp.removeLast();

  }
}
