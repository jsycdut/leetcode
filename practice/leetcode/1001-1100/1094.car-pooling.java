class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int max = trips[0][2];
        for (int[] i : trips) {
            max = Math.max(max, i[2]);
        }

        int[] road = new int[max+1];
        for (int[] i : trips) {
            int passengers = i[0];
            int start = i[1];
            int end = i[2];
            road[start] += passengers;
            road[end] -= passengers;
        }

        int cnt = 0;
        for (int i : road) {
            cnt += i;
            if (cnt > capacity) {
                return false;
            }
        }
        return true;
    }
}
