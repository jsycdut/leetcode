class Solution {
    // 暴力解法，其实这道题可以看做是将num个豆子放入10个盒子中
    // 每个盒子只能放一个豆子，可以用dfs来解决，但是，但是这种解法
    // 真的太暴力了好么，这不是一道easy级别的题，但是对于从0刷到400题
    // 的人来说，确实是easy级别，因为思路真的很清晰
    // 这道题dfs会有重复，所以利用了set来去重，记得很久以前碰到过一个
    // 全排列的题，就是1 2 3 4有多少种组合这种全排列，当时看过一位小哥
    // 写的博客，理解不了，现在我终于理解了dfs，dfs就是递归，总共递归num次
    // 意味着完成num个豆子的放置，dfs里面的循环
    // 代表着当前可以把豆子扔到哪些盒子里，里面的判断，是为了搞清楚
    // 当前扔的那个盒子里面是不是已经扔了豆子了，最后又把豆子收回，
    // 是因为每次递归到最后完成了的时候，仅代表这种可能被探索了，
    // 还有其他可能即将要被探索，所以当前完成后要恢复现场，
    // 让其他的探索能正确执行。


    // 这不是一个好的解法，我要去看解答了
    // 不过写起来是真的简单啊，思路也清晰
    // 不，我不能麻醉我自己，我要去找最骚的解法（逃
    public List<String> readBinaryWatch(int num) {
        Set<String> set = new HashSet<String>();
        if (num < 0 || num > 10) return new ArrayList(set);

        int[] record = new int[10];
        recur(0, num, record, set);
        return new ArrayList(set);
    }

    void recur(int step, int end, int[] record, Set set) {
        if (step == end) {
            int hour = 8 * record[0] + 4 * record[1] + 2 * record[2] + 1 * record[3];
            if (hour > 11) return;
            int minute = 32 * record[4] + 16 * record[5] + 8 * record[6] + 4 * record[7] + 2 * record[8] + 1 * record[9];
            if (minute > 59) return;
            String h = "" + hour;
            String m = "0" + minute;
            m = m.substring(m.length() - 2, m.length());
            set.add(h + ":" + m);
            return;

        }

        for (int i = 0; i < 10; i++) {
            if (record[i] != 1) {
                record[i] = 1;
                recur(step + 1, end, record, set);
                record[i] = 0;
            }
        }
    }
}
