class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int idx = 0;
        while (idx < n && nums[idx] < 0) {
            idx++;
        }
        int c = idx;
        while(idx < n && nums[idx]==0){
            idx++;
        }
        
        return Math.max(c, n - idx);
    }
}
