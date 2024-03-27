class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long l = 1;
        long max = time[0];
        for (int t : time) {
            max = Math.max(max, t);
        }
        // 上界按照跑的最慢的那趟车跑所有趟次的来，注意max必须为long，否则 int * int为int的情况在值较大的情况下会出现负数导致值不正确
        long r = totalTrips * max;
        // 二分的是跑完旅途的时间，这个时间除以每个车跑一趟的时间就是趟数
        while (l <= r) {
            long mid = (l + r) >>> 1;
            long cnt = 0;
            for (int t : time) {
                cnt += mid / t;
            }

            if (cnt >= totalTrips) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}
