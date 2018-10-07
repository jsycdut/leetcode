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
class Solution {
    public int lengthOfLongestSubstring(String s) {
	    int ans = 0, i = 0, j = 0;
	    int k = s.length();
	    HashMap<Character, Integer> map = new HashMap<>();
	    while(i < k && j < k){
		    if(map.containsKey(s.charAt(j))){
			    i = Math.max(map.get(s.charAt(j)), i);
		    }
		    ans = Math.max(ans, j - i + 1);
		    map.put(s.charAt(j++), j);
	    }
	    return ans;


        
    }
}
