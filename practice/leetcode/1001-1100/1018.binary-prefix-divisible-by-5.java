import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-prefix-divisible-by-5/
 * https://leetcode-cn.com/problems/binary-prefix-divisible-by-5/solution/ke-bei-5-zheng-chu-de-er-jin-zhi-qian-zh-asih/
 */
class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        if (A == null || A.length == 0)
            return Collections.emptyList();

        List<Boolean> ans = new ArrayList<>();
        int prefix = 0;
        for (int i = 0; i < A.length; i++) {
            prefix = ((prefix << 1) + A[i]) % 5;
            ans.add(prefix == 0);
        }

        return ans;
    }
}
