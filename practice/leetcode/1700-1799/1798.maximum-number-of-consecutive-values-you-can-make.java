class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        // 左闭右开区间[0, r)
        // 代表我能造出[0....r-1]里面的所有值
        int r = 1;
        for (int coin : coins) {
            // 可以被我吞并，造出更大的值
            // 这个值比我右区间端点小，可以和我区间里面的其他所有值结合，造出更多连续的值
            // 新的右端点区间是[0+coin, r+coin]，由于r肯定大于0，所以新的右端点是r + coin
            if (coin <= r) {
                r += coin;
            } else {
                // 我现在的连续区间是[0, r)，新出现的值coin比r还大，空洞出现了
                // 出现了空洞了，不连续了，返回此时的r
                return r;
            }
        }

        return r;
    }
}
