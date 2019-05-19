class Solution {
    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) return Collections.emptyList();
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        dfs(res, 0, board);
        return res;
    }
    
    boolean dfs(List<List<String>> res, int step, char[][] board) {
        if (step == board.length) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < board[0].length; j++) {
                    sb.append(board[i][j]);
                }
                list.add(sb.toString());
            }
            res.add(list);
        }
        // 行里面选格子，放置当前步的皇后
        for (int i = 0; i < board[0].length; i++) {
            if (check(board, step, i)) {
                board[step][i] = 'Q';
                if (dfs(res, step + 1, board)) return true;
                board[step][i] = '.';
            }
        }
        
        return false;
    }
    
    boolean check(char[][] board, int row, int col) {
        // col check
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        
        // diagonal
        int min = Math.min(row, col);
        
        int i = row - min;
        int j = col - min;
        
        while (i < board.length && j < board[0].length) {
            if (i != row && j != col && board[i][j] == 'Q') return false;
            i++;
            j++;
        }
        
        i = row;
        j = col;
        
        while (i >= 1 && j < board[0].length - 1) {
            i--;
            j++;
        }
        
        while (i < board.length && j >= 0) {
            if (i != row && j != col && board[i][j] == 'Q') return false;
            i++;
            j--;
        }
        
        return true;
    }
}
