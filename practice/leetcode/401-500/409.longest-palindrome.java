class Solution {
    public int longestPalindrome(String s) {
        int[] a = new int[26];
        int[] A = new int[26];
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (c - 'a' >= 0) {
                a[c - 'a']++;
            } else {
                A[c - 'A']++;
            }
        }

        int ans = 0;
        int left = 0;
        for (int i : a) {
            int t = i / 2;
            ans += t;
            left += (i - 2 * t);
        }
        for (int i : A) {
            int t = i / 2;
            ans += t;
            left += (i - 2 * t);
        }
        return left == 0 ? ans * 2 : ans * 2 + 1;
    }
}
