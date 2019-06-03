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

        // 解法I：首先验证大的行和列，然后验证9个小盒子，写的很老实
        // 老实说，通过hashset来验证元素个数的做法太愚蠢
        // 解法III同样使用hashest，但是会诠释什么叫优秀
        // boolean ans = validBox(board);
        // for (int i = 0; i < 9; i++) {
        //     ans = (ans && validSubBox(board, i));
        // }
        // return ans;

        // ================================================================================

        // 解法II：同样是验证，但是将行和列以及小盒子的验证写到了一起
        // 比解法I少写了不少代码
        // 时间复杂度：O(n^3)
        // 空间复杂度：O(1)
        //
        // 所有不符合条件的全部用return false，剩下最后的情况就是return true了
        // for (int i = 0; i < board.length; i++) {
        //   for (int j = 0; j < board[0].length; j++) {
        //     if (board[i][j] == '.') continue;
        //
        //     // 验证行
        //     for (int col = 0; col < board[0].length; col++) {
        //       if (j == col) continue;
        //       if (board[i][col] == board[i][j]) return false;
        //     }
        //
        //     // 验证列
        //     for (int row = 0; row < board.length; row++) {
        //       if (i == row) continue;
        //       if (board[row][j] == board[i][j]) return false;
        //     }
        //
        //     // 验证小方格
        //     for (int x = i / 3 * 3; x < (i / 3 + 1) * 3; x++) {
        //       for (int y = j / 3 * 3; y <  (j / 3 + 1) * 3; y++) {
        //         if (x == i && y == j) continue;
        //         if (board[x][y] == board[i][j]) return false;
        //       }
        //     }
        //   }
        // }
        // return true;

        // ================================================================================
        //
        // 解法III：真正优秀的解法，需要注意的点如下
        // 1. set的add方法在添加重复的元素的时候会返回false，可以利用这个特点
        //    没必要像解法I中那样去算集合中的元素个数
        // 2. 特别注意求解小方格里面重复元素的解法

        // for (int i = 0; i < board.length; i++) {
        //   Set<Character> row = new HashSet<>();
        //   Set<Character> col = new HashSet<>();
        //   Set<Character> cub = new HashSet<>();

        //   for (int j = 0; j < board[0].length; j++) {
        //     if (board[i][j] != '.' && !row.add(board[i][j])) return false;
        //     if (board[j][i] != '.' && !col.add(board[j][i])) return false;

        //     // 下面的确实是太酷了，利用i和j依次实现了9个小方格的遍历
        //     // x和y代表着每个小方格里面的9个坐标，太棒了
        //     //
        //     // 5  3  .  .  7  .  .  .  .
        //     // 6  .  .  1  9  5  .  .  .
        //     // .  9  8  .  .  .  .  6  .
        //     // 8  .  .  .  6  .  .  .  3
        //     // 4  .  .  8  .  3  .  .  1
        //     // 7  .  .  .  2  .  .  .  6
        //     // .  6  .  .  .  .  2  8  .
        //     // .  .  .  4  1  9  .  .  5
        //     // .  .  .  .  8  .  .  7  9
        //     //
        //     // rowIndex colIndex依次代表着每一行三个小方格的横坐标和纵坐标
        //     // 假设上面9x9的9个小方格的序号如下
        //     // 1 2 3
        //     // 4 5 6
        //     // 7 8 9
        //     // 由i控制此时遍历的是第几号小方格
        //     // 然后确定该方格左上角起始位置的坐标，也就是rowIndex和colIndex
        //     // 然后利用j，rowIndex + j / 3可以进入下一行
        //     // colIndex + j % 3可以在同一行向右遍历
        //     // 从而在j的遍历中走遍小方格的9个子格
        //     int rowIndex = 3 * (i / 3);
        //     int colIndex = 3 * (i % 3);

        //     int x = rowIndex + j / 3;
        //     int y = colIndex + j % 3;

        //     if (board[x][y] != '.' && !cub.add(board[x][y])) return false;
        //   }
        // }

        // return true;
        // ================================================================================
        // 解法IV: 空间换时间的做法

        // 下面的三个二维数组代表对应行, 列, 以及对应编号的小方格内被填充的数字的情况
        // 被填充了某个数组, 就把对应位置为true
        // row[i][value]为true, 代表的是数独的第i行, 存在value这个数字
        // col[j][value]为true, 代表的是数独的第j列, 存在value这个数字
        // grid[gridNumber][value]为true, 代表的而是数独的第gridNumber号小方格, 存在value这个数字
        // 如果在检查某个数独位置的时候, 发现这一行或者列或者小方格已经填充过了对应的值, 就说明数独不合法
        boolean[][] row = new boolean[10][10];
        boolean[][] col = new boolean[10][10];
        boolean[][] grid = new boolean[10][10];

        for (int i = 0; i < board.length; i++) {
          for (int j = 0; j < board[0].length; j++) {
            if (board[i][j] != '.') {
              int value = board[i][j] - '0'; // 当前被填充的是数字0~9中的哪一位
              int gridNumber = (i / 3) * 3 + (j / 3); // 小方格的编号

              if (row[i][value] || col[j][value] || grid[gridNumber][value]) return false;

              row[i][value] = true; // 数独的第i行, 已经填充了值为value的数字, 记录到row的i行里面(把row[i][value]置为true)
              col[j][value] = true; // 数独的第j列, 已经填充了值为value的数字, 记录到col的j行里面(把col[j][value]置为true)
              grid[gridNumber][value] = true; // 数独的第gridNumber号小方格, 已经填充了值为value的数字, 记录到grid的gridNumber行里面
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





