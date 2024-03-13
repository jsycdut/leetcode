class Solution {
    public String maximumOddBinaryNumber(String s) {
        char[] arr = s.toCharArray();
        int n1 = 0;// 有多少个1
        int n0 = 0; // 有多少个0
        for (char c : arr) {
            if (c == '1') {
                n1++;
            } else {
                n0++;
            }
        }

        String ans = "";
        for (int i = 0; i < n1 - 1; i++)
            ans += "1";
        for (int i = 0; i < n0; i++)
            ans += "0";
        ans += "1";
        return ans;

    }
}
