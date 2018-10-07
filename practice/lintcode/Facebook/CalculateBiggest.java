public class  CalculateBiggest{
	//  lintcode facebook
	//  http://www.lintcode.com/zh-cn/problem/calculate-maximum-value/
	//  ascii 0 = 48，ascii 1 = 49
	//  加上char值本来可以直接用作数值
	//  要想值最大，逢0或1必加
	//  逢sum为0或1必加
	//  其余必乘，所以几行代码就搞定了
	public int calcMaxValue(String str){
		int sum = 0;
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) == 48 || str.charAt(i) == 49 || sum == 0 || sum == 1){
				sum += (str.charAt(i) - 48);
			}else{
				sum *= (str.charAt(i) - 48);
			}
		}
		return sum;
	}
}
