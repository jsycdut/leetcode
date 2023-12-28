class Solution {
    public int numIslands(char[][] g) {
        // 炸毁岛屿
        int cnt = 0;
        for(int i = 0;i<g.length;i++) {
            for (int j = 0; j < g[0].length;j++){
                if (g[i][j] == '1'){
                    boom(g, i, j);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    void boom(char[][]g, int i, int j){
        if (i < 0 || j <0) return;
        if (i >= g.length || j >= g[0].length) return;
        if(g[i][j] != '1')return;
        g[i][j] = '0';
        boom(g, i - 1, j);
        boom(g, i+1, j);
        boom(g, i, j-1);
        boom(g, i, j+1);
    }
}
