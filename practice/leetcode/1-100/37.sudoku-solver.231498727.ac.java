/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 *
 * https://leetcode.com/problems/sudoku-solver/description/
 *
 * algorithms
 * Hard (36.85%)
 * Total Accepted:    128.3K
 * Total Submissions: 348.1K
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
      // 判空
      if (board == null || board.length == 0) return;

      // 解法I: 不记录暴力回溯
      dfs(board);
    }


    // 解法I: 简单的不借助优化的暴力回溯解法, 回溯的意思就是遇见不合适的情况, 就往回走
    // 怎么知道不合适呢? 就是利用返回值, 什么类型的返回值比较好表示合适还是不合适? 布尔类型就很合适
    // 简单的思路就是, 遍历所有的格子, 遇见'.'的格子, 就开始在1-9中找合适的数字填充进去
    // 合适的标准就是行, 列, 以及小方格没有重复数字, 找到合适的数字之后, 就填充下一个格子,
    // 利用下一个格子的填充情况, 如果填充不合适, 那么就说明当前步骤填充的数字不合适, 应该填充下一个数字试试
    // 否则就是合适的, 注意默认情况的返回值, 如果1-9填充完了都没有返回合适的情况, 那就该返回不合适了

    boolean dfs(char[][] board) {
      for (int i = 0; i < board.length; i++) {        // 外面这两重循环, 走遍了整个9x9的格子, 每次递归到下一步的时候,
        for (int j = 0; j < board[0].length; j++) {   // 都会重复的去遍历前面已经填充好的格子, 所以此处可以优化
          if (board[i][j] == '.') { // 碰上'.'的格子, 就开始利用下面的for循环从1-9进行填充尝试
            for (char c = '1'; c <= '9'; c++) {
              if (check(board, i, j, c)) { // 如果当前填充合适, 就将该字符写到'.'对应的位置上
                board[i][j] = c;
                if (dfs(board)) { // 在合适的情况下, 当前格子已经填充好了, 进行下一次递归, 看是否能解决下一个格子, 这里其实递归下一步的话
                  return true;    // 就是又从左上角一个个的看是否为'.', 由于之前的格子都在前面都填充了, 所以都不是'.', 接下来处理的就是下一步的格子
                                  // 如果能, 就返回true, 否则就说明当前步填充的字符不能使下一步有有解, 就该尝试下一个数字
                } else {
                  board[i][j] = '.'; // 一定要将填充过的格子还原为'.', 否则会导致无法得到正确的解
                }
              }
            }
            return false; // 如果所有的1-9都试过了, 还没有返回true, 就说明都不合适, 就该返回false了
          }
        }
      }

      return true; // 走遍9x9的所有格子了, 说明之前的填充都是成功的, 否则也到不了这一步
    }

    boolean check(char[][] board, int i, int j, char c) {
      for (int k = 0; k < 9; k++) {
        if (board[i][k] == c) return false; // 检查行
        if (board[k][j] == c) return false; // 检查列
      }

      // 检查小方格
      int row = (i / 3) * 3;
      int col = (j / 3) * 3;

      for (int m = 0; m < 3; m++) {
        for (int n = 0; n < 3; n++) {
          if (board[row + m][col + n] == c) return false;
        }
      }

      return true;
    }
}

