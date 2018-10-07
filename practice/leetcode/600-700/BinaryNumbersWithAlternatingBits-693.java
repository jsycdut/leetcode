/*
 *693.Binary Number with Alternating Bits
 *Given a positive integer, check whether it has alternating bits:
 *namely,if two adjacent bits will always have different values.
 */
class Solution{
	public boolean hasAlternatingBits(int n){
		String s = Integer.toBinaryString(n);
		boolean ans = true;
		for(int i = 0; i < s.length() - 1; i++){
			if(s.charAt(i) != s.charAt(i + 1)){
				continue;
			}else{
				ans = false;
				break;
			}
		}
		return ans;
	}
}
