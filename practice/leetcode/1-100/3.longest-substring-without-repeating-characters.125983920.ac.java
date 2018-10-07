/*
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters
 *
 * algorithms
 * Medium (24.44%)
 * Total Accepted:    369K
 * Total Submissions: 1.5M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * Examples:
 * 
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the
 * answer must be a substring, "pwke" is a subsequence and not a substring.
 */
import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
	    int ans = 0, i = 0, j = 0;
	    HashSet<Character> set = new HashSet<>();
	    int k  = s.length();
	    while(i < k && j < k){
		    if(!set.contains(s.charAt(j))){
			    set.add(s.charAt(j++));
			    ans = Math.max(ans, set.size());
		    }else{
			    set.remove(s.charAt(i++));
		    }
	    }
	    return ans;
    }
}
