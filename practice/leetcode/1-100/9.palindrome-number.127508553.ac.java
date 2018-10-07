/*
 * [9] Palindrome Number
 *
 * https://leetcode.com/problems/palindrome-number
 *
 * algorithms
 * Easy (35.53%)
 * Total Accepted:    264.4K
 * Total Submissions: 743.9K
 * Testcase Example:  '-2147483648'
 *
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * click to show spoilers.
 * 
 * Some hints:
 * 
 * Could negative integers be palindromes? (ie, -1)
 * 
 * If you are thinking of converting the integer to string, note the
 * restriction of using extra space.
 * 
 * You could also try reversing an integer. However, if you have solved the
 * problem "Reverse Integer", you know that the reversed integer might
 * overflow. How would you handle such case?
 * 
 * There is a more generic way of solving this problem.
 * 
 * 
 */
class Solution {
    public boolean isPalindrome(int x) {
	    if(x < 0){
		    return false;
	    }
	    int t = x;
	    int res = 0;
	    while(t > 0){
		    if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < t % 10 )){
			    return false;
		    }
		    res = res * 10 + (t % 10);
		    t /= 10;
	    }
	    return res == x;
        
    }
}
