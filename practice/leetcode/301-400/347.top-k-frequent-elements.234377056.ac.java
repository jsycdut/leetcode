/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 *
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 *
 * algorithms
 * Medium (54.81%)
 * Total Accepted:    207.2K
 * Total Submissions: 376.7K
 * Testcase Example:  '[1,1,1,2,2,3]\n2'
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1], k = 1
 * Output: [1]
 * 
 * 
 * Note: 
 * 
 * 
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is
 * the array's size.
 * 
 * 
 */
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
      // 边界检查，题目有说k合法，但没说nums为null和元素个数为0的情况
      if (nums == null || nums.length == 0 || k <= 0) return Collections.emptyList();

      // 本题是要让我们求出一个数组中出现次数最多的k个元素
      // 常规思路就是，统计所有元素的个数，然后取出次数最多的前k个就行了
      //
      // 本题的考察点在于数据结构，要装载元素本身和元素出现的次数，需要用到Map
      // 要把元素的优先级和元素本身挂钩，需要优先队列
      //
      // 所以本题的解题步骤如下（使用Java实现，其他语言思路类似）
      // 以数字为键，数字出现的次数为值，遍历nums，放入map，遍历完成之后，所有的元素的出现次数就统计完毕了
      // 然后将map中所有的条目放入一个优先队列，实现一个比较器，保证是让出现次数大的出现在队列的前部
      // 最后取出队列的前k个元素即可
      //
      Map<Integer, Integer> map = new HashMap<>();

      for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);

      PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
        @Override
        public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
          return e2.getValue() - e1.getValue();
        }
      });

      for (Map.Entry<Integer, Integer> entry : map.entrySet()) pq.add(entry);

      int i = 1;
      List<Integer> result = new ArrayList<>();

      while (i++ <= k) result.add(pq.poll().getKey());

      return result;
   }
}


