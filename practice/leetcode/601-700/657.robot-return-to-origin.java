/**
 * https://leetcode-cn.com/problems/robot-return-to-origin/
 */
class Solution {
    public boolean judgeCircle(String moves) {
        int horizontal = 0;
        int vertical = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'R') horizontal++;
            if (c == 'L') horizontal--;
            if (c == 'U') vertical++;
            if (c == 'D') vertical--;
        }

        return horizontal == 0 && vertical == 0;
    }
}
