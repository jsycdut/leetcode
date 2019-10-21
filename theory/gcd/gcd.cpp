# include <iostream>
using namespace std;

/**
* 辗转相除法求二数的最大公约数
* n数的最大公约数也可用此法
*/
int gcd(int a, int b)
{
  //应该考虑特殊情况，比如二者中
  //有空值的情况
  //可以一个个的判断，也可以用乘法一步到位
  if(a * b == 0)
  {
    return 0;
  }

  while(a != b)
  {
    if( a < b )
    {
      b = b - a;
    }
    else if( a > b )
    {
      a = a - b;
    }
  }

  return a;
}

int recur(int a, int b)
{
  if (a == 0) return b;

  return recur(b % a, a);
}
