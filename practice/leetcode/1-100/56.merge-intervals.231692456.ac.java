/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 *
 * https://leetcode.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (35.57%)
 * Total Accepted:    346.3K
 * Total Submissions: 972.8K
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example 1:
 * 
 * 
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into
 * [1,6].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * 
 * NOTE: input types have been changed on April 15, 2019. Please reset to
 * default code definition to get new method signature.
 * 
 */
class Solution {
    public int[][] merge(int[][] intervals) {
      // 边界
      if (intervals == null || intervals.length <= 1) return intervals; 

      int n = intervals.length;

      int[] x = new int[n];
      int[] y = new int[n];

      for (int i = 0; i < n; i++) {
        x[i] = intervals[i][0];
        y[i] = intervals[i][1];
      }

      Arrays.sort(x);
      Arrays.sort(y);

      int[][] res = new int[n][];

      int i = 0;
      int j = 0;
      int k = 0;
      int count = 0;

      while (i < n - 1 && j < n) {
        if (x[i + 1] > y[j]) {
          res[count] = new int[2];
          res[count][0] = x[k];
          res[count][1] = y[j];
          count++;
          k = i + 1;
        }

        i++;
        j++;
      }

      res[count] = new int[2];
      res[count][0] = x[k];
      res[count][1] = y[n - 1];

      return Arrays.copyOfRange(res, 0, count + 1);
    }

    // 解法II
    // public int[][] merge(int[][] intervals) {
    //   // 边界
    //   if (intervals == null || intervals.length <= 1) return intervals; 

    //   // 就利用人类的思路，把所有的都放到一个横坐标轴上来解决
    //   // 横坐标轴的长度决定于输入里面的最大值
    //   int max = 0;
    //   for (int i = 0; i < intervals.length; i++) {
    //     max = Math.max(max, Math.max(intervals[i][0], intervals[i][1]));
    //   }

    //   // axis 用于标记范围
    //   // -1代表一段的开头，只要是开头，就可以置为-1，不管之前这一位是什么值
    //   // 1代表一段的结尾，只能放置在不是-1的地方，否则会导致加一段
    //   // 对于首尾重合且对应位不是-1或者1的，置为2
    //   // 这样axis里面为1或者2的个数，就是结果的个数
    //   int[] axis = new int[max + 1];

    //   for (int i = 0; i < intervals.length; i++) {
    //     int begin = intervals[i][0];
    //     int end = intervals[i][1];

    //     // 这一段首尾重合
    //     if (begin == end) {
    //       if (axis[begin] == 0) {
    //         axis[begin] = 2;
    //       }

    //       continue; 
    //     }

    //     for (; begin < end; begin++) {
    //       axis[begin] = -1;
    //     }

    //     if (axis[end] != -1) {
    //       axis[end] = 1;
    //     }
    //   }

    //   int len = 0;
    //   for (int i : axis) {
    //     if (i == 1 || i == 2) len++;
    //   }

    //   int[][] res = new int[len][2];

    //   int count = 0;

    //   int begin = 0;
    //   int end = 0;
    //   
    //   while (end != axis.length) {
    //     if ((axis[begin] == -1 && axis[end] == 1) || axis[end] == 2 ) {
    //       res[count][0] = begin;
    //       res[count][1] = end;
    //       count++;
    //       begin = ++end;
    //     } else if (axis[end] == -1 && axis[begin] == -1) {
    //       end++;
    //     } else {
    //       begin++;
    //       end++;
    //     }
    //   }

    //   return res;
    // }
}

