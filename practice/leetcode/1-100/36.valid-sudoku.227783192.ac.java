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
        // 好没意思啊这道题
        // 就是验证大的9x9里面的 行不重复，列不重复
        // 验证小的9个3x3里面没有重复
        // 除非我一会儿在解答里面看见更好的解法，否则我要给这道题打差评了
        if (board == null || board.length == 0) return true;

        boolean ans = validBox(board);
        for (int i = 0; i < 9; i++) {
            ans = (ans &&validSubBox(board, i));
        }
        return ans;
    }


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


