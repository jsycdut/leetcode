/**
 * leetcode-cn第199周周赛第1题
 * https://leetcode-cn.com/problems/shuffle-string/
 */
class Solution {
    public String restoreString(String s, int[] indices) {
        if (s == null || indices == null) return "";
        
        int len = s.length();
        char[] arr = new char[len];
        for (int i = 0; i < len; i++) {
            int index = indices[i];
            arr[index] = s.charAt(i);
        }
        
        return new String(arr);
    }
}
