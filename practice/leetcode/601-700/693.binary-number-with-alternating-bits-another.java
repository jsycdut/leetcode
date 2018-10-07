/*
 * [693] Binary Number with Alternating Bits
 *
 * https://leetcode.com/problems/binary-number-with-alternating-bits
 *
 * algorithms
 * Easy (54.12%)
 * Total Accepted:    6.7K
 * Total Submissions: 12.3K
 * Testcase Example:  '5'
 *
 * Given a positive integer, check whether it has alternating bits: namely, if
 * two adjacent bits will always have different values.
 * 
 * Example 1:
 * 
 * Input: 5
 * Output: True
 * Explanation:
 * The binary representation of 5 is: 101
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 7
 * Output: False
 * Explanation:
 * The binary representation of 7 is: 111.
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: 11
 * Output: False
 * Explanation:
 * The binary representation of 11 is: 1011.
 * 
 * 
 * 
 * Example 4:
 * 
 * Input: 10
 * Output: True
 * Explanation:
 * The binary representation of 10 is: 1010.
 * 
 * 
 */
class Solution {
    public boolean hasAlternatingBits(int n) {
  	int[] a = new int[32];
	int mask = 1;
	int shift = 1;
	int position = 32;
	boolean flag = true;
	int i = 0;
	while(position != 0){
		a[--position] = n & mask;
		n >>>= shift;
	}
	while(i < 31){
		if(a[i] == a[i + 1]){
			i++;
		}else{
			break;
		}
	}
	while(i < 31){
		if(a[i] != a[i + 1]){
			i++;
		}else{
			flag  = false;
			break;
		}
	}
	return flag;
    }
}
