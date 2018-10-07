public class Solution {
    /*
     * @param A: A string
     * @param B: A string
     * @return: The length of longest common subsequence of A and B
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if(A == null || B == null || A.length() == 0 || B.length() == 0){
            return 0;
        }
        int m = A.length();
        int n = B.length();
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            if(A.charAt(i) == B.charAt(0)){
                dp[i][0] = 1;
            }else{
                dp[i][0] = 0;
            }
        }
        for(int j = 0; j < n; j++){
            if(B.charAt(j) == A.charAt(0)){
                dp[0][j] = 1;
            }else{
                dp[0][j] = 0;
            }
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(A.charAt(i) == B.charAt(j)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m-1][n-1];
    }
}