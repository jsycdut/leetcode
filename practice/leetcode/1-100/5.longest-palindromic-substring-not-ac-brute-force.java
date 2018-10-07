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
        if(s == null || s.length() == 0){
	    return "";
	}
	int length = s.length();
	int max = 0;
	int x = 0;
	int cache = 0;
	for(int m  = 0; m < length; m++){
		for(int n  = m; n < length; n++){
			if(validation(s, m, n)){
				cache = n - m + 1;
			}else{
				cache  = 0;
			}
			if(cache > max){
				max = cache;
				x = m;
			}
		}
	}	
	return s.substring(x, x + max);
    }

    public boolean validation(String s,int i, int j){
	    while(i < j){
		    if(s.charAt(i) == s.charAt(j)){
			    i++;
			    j--;
		    }else{
			    break;
		    }
	    }
	    return i >= j;
    }
}
