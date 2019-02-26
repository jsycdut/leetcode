/*
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
*/

public class Solution {
    // 用StringBuilder，根本没难度，没劲
    // 但是书上的解法似乎更有教学意义
    public String replaceSpace(StringBuffer str) {
    	StringBuilder sb = new StringBuilder();
        int len = str.length();
        int i = 0;
        while (i < len) {
            if (str.charAt(i) != ' ') {
                sb.append(str.charAt(i));
            }else{
                sb.append("%20");
            }
            i++;
        }
        return sb.toString();
    }
}
