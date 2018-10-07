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
	/*
	 *this is what we called manacher algorithm
	 *it costs time complexity O(n)
	 *it takes 3 steps
	 *1. add special character to the original string to make it  easy to be searched as palindorme
	 *2. construct an array to store the distance of each palindormic substring, based on each character in the string processed by step 1
	 *3. the longest substring in the original string equals the biggest number of the array produced by step2
	 *then you need to restore the position and the palindromic substring length
	 *over.
	 */
    public String longestPalindrome(String s) {
	    if(s == null || s.length() < 2){
		    return s;
	    }
	    StringBuilder sb = new StringBuilder("^#");
	    for(int i = 0; i < s.length(); i++){
		    sb.append(s.charAt(i));
		    sb.append("#");
	    }
	    sb.append("$");
    	    int length = sb.length();
	    int[] manacher = new int[length];
	    int core = 0;
	    int dis = 0;
	    int middlePointer = 0;
	    int rightPointer = 0;
	    for(int i = 1; i < length - 1; i++){
		    manacher[i] = i > rightPointer ? 1 : Math.min(manacher[2 * middlePointer - i], rightPointer - i);
		    while(sb.charAt(i - manacher[i]) == sb.charAt(i + manacher[i])){
			    manacher[i] += 1;
		    }
		    if(i + manacher[i] > rightPointer){
			    rightPointer = i + manacher[i];
			    middlePointer = i;
		    }
		    //根本没有必要维护两个变量，只需要维护一个core即可，dis肯定是manacher[core]
		    core = manacher[i] > dis ? i : core;
		    dis = manacher[i] > dis ? manacher[i] : dis;
	    }
	    int realLength = dis - 1;
	    int start = core - dis + 2;
	    int realStart = start / 2 - 1;
	    return s.substring(realStart, realStart + realLength);
    }
}
