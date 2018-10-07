public class Solution {
    /*
     * @param : an integer
     * @return:  the factorial of n
     * 这道题想考的就是大数阶乘，然后如果单纯用数值来计算的话，肯定溢出
     * 就跟我刷leetcode第一题那个链表相加一个情况
     * 不管你用什么数据类型来存储，溢出都会把你照单全收
     * 这道题的解题之道就在于最原始的逐位相乘再计算进位这一思想
     * 其次就是你用多大的空间来存储你的结果，这就涉及到计算阶乘位数的算法啦
     * 真的很有意思(｡◕ˇ∀ˇ◕），或许这就是算法的魅力所在
     */
    public String factorial(int n) {
        // write your code here
        // 计算阶乘总共有多少位
        // log10(a * b) =  log10(a) + log10(b)
        // log10(100) = 3, log10(999) = 3
        // log10(1000) = 4，之前我还在想怎么算阶乘位数，这个对数简直
        // 帮了我大忙，计算明确的阶乘位数可以减少空间开销，对程序有利
        double space = 0;
        for(int i = 1; i <= n; i++){
            space = space + Math.log10(i);
        }
        int  x = (int)space + 1;
        int[] rec = new int[x];
        rec[0] = 1;
        int carry = 0, temp = 0, cells = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < cells; j++){
                temp = i * rec[j] + carry;
                rec[j] = temp % 10;
                carry = temp / 10;
            }
            while(carry > 0){
                rec[cells++] = carry % 10;
                carry /= 10;
            }
        }
        // 一直在想如何将整形数组转为字符串，发现sb还是挺好用的
        StringBuilder sb = new StringBuilder();
        for(int i = cells - 1; i >= 0; i--){
            sb.append(rec[i]);
        }
        return sb.toString();

    }
}
