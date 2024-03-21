
class FrequencyTracker {
    Map<Integer, Integer> numberAndFrequency;
    Map<Integer, Integer> frequencyAndTimes;

    public FrequencyTracker() {
        numberAndFrequency = new HashMap<>();
        frequencyAndTimes = new HashMap<>();
    }

    public void add(int number) {
        int curTimes = numberAndFrequency.getOrDefault(number, 0);
        int nextTimes = curTimes + 1;
        numberAndFrequency.put(number, nextTimes);
        // 当前times要-1
        if (frequencyAndTimes.get(curTimes) != null)
            frequencyAndTimes.put(curTimes, frequencyAndTimes.get(curTimes) - 1);
        // 新times要+1
        frequencyAndTimes.put(nextTimes, frequencyAndTimes.getOrDefault(nextTimes, 0) + 1);
    }

    public void deleteOne(int number) {
        // 当前这个数字出现的次数如果为0，则无需删除
        int curTimes = numberAndFrequency.getOrDefault(number, 0);
        if (curTimes == 0)
            return;
        // 否则数字对应的出现次数要减一，并且会影响对应的频率
        // 比如5出现了3次，删除后，5只出现2次，那么出现3次的数字的数量就会减一，出现2次的数字的数量就会加一
        numberAndFrequency.put(number, curTimes - 1);
        frequencyAndTimes.put(curTimes, frequencyAndTimes.get(curTimes) - 1);
        int previousTimes = curTimes - 1;
        if (previousTimes >= 1)
            frequencyAndTimes.put(previousTimes, frequencyAndTimes.get(previousTimes) + 1);
    }

    public boolean hasFrequency(int frequency) {
        int times = frequencyAndTimes.getOrDefault(frequency, 0);
        return times > 0;
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */

