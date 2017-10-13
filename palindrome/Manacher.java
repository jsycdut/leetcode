/*
 *Manacher算法，也就是大名鼎鼎的马拉车算法
 *用于在O(n)的时间复杂度里求解给定字符串的最长子串
 *主要精神有三点
 *1.对字符进行特殊处理，即加入#符号用于将奇回文和偶回文统一
 *2.对越界进行处理，在1的基础上在字符串首尾加上更不可能匹配的特殊字符
 *  如^和$，加什么不重要，我用^和$的原因不过是因为正则的影响而已
 *3.利用大回文会包含可能裹在其中的小回文的原理，可以利用以前求过的信息
 *  来加速新的位置的回文的求解
 *manacher[i]的意思是i这个字符所在位置的回文边界到回文中心的距离
 *注意，manacher算法中添加的特殊字符是什么并不重要，你就是添加一个字母
 *比如a都可以，这不影响结果，加字符的原因只是为了解决奇回文和偶回文的
 *区别，在进行加特殊字符的处理之后，不管原来你的字符串是奇数长度还是偶数
 *长度，都会变成奇数长度，使得求解回文串中的中间向两边扩的方式得以应用
 *时刻注意可能的数组越界，比如for循环里面的边界
 */
public class Manacher{
	public String manacherAlgorithm(String s){
		if(s == null || s.length() == 0){
			return s;
		}
		StringBuilder  stringBuilder = new StringBuilder("^#");
		for(int i = 0; i < s.length(); i++){
			stringBuilder.append(s.charAt(i));
			stringBuilder.append("#");
		}
		stringBuilder.append("$");
		int middlePointer = 0;
		int rightPointer = 0;
		int maxPointer = 0;
		int[] manacher = new int[stringBuilder.length()];
		for(int i = 1; i < stringBuilder.length() - 1; i++){
			manacher[i] = i > rightPointer ? 1 : Math.min(rightPointer - i, manacher[2 * middlePointer - i]);
			while(stringBuilder.charAt(i + manacher[i]) == stringBuilder.charAt(i - manacher[i])){
				manacher[i] += 1;
			}
			if(i + manacher[i] > rightPointer){
				rightPointer = i + manacher[i];
				middlePointer = i;
			}
			maxPointer = manacher[i] > maxPointer ? i : maxPointer;
		}
		int subLength = manacher[maxPointer] / 2;
		int startPosition = maxPointer - manacher[maxPointer] + 2;
		int subStartPosition = (startPosition / 2) - 1;
		return s.substring(subStartPosition, subStartPosition + subLength);
	}
}
