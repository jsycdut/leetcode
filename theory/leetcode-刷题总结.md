# Leetcode 刷题总结

## 2 3 4的幂

全是easy级别的题，主要是用最笨的办法，就是循环除法，首先一定能整除，也即是取余为0，除到最后的商是1，然后其余每道题都有神仙解法。

* [2的幂](https://leetcode.com/problems/power-of-two/)

一个数是2的幂，那么二进制里面只有一个1，把这个数唯一的1消掉就是0，消掉一个数的最低位的1的办法是 n & (n - 1)。

* [3的幂](https://leetcode.com/problems/power-of-three/)

整数里面3的最大幂是3 ^ 19，一个数是3的幂的话，那个数一定能被最大幂整除且不存在例外，这是因为一个特殊的原因：3的幂次的质因子只有3

* [4的幂](https://leetcode.com/problems/power-of-four/)

4的幂的数的特点是，二进制里面只有1个1，而且这个1再奇数位上，也就是1 3 5...位上，只有一个1可以用n & (n - 1)确定，只有奇数位上有1，只需要和一个奇数位上全是1的数相与即可，结果应该是其本身，奇数位上全是1的数是0101....01010101，也就是0x55555555，所以 n & (n - 1) == 0 && n & 0x55555555 == n。
