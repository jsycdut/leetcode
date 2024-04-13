class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // 结束时间更加优先
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            // 如果某个结束时间最早的会议比我当前会议开始时间还要早，那么就让他们从会议室出来
            // 否则就不能让他们从会议室出来
            if (!pq.isEmpty() && pq.peek()[1] <= intervals[i][0]) {
                pq.poll();
            }

            // 新增一个会议室
            pq.offer(intervals[i]);
        }

        return pq.size();
    }
}
