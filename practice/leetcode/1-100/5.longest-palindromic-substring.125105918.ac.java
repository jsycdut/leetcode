/*
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring
 *
 * algorithms
 * Medium (25.32%)
 * Total Accepted:    247.9K
 * Total Submissions: 979.2K
 * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 * 
 * Example:
 * 
 * Input: "babad"
 * 
 * Output: "bab"
 * 
 * Note: "aba" is also a valid answer.
 * 
 * 
 * 
 * Example:
 * 
 * Input: "cbbd"
 * 
 * Output: "bb"
 * 
 * 
 */
class Solution {
    public String longestPalindrome(String s) {
	    int length = s.length();
	    int cache = 0;
	    int max = 0;
	    int x = 0;
	    boolean[][] dp = new boolean[length][length];
	    for(int i = 0; i < length; i++){
		    dp[i][i] = true;
		    for(int j = i + 1; j < length; j++){
			    if(s.charAt(i) == s.charAt(j)){
				    dp[i][j] = true;
			    }else{
				    break;
			    }
		    }
	    }
	    for(int i = length - 1; i >=  0; i--){
		    for(int j = i; j < length; j++){
			    if(dp[i][j]){
				cache = j - i + 1;
				if(cache > max){
					max = cache;
					x = i;
				}
			    }else if(dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)){
				    dp[i][j] = true;
				    cache = j - i + 1;
				    if(cache > max){
					    max = cache;
					    x = i;
				    }
			    }
		    }
	    }

	return s.substring(x, x + max);
        
    }
}
