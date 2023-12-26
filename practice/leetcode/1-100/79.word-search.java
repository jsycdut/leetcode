// https://leetcode.cn/problems/word-search/
class Solution {
    public boolean exist(char[][] b, String word) {
        char[][] visited = new char[b.length][b[0].length];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                // 每个节点都要去搜一遍，因为每一个点都可能是这个word的开头字符
                if (b[i][j]==word.charAt(0) && dfs(b, i, j, word, 0, visited)) return true;
            }
        }

        return false;
    }

    boolean dfs(char[][] b, int i, int j, String word, int step, char[][] visited) {
        // 异常情况：越界，当前字符和应有的路径上的字符不匹配, 节点已访问（回头路）
        boolean outbound = i < 0 || i >= b.length || j < 0 || j >= b[0].length;
        if (outbound) return false;
        boolean notEqual = (b[i][j] != word.charAt(step));

        if (notEqual) return false;
        boolean alreadyVisited = (visited[i][j] == 1);

        if (alreadyVisited) return false;

        // 已经在合理的情况下访问到了足够长度，即word的末尾
        if (step == word.length() - 1) return true;
        
        // 标记当前节点为已访问，然后向四周扩散
        visited[i][j] = 1;        
        boolean res = dfs(b, i - 1, j, word, step+1, visited)
            || dfs(b, i + 1, j, word, step+1, visited)
            || dfs(b, i, j- 1, word, step+1, visited)
            || dfs(b, i, j+1, word, step+1, visited);
        visited[i][j] = 0;

        return res;
    }
}
