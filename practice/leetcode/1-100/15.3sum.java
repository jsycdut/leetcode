/**
 * https://leetcode-cn.com/problems/3sum/solution/san-shu-zhi-he-by-leetcode-solution/
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();
        
        List<List<Integer>> ans = new ArrayList<>();
        
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int target = 0 - nums[i];
            
            int lo = i + 1;
            int hi = len - 1;
            while (lo < hi) {
                while (lo < hi && nums[lo] + nums[hi] < target) lo++;
                while (lo < hi && nums[lo] + nums[hi] > target) hi--;
                
                if (lo < hi && nums[lo] + nums[hi] == target) {j
                    ans.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while (++lo < hi && nums[lo] == nums[lo - 1]);
                    while (--hi > lo && nums[hi] == nums[hi + 1]);
                }
            }
        }
        
        return ans;
    }
}
