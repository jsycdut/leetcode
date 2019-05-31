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
      // 思路：翻转数字 123 -> 321
      // 不断从x上取下最后一位，加上前面出现的权重
      // 最后比较结果和x是否相等，需要注意溢出
      //
      // 当然数组转字符串判断回文的做法也是可以的，不过没有翻转数字这么好

      // 负数不是回文
	    if(x < 0){
		    return false;
	    }
      
	    int t = x;
	    int res = 0;
      
	    while(t > 0){
        // 溢出检测， 如果会溢出，说明肯定不是回文
        // 因为原始数字肯定不是溢出的，回文肯定也不是溢出的
        // 注意乘10可能会出现溢出， 另外个位数加上去也会出现溢出， 比如2147483640 + 8就超过了Integer的最大值2147483647   
		    if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (t % 10) > (Integer.MAX_VALUE % 10))){
			    return false;
		    }

		    res = res * 10 + (t % 10);
		    t /= 10;
	    }
      
	    return res == x;
    }
}


