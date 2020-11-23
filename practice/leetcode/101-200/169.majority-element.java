/**
 *https://leetcode-cn.com/problems/majority-element/
 */
class Solution {

    // majority must be in the middle of the sorted array, no matter the length of 
    // the array is odd or even
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // divide and conqure
    public int majorityElement2(int[] nums) {
        return find(nums, 0, nums.length - 1);
    }
    
    int find(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return nums[lo];
        }
        
        int mid = (lo + hi) >>> 1;
        int lCandidate = find(nums, lo, mid);
        int rCandidate = find(nums, mid + 1, hi);
        
        if (lCandidate == rCandidate) return lCandidate;
        
        int lCandidateVotes = scan(nums, lCandidate, lo, mid);
        int rCandidateVotes = scan(nums, rCandidate, mid + 1, hi);
        return lCandidateVotes > rCandidateVotes ? lCandidate : rCandidate;
    }
    
    int scan(int[] nums, int target, int lo, int hi) {
        int cnt = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == target) cnt++;
        }
        
        return cnt;
    }
}
