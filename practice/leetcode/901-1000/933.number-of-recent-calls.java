/**
 * https://leetcode-cn.com/problems/number-of-recent-calls/
 */
class RecentCounter {

    private Queue<Integer> queue;

    public RecentCounter() {
        this.queue = new ArrayDeque<>();
    }
    
    public int ping(int t) {
        while (!queue.isEmpty() && t - queue.peek() > 3000) {
            queue.poll();
        }

        queue.offer(t);
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
