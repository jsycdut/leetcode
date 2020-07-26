/**
 * leetcode-cn第199周周赛第2题
 * https://leetcode-cn.com/problems/bulb-switcher-iv/ 
 */
class Solution {
    public int minFlips(String target) {
        if (target == null || target.length() == 0) return 0;
        
        int ans = 0;
        int len = target.length();
        for (int i = 1; i < len; i++) {
            if (target.charAt(i) != target.charAt(i - 1)) ans++;
        }
        
        return target.charAt(0) == '1' ? ans + 1 : ans;
    }
}
