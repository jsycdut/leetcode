/**
 * https://leetcode-cn.com/problems/subsets/
 */

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums){
        dfs(0, nums);
        return ans;
    }
    
    void dfs(int currentStep, int[] nums) {
        if (currentStep == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        dfs(currentStep + 1, nums);
        int index = temp.size();
        temp.add(nums[currentStep]);
        dfs(currentStep + 1, nums);
        temp.remove(index);
    }
}
