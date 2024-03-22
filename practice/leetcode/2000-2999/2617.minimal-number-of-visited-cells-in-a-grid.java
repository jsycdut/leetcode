class Solution {
    public int minimumVisitedCells(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<int[]>[] rows = new PriorityQueue[m]; // [最小距离，这一行的列索引]
        PriorityQueue<int[]>[] cols = new PriorityQueue[n]; // [最小距离，这一列的行索引]
        Arrays.setAll(rows, i -> new PriorityQueue<int[]>((a, b) -> a[0] - b[0]));
        Arrays.setAll(cols, i -> new PriorityQueue<int[]>((a, b) -> a[0] - b[0]));        
        int INF = Integer.MAX_VALUE / 4;
        int[][] dist = new int[m][n];
        for (int[] d : dist) {
            Arrays.fill(d, INF);
        }
        dist[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 从每一行和每一列的情况里面，找一个最小距离并且能到达当前位置的
                PriorityQueue<int[]> rowPq = rows[i];
                PriorityQueue<int[]> colPq = cols[j];
                while (!rowPq.isEmpty() ) {
                    int[] pair = rowPq.peek();
                    int colIndex = pair[1];
                    // 到达这个位置的距离虽小，但是跳不到当前的[i, j]位置
                    if (colIndex + grid[i][colIndex] < j) {
                    rowPq.poll();
                    } else {
                        break;
                    }
                }
                // 类似上面while的写法，更加简洁
                while (!colPq.isEmpty() && colPq.peek()[1] + grid[colPq.peek()[1]][j] < i) {
                    colPq.poll();
                }

                // 不为空，则可以从这个地方跳到[i][j]
                if (!colPq.isEmpty()) {
                    int[] shortest = colPq.peek();
                    int distance = shortest[0];
                    dist[i][j] = Math.min(dist[i][j], distance + 1);
                }

                if (!rowPq.isEmpty()) {
                    int[] shortest = rowPq.peek();
                    int distance = shortest[0];
                    dist[i][j] = Math.min(dist[i][j], distance + 1);
                }
                // 丰富这个队列，提供跟多的选择
                if (dist[i][j] != INF) {
                    rowPq.offer(new int[] { dist[i][j], j });
                    colPq.offer(new int[] { dist[i][j], i });
                }
            }
        }
        int result = dist[m - 1][n - 1];
        return result == INF ? -1 : result;
    }
}
