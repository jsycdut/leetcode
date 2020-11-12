class Solution {
    int[] ans;
    boolean[][] visited;
    int count = 0;
    final int RIGHT = 0;
    final int DOWN = 1;
    final int LEFT = 2;
    final int UP = 3;
    int direction = RIGHT;
    
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int rows = matrix.length;
        int cols = matrix[0].length;
        ans = new int[rows * cols];
        visited = new boolean[rows][cols];
        dfs(matrix, 0, 0);
        return ans;
    }

    // 似乎题解区没什么人用递归来写这道题
    // 基本思路是，当前能往右走就往右走，往右走不下去了（提前判往右的下一步看是否走的下去
    // 就往下走，反正就是当前一条路走到黑，走不行了，再换另外一个方向走
    // 走的方向选择分别是，先右，右不行了就往下，下不行了就往左，左不行了就往上，
    // 上不行了就往右，递归走就行了
    void dfs(int[][] matrix, int x, int y) {
        if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) {
            return;
        }

        if (visited[x][y]) return;
        visited[x][y] = true;
        ans[count++] = matrix[x][y];

        if (direction == RIGHT) {
            if (y + 1 > matrix[0].length || visited[x][y + 1]) {
                direction = DOWN;
                dfs(matrix, x + 1 , y);
            } else {
                dfs(matrix, x, y + 1);
            }
        } else if (direction == DOWN) {
            if (x + 1 >= matrix.length || visited[x+1][y]) {
                direction = LEFT;
                dfs(matrix, x, y - 1);
            } else {
                dfs(matrix, x + 1, y);
            }
        } else if (direction == LEFT) {
            if (y - 1 < 0 || visited[x][y - 1]) {
                direction = UP;
                dfs(matrix, x - 1, y);
            } else {
                dfs(matrix, x, y - 1);
            }
        } else {
            if (x < 0 || visited[x - 1][y]) {
                direction = RIGHT;
                dfs(matrix, x, y + 1);
            } else {
                dfs(matrix, x - 1, y);
            }
        }
    }
}=
