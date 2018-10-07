class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1){
            return 0;
        }
        int len = prices.length;
        int minValue = prices[0];
        int maxValue = prices[len - 1];
        int[] asc = new int[len];
        int[] desc = new int[len];
        int ascMax = 0;
        for(int i = 0; i < len; i++){
            minValue = Math.min(minValue, prices[i]);
            asc[i] = Math.max(ascMax, prices[i] - minValue);
            ascMax = Math.max(ascMax, asc[i]);
        }
        int descMax = 0;
        for(int i = len - 2; i > 0; i--){
            maxValue = Math.max(prices[i + 1], maxValue);
            desc[i] = Math.max(descMax, maxValue - prices[i + 1]);
            descMax = Math.max(descMax, desc[i]);
        }
        int ans = 0;
        for(int i = 0; i < len; i++){
            ans = Math.max(ans, asc[i] + desc[i]);
        }
        return ans;
    }
}