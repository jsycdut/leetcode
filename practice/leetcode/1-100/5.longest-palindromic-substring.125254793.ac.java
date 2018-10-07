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
 * assume that the pLengthimum length of s is 1000.
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
    private int index;
    private int pLength;
    public String longestPalindrome(String s) {
	    for(int i = 0; i <s.length(); i++){
		extendFromCenter(s, i, i);
		extendFromCenter(s, i, i + 1);
	    }
	    return s.substring(index, index + pLength);
    }
    public void extendFromCenter(String s, int i, int j){
	    if(i < 0 || j >= s.length() || s.charAt(i) != s.charAt(j)){
		    return ;
	    }
	    while(i >= 0 && j < s.length()){
		    if(s.charAt(i) == s.charAt(j)){
			    index = j - i + 1 > pLength ? i : index;
			    pLength = j - i + 1 > pLength ? j - i + 1 : pLength;
			    i--;
			    j++;
		    }else{
			    break;
		    }
	    }

    }
}
