/**
 * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 */
class Solution {
    public String removeDuplicates(String S) {
        char[] arr = S.toCharArray();
        int len = arr.length;
        while (true) {
            int i = 0;
            boolean unchanged = true;
            while (i < len) {
                char target = arr[i];
                if (target != 0) {
                  int j = i + 1;
                  while (j < len) {
                      if (arr[j] == target) {
                          arr[j] = 0;
                          arr[i] = 0;
                          unchanged = false;
                          break;
                      } else if (arr[j] == 0) {
                          j++;
                      } else {
                          break;
                      }
                  }                    
                }
                i++;
            }

            if (unchanged) break;
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if (c != 0) {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}
