/**
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }
        
        for (int i = 0; i < numbers.length; i++) {
            if (map.get(target - numbers[i]) != null) {
                return new int[]{i + 1, map.get(target - numbers[i]) + 1};
            }
        }
        
        return new int[]{};
    }
}
