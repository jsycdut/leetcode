/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 *
 * https://leetcode.com/problems/sudoku-solver/description/
 *
 * algorithms
 * Hard (36.57%)
 * Total Accepted:    126.4K
 * Total Submissions: 345.2K
 * Testcase Example:  '[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]'
 *
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * A sudoku solution must satisfy all of the following rules:
 * 
 * 
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3
 * sub-boxes of the grid.
 * 
 * 
 * Empty cells are indicated by the character '.'.
 * 
 * 
 * A sudoku puzzle...
 * 
 * 
 * ...and its solution numbers marked in red.
 * 
 * Note:
 * 
 * 
 * The given board contain only digits 1-9 and the character '.'.
 * You may assume that the given Sudoku puzzle will have a single unique
 * solution.
 * The given board size is always 9x9.
 * 
 * 
 */
class Solution {
    public void solveSudoku(char[][] board) {
      if (board == null || board.length == 0) return;
      dfs(board);
    }

    boolean dfs(char[][] board) {
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
          if (board[i][j] == '.') {
            for (char c = '1'; c <= '9'; c++) {
              if (check(board, i, j, c)) {
                board[i][j] = c;
                if (dfs(board)) {
                  return true;
                } else {
                  board[i][j] = '.';
                }
              }
            }
            return false;
          }
        }
      }

      return true;
    }
    
    boolean check(char[][] arr, int row, int col, char c) {
      for (int i = 0; i < 9; i++) {
        if (arr[row][i] == c) return false;
        if (arr[i][col] == c) return false;
        if (arr[row / 3 * 3 + i / 3][col / 3 * 3  + i % 3] == c) return false;
        // if (arr[row][i] != '.' && arr[row][i] == c) return false;
        // if (arr[i][col] != '.' && arr[i][col] == c) return false;
        // if (arr[row / 3 * 3 + i / 3][col / 3 * 3 + i % 3] != '.' && arr[row / 3 * 3 + i / 3][col / 3 * 3  + i % 3] == c) return false;
      }

      return true;
    }
}

