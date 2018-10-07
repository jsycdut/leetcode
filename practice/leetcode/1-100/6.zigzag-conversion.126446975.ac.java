/*
 * [6] ZigZag Conversion
 *
 * https://leetcode.com/problems/zigzag-conversion
 *
 * algorithms
 * Medium (26.91%)
 * Total Accepted:    176.6K
 * Total Submissions: 656K
 * Testcase Example:  '""\n1'
 *
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * 
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * string convert(string text, int nRows);
 * 
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * 
 */
class Solution {
    public String convert(String s, int numRows) {
	    if(numRows == 1){
		    return s;
	    }
	    int n = s.length();
	    StringBuilder sb = new StringBuilder();
	    for(int i = 0; i < numRows; i++){
		    for(int j = i; j < n; j += (2 * numRows - 2)){
			    sb.append(s.charAt(j));
			    if(j + 2 * numRows - 2 * (i + 1) < n && j + 2 * numRows - 2 * (i + 1) != j + 2 * numRows - 2 && j + 2 * numRows - 2 * (i + 1) != j){
				    sb.append(s.charAt(j + 2 * numRows - 2 * (i + 1)));
			    } 
		    }
	    }
            return sb.toString();
    }
}
