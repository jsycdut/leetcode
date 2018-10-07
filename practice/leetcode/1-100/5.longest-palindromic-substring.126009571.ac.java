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
	    StringBuilder sb = new StringBuilder("^#");
	    for(int i = 0; i < s.length(); i++){
		    sb.append(s.charAt(i));
		    sb.append("#");
	    }
	    sb.append("$");
	    int len = sb.length();
	    int[] manacher = new int[len];
	    int middlePointer = 0, rightPointer = 0, maxPointer = 0;
	    for(int i = 1; i < len - 1; i++){
		    manacher[i] = i < rightPointer ? Math.min(rightPointer - i, manacher[2 * middlePointer - i]) : 1;
		    while(sb.charAt(i - manacher[i]) == sb.charAt(i + manacher[i])){
			    manacher[i] += 1;
		    }
		    if( i + manacher[i] > rightPointer ){
			    rightPointer = i + manacher[i];
			    middlePointer = i;
		    }
		    maxPointer = manacher[i] > manacher[maxPointer]? i : maxPointer;
	    }

	    int realLength = manacher[maxPointer] - 1;
	    int start = (maxPointer - manacher[maxPointer]) / 2;
	    return s.substring(start, start + realLength);
    }
}
