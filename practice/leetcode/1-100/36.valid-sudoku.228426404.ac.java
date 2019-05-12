/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 *
 * https://leetcode.com/problems/valid-sudoku/description/
 *
 * algorithms
 * Medium (42.80%)
 * Total Accepted:    231.3K
 * Total Submissions: 540.3K
 * Testcase Example:  '[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]'
 *
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be
 * validated according to the following rules:
 *
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without
 * repetition.
 *
 *
 *
 * A partially filled sudoku which is valid.
 *
 * The Sudoku board could be partially filled, where empty cells are filled
 * with the character '.'.
 *
 * Example 1:
 *
 *
 * Input:
 * [
 * ⁠ ["5","3",".",".","7",".",".",".","."],
 * ⁠ ["6",".",".","1","9","5",".",".","."],
 * ⁠ [".","9","8",".",".",".",".","6","."],
 * ⁠ ["8",".",".",".","6",".",".",".","3"],
 * ⁠ ["4",".",".","8",".","3",".",".","1"],
 * ⁠ ["7",".",".",".","2",".",".",".","6"],
 * ⁠ [".","6",".",".",".",".","2","8","."],
 * ⁠ [".",".",".","4","1","9",".",".","5"],
 * ⁠ [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input:
 * [
 * ["8","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner
 * being
 * ⁠   modified to 8. Since there are two 8's in the top left 3x3 sub-box, it
 * is invalid.
 *
 *
 * Note:
 *
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily
 * solvable.
 * Only the filled cells need to be validated according to the mentioned
 * rules.
 * The given board contain only digits 1-9 and the character '.'.
 * The given board size is always 9x9.
 *
 *
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) return true;
        
        // 这道题我一开始使用的解法I，解出来了觉得没什么意思
        // 然后看了一个题解的视频，才发现这道题可以用更加优秀的思想解出来
        // 如果面试考这道题，解法I只能说合格，解法II比较好，解法III才是真的优秀

        // 解法I：首先验证大的行和列，然后验证9个小盒子，写的很老实，不够优秀
        // 老实说，通过hashset来验证元素个数的做法太愚蠢
        // 解法III同样使用hashest，但是会诠释什么叫优秀
        // boolean ans = validBox(board);
        // for (int i = 0; i < 9; i++) {
        //     ans = (ans && validSubBox(board, i));
        // }
        // return ans;

        // 解法II：同样是验证，但是将行和列以及小盒子的验证写到了一起
        // 比解法I少写了不少代码

        for (int i = 0; i < board.length; i++) {
          for (int j = 0; j < board[0].length; j++) {
            if (board[i][j] == '.') continue;

            // 验证行
            for (int col = 0; col < board[0].length; col++) {
              if (j == col) continue;
              if (board[i][col] == board[i][j]) return false;
            }

            // 验证列
            for (int row = 0; row < board.length; row++) {
              if (i == row) continue;
              if (board[row][j] == board[i][j]) return false;
            }

            // 验证小方格
            for (int x = i / 3 * 3; x < (i / 3 + 1) * 3; x++) {
              for (int y = j / 3 * 3; y <  (j / 3 + 1) * 3; y++) {
                if (x == i && y == j) continue;
                if (board[x][y] == board[i][j]) return false;
              }
            }
          }
        }

        return true;
    }


    // 解法I的辅助函数:验证9个小方格
    boolean validSubBox(char[][] arr, int index) {
        int x = index / 3 * 3;
        int y = (index % 3) * 3;

        boolean row = true;
        boolean col = true;

        Set<Character> rowCharSet = new HashSet<>();
        Set<Character> colCharSet = new HashSet<>();

        int rowDotCount = 0;
        int colDotCount = 0;

        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (arr[i][j] == '.') {
                    rowDotCount++;
                } else {
                    rowCharSet.add(arr[i][j]);
                }

                if (arr[j][i] == '.') {
                    colDotCount++;
                } else {
                    colCharSet.add(arr[j][i]);
                }
            }
        }

        if (9 - rowDotCount != rowCharSet.size()) {
            row = false;
        }

        if (9 - colDotCount != colCharSet.size()) {
            col = false;
        }

        return row && col;
    }

    // 解法I的辅助函数：验证行和列
    boolean validBox(char[][] arr) {
        boolean row = true;
        boolean col = true;

        for (int i = 0; i < 9; i++) {
            Set<Character> rowCharSet = new HashSet<>();
            Set<Character> colCharSet = new HashSet<>();

            int rowDotCount = 0;
            int colDotCount = 0;
            for (int j = 0; j < 9; j++) {
                if (arr[i][j] == '.') {
                    rowDotCount++;
                } else {
                    rowCharSet.add(arr[i][j]);
                }

                if (arr[j][i] == '.') {
                    colDotCount++;
                } else {
                    colCharSet.add(arr[j][i]);
                }

            }

            if (9 - rowDotCount != rowCharSet.size()) {
                row = false;
                break;
            }

            if (9 - colDotCount != colCharSet.size()) {
                col = false;
                break;
            }
        }

        return row && col;
    }
}



