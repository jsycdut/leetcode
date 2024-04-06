class TreeAncestor {
    // 稀疏表/ST表，倍增算法
    // st[i][j] i的2^j个祖先
    // st[i][j+1] = st[st[i][j]][j]
    int[][] st;

    public TreeAncestor(int n, int[] parent) {
        int times = 16;
        st = new int[n][times];
        for (int i = 0; i < n; i++) {
            // 全部置-1
            Arrays.fill(st[i], -1);
        }

        // 放置首个父节点
        for (int i = 0; i < n; i++) {
            st[i][0] = parent[i]; // st[i][2^0]
        }


        // 注意是外循环的是父节点的变量，内循环的是节点编号
        for (int i = 1 ; i < times; i++) {
            for (int j = 0; j < n; j++) {
                if (st[j][i-1] != -1) {
                    st[j][i] = st[st[j][i-1]][i-1];
                }
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        // 将k分解成二次幂的形式，正好对应其父节点跳跃个数
        for (int i = 0; i < 31; i++) {
            if (((1<<i) & k) != 0) {
                node = st[node][i];
                if (node == -1) {
                    return -1;
                }
                // lowbit是二进制里面的最低位置的那个1
                // lowbit = x & -x ，也等于上面的1左移n位判定等于1
                // 卸掉lowbit即 k -= (x & -x) = k & (k - 1)
                // k -= (1 << i);
                k &= (k - 1);
            }
        }

        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
