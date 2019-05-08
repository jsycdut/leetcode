/*
 * @lc app=leetcode id=575 lang=java
 *
 * [575] Distribute Candies
 *
 * https://leetcode.com/problems/distribute-candies/description/
 *
 * algorithms
 * Easy (59.48%)
 * Total Accepted:    70.3K
 * Total Submissions: 118.2K
 * Testcase Example:  '[1,1,2,2,3,3]'
 *
 * Given an integer array with even length, where different numbers in this
 * array represent different kinds of candies. Each number means one candy of
 * the corresponding kind. You need to distribute these candies equally in
 * number to brother and sister. Return the maximum number of kinds of candies
 * the sister could gain.
 *
 * Example 1:
 *
 * Input: candies = [1,1,2,2,3,3]
 * Output: 3
 * Explanation:
 * There are three different kinds of candies (1, 2 and 3), and two candies for
 * each kind.
 * Optimal distribution: The sister has candies [1,2,3] and the brother has
 * candies [1,2,3], too.
 * The sister has three different kinds of candies.
 *
 *
 *
 * Example 2:
 *
 * Input: candies = [1,1,2,3]
 * Output: 2
 * Explanation: For example, the sister has candies [2,3] and the brother has
 * candies [1,1].
 * The sister has two different kinds of candies, the brother has only one kind
 * of candies.
 *
 *
 *
 * Note:
 *
 * The length of the given array is in range [2, 10,000], and will be even.
 * The number in given array is in range [-100,000, 100,000].
 *
 *
 */
class Solution {
    public int distributeCandies(int[] candies) {
        // 考思路的题，超级简单，由于糖果数量要对半开，只要姐姐对半开的糖果里面包含尽量多的种类即可
        // 设糖果有n个，其中糖果的类型有t种，如果t >= n / 2，那么在姐姐对半开的糖果里面放n / 2种，每种1颗即可
        // 反之，在姐姐对半开的糖果里面把所有t种都包含就行了，其实答案就是Math.min(n / 2, t)

        // 这道题在计算有多少种糖果的时候，可以用set，
        // 但是也有另外的解法，算是比较取巧，就是利用空间换时间
        // 比如下面的求种类的解法，运行速度要比利用set要快
        //
        // 解法I：空间换时间，自己求糖果的种类
        // 这种解法类似于位图法，就是把对应位标记成某个值，代表某种状态
        // 比如下面的做法就是某个索引为true，就代表一种糖果
        // 之所以要加100000，是因为candies里面有负数
        // 而且众所周知，位图法所用空间受群体里面的最大值的限制
        // 这道题就205个测例，但是表示糖果类型的boolean数组长度却达到了20万
        // 是很快，但是也是相当费空间，而且还要猜这里面的最大值，猜不对就是一次数组越界（难受啊
        // 总体来说，不如用set来求种类那么清晰明了
        // 具体解法如下
        //
        // int count = 0;
        // boolean[] container = new boolean[200005];

        // for (int i : candies) {
        //     if (!container[i + 100000]) {
        //         container[i + 100000] = true;
        //         count++;
        //     }
        //
        //     if (count >= candies.length / 2) return count;
        // }
        //
        // return count;

        if (candies == null || candies.length <= 0) return 0;

        Set<Integer> set = new HashSet<>();

        for (int i : candies) set.add(i);

        //return set.size() >= candies.length / 2 ? candies.length / 2: set.size();

        return Math.min(set.size(), candies.length / 2); // 比上面的表达式更好
    }
}

