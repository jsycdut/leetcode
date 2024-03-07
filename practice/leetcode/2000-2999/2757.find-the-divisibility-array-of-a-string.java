class Solution {
    public int[] divisibilityArray(String word, int m) {
        int len = word.length();
        int[] ans = new int[len];
        // f(i) = (10 * f(i - 1) + s.charAt(i)) % m;
        long mod = 0;
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            mod = (10 * mod + c - '0' ) % m;
            if (mod == 0) {
                ans[i] = 1;
            }
        }

        return ans;

    }
}
