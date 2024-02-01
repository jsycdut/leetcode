class Solution {
    public void sortColors(int[] nums) {
        // 统计排序
        int[] cnt = new int[3];
        for(int i : nums) {
            cnt[i]++;
        }

        int idx = 0;
        for(int i = 0; i < 3; i++){
            while (cnt[i]-- > 0){
                nums[idx++] = i;
            }
        }
    }
}
