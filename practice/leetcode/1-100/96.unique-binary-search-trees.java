class Solution {
    public int numTrees(int n) {
        // 1 2 3 4 5
        // 枚举i作为根节点的情况，[1, i]为左子树 [i+1, n]为右子树，区间左右相等则为空子树
        // 以i作为根节点的情况下，符合条件的二叉搜索树的数量
        // 由左子树和右子树决定，因为在根节点确定的情况下，左子树和右子树的数据是确定互不相交的
        // 所以f(i, j) = f(1, i) * f(i+1, j)

        return count(1, n);
    }

    int count(int l, int r) {
        if (l >= r) return 1;
        int cnt = 0;
        for(int i = l; i <= r; i++) {
            cnt += count(l, i-1) * count(i+1, r);
        }

        return cnt;
    }
}

class Solution {
    int[][] table;
    public int numTrees(int n) {
        table = new int[n+1][n+1];
        return count(1, n);
    }

    int count(int l, int r) {
        if (l >= r) return 1;
        if (table[l][r]!=0)  return table[l][r];

        int ans = 0;
        for (int i = l; i <= r; i++) {
            ans += count(l, i-1) * count(i+1, r);
        }
        table[l][r] = ans;
        return ans;
    }
}


