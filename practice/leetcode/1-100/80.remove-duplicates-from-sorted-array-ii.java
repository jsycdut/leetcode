/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
 */
class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) return 0;

    int i = 0;
    int j = 0;
    int index = 0;
    while (j < nums.length) {
      while (j < nums.length && nums[j] == nums[i]) j++;
      if ((j - i) >= 2) {
        nums[index] = nums[i];
        nums[index + 1] = nums[i];
        index += 2;
      } else {
        nums[index] = nums[i];
        index += 1;
      }

      i = j;
    }

    return index;
  }
}

