class Solution {
    public int countSegments(String s) {
      if (s.length() == 0) return 0;
      
      int cnt = s.charAt(0) != ' ' ? 1 : 0;
      for (int i = 1; i < s.length(); i++) {
        if (s.charAt(i - 1) == ' ' && s.charAt(i) != ' ') cnt++;
      }

      return cnt;
    }
}
