/*
 * [1] Two Sum
 *
 * https://leetcode.com/problems/two-sum
 *
 * algorithms
 * Easy (35.65%)
 * Total Accepted:    662.2K
 * Total Submissions: 1.9M
 * Testcase Example:  '[3,2,4]\n6'
 *
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * 
 * Example:
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 
 * 
 */

import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
       Map<Integer, Integer> map = new HashMap<>();
       int[] ans = {0, 0};
       int i = 0;
       int length = nums.length;
       while(i < length){
	       if(map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i){
		       ans[0] = i;
		       ans[1] = map.get(target - nums[i]);
               	       return ans;
	       }else{
               map.put(nums[i], i);
               i++;
           }
       }
        return ans;
    }
}
