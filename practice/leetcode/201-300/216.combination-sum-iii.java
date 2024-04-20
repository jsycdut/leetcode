class Solution {
    List<List<Integer>> ans;
    List<Integer> tmp;
    int target;
    int k;
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.ans = new ArrayList<>();
        this.tmp = new ArrayList<>();
        this.target = n;
        this.k = k;
        dfs(1, 0);
        return ans;
    }

    void dfs(int idx, int sum){
        if (sum > target || idx == 11) {
            return;
        }

        if (sum == target && tmp.size() == k) {
            ans.add(new ArrayList<>(tmp));
            return;
        }

        dfs(idx + 1, sum);
        tmp.add(idx);
        dfs(idx+1, sum+idx);
        tmp.remove(tmp.size()-1);
    }
}
