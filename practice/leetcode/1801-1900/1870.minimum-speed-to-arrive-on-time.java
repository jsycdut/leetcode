class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        if (hour <= n - 1) {
            return -1;
        }

        int l = 1;
        int r = (int) 1e7;
        // 这里也是坑，2.01d * 100 md等于 200.99999999999997
        // 必须四舍五入一下
        long hr = (long) Math.round(100 * hour);
        while (l <= r) {
            int mid = (l + r) >>> 1;
            // 注意t为long
            double t = 0;
            for (int i = 0; i < n - 1; i++) {
                // t += Math.ceil(dist[i] * 1.0 / mid);
                // 这种写法比ceil要快
                t += (dist[i] - 1) / mid + 1;
            }

            // 这里也是在赌double的精度，由于题目说最多小数点后两位数，所以还能跑
            // 像下面这种恶心的例子就真的跪了
            // 2.09 < 2.090000000000000001 => false
            double cost = t + dist[n - 1] * 1.0d / mid;
            if (cost <= hour) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}
