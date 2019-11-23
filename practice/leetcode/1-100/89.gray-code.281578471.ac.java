class Solution {
    public List<Integer> grayCode(int n) {
       // 让我们一起膜拜李哥
       // https://leetcode.com/problems/circular-permutation-in-binary-representation/discuss/414203/JavaC%2B%2BPython-4-line-Gray-Code
       // 另外一道格雷码的周赛题
       // https://leetcode.com/problems/circular-permutation-in-binary-representation/
       // 格雷码的求取公式为 G(i) = i ^ (i >> 1)
       List<Integer> ans = new ArrayList<>();
       for (int i = 0; i < (1 << n); i++) {
         ans.add(i ^ (i >> 1));
       }

       return ans;
    }
}
