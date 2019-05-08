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

        if (candies == null || candies.length <= 0) return 0;

        Set<Integer> set = new HashSet<>();

        for (int i : candies) set.add(i);

        //return set.size() >= candies.length / 2 ? candies.length / 2: set.size();

        return Math.min(set.size(), candies.length / 2); // better than above expression
    }
}

