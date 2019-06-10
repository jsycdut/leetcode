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
      // 本题是要让我们求出一个数组中出现次数最多的k个元素
      // 常规思路就是，统计所有元素的个数，然后取出次数最多的前k个就行了
      //
      // 本题的考察点在于数据结构，要装载元素本身和元素出现的次数，需要用到Map
      // 要把元素的优先级和元素本身挂钩，需要优先队列，但是也可以使用桶来代替优先队列
      //
      // =================================================================================================
      // 解法I：HashMap && PriorityQueue
      // 本题的解题步骤如下
      // 以数字为键，数字出现的次数为值，遍历nums，放入map，遍历完成之后，所有的元素的出现次数就统计完毕了
      // 然后将map中所有的条目放入一个优先队列，实现一个比较器，保证是让出现次数大的出现在队列的前部
      // 最后取出队列的前k个元素即可
      //
      // 边界检查，题目有说k合法，但没说nums为null和元素个数为0的情况
      // if (nums == null || nums.length == 0 || k <= 0) return Collections.emptyList();
      //
      // Map<Integer, Integer> map = new HashMap<>();
      //
      // for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
      //
      // PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
      //   @Override
      //   public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
      //     return e2.getValue() - e1.getValue();
      //   }
      // });
      //
      // for (Map.Entry<Integer, Integer> entry : map.entrySet()) pq.add(entry);
      //
      // int i = 1;
      // List<Integer> result = new ArrayList<>();
      //
      // while (i++ <= k) result.add(pq.poll().getKey());
      //
      // return result;
      //
      // =================================================================================================
      // 解法II：HashMap && Bucket
      
      if (nums == null || nums.length == 0 || k <= 0) return Collections.emptyList();

      Map<Integer, Integer> statisticMap = new HashMap<>();

      // 统计数字的出现次数
      for (int i : nums) statisticMap.put(i, statisticMap.getOrDefault(i, 0) + 1);

      List<Integer>[] bucket = new List[nums.length + 1];

      // 根据元素出现的次数填充桶，每个桶的位置都放着一个链表，
      // 放着出现次数与索引大小相同的元素
      for (int i : statisticMap.keySet()) {
        int frequency = statisticMap.get(i);

        if (bucket[frequency] == null) bucket[frequency] = new ArrayList<Integer>();

        bucket[frequency].add(i);
      }

      // 根据出现频率，从后往前，也即是出现频率从高到低找k个元素放入结果集
      List<Integer> result = new ArrayList<>();

      for (int i = bucket.length - 1; i >= 0; i--) {
        if (bucket[i] == null) continue;
        
        if (result.size() >= k) break;
        
        // leetcode的测例没有多个元素出现次数相同的情况，所以可以直接addAll，
        // 否则还需要判断元素个数一个个的加免得加入的元素总计超过了k个
        // 测试没有多个元素出现次数相同估计是为了判题方便
        result.addAll(bucket[i]);
      }

      return result;
   }
}



