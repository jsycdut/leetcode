class Solution {

    public int titleToNumber(String columnTitle) {
        // 26进制
        // 'A' - 'A' + 1
        char[] arr = columnTitle.toCharArray();
        int ans = 0;
        for (char c : arr) {
            ans = ans * 26 + c - 'A' + 1;
        }
        return ans;
    }
}
