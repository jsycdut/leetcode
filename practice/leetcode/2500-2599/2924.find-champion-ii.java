class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] degrees = new int[n];
        for (int[] edge : edges) {
            degrees[edge[1]]++;
        }

        // 没有被打败的玩家它的入度为0，被打败了的其入度都不是0
        int champion = -1;
        for (int i = 0; i < n; i++) {
            if (degrees[i] == 0) {
                if (champion == -1) {
                    champion = i;
                } else {
                    return -1;
                }
            }
        }

        return champion;
    }
}
