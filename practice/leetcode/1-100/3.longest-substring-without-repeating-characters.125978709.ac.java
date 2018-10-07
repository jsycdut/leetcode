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
import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
	HashMap<Character, Integer> map = new HashMap<>();
	int ans = 0;
	for(int i = 0; i < s.length(); i++ ){
		for(int j = i; j < s.length(); j++){
			if(!map.containsKey(s.charAt(j))){
				map.put(s.charAt(j), 0);
				if(j == s.length() - 1){
					ans = Math.max(ans, j - i + 1);
					i = j;
					break;
				}
			}else{
				ans = Math.max(ans, j - i);
				map.clear();
				break;
			}

		}
	}
	return ans;
    }
}
