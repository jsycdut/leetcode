// https://www.lintcode.com/problem/1552/description
// 本题当时面试阿里的时候出的算法题之一
public class Solution {
    /**
     * @param a: the Parking Record
     * @return: The max number of cars
     */
    public int getMax(int[][] a) {
        // Write your code here
        // 实则是一个区间操作，[3, 5]这个出入场时间，代表着对这个区间加1
        // 区间的操作，用差分数组，但是测例会出现所谓的一个区间过大导致老老实实分配差分数组的方式会爆内存
        // 所以要进行一个离散化，先用treeMap来搞一搞，对时间进行排序，入点执行+1，出点-1，最后统计收割
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int [] b : a) {
            // 无效记录
            if (b[0] >= b[1]) {
                continue;
            }
            // 差分数组区间操作
            treeMap.put(b[0], treeMap.getOrDefault(b[0], 0) + 1);
            treeMap.put(b[1], treeMap.getOrDefault(b[1], 0) - 1);
        }

        int sum = 0;
        int max = 0;
        // 通过差分数组恢复原始数组
        for (int key : treeMap.keySet()) {
            sum += treeMap.get(key);
            max = Math.max(max, sum);
        }

        return max;
    }
}
