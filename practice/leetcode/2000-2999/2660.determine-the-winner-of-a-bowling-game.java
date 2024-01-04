class Solution {
    public int isWinner(int[] p1, int[] p2) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < p1.length; i++) {
            sum1 += p1[i];
            if ((i - 2 >= 0 && p1[i - 2] == 10) || (i - 1 >= 0 && p1[i - 1] == 10))
                sum1 += p1[i];

            sum2 += p2[i];
            if ((i - 2 >= 0 && p2[i - 2] == 10) || (i - 1 >= 0 && p2[i - 1] == 10))
                sum2 += p2[i];

        }

        return sum1 == sum2 ? 0 : (sum1 > sum2 ? 1 : 2);
    }
}
