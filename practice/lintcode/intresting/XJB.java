/*
 *The output of this program are first 5 emoij in unicode
 *just like this 😂
 */
public class XJB{
	public static void main(String[] args){
		int[] foo = {0x1f601, 0x1f602, 0x1f603, 0x1f604, 0x1f605};
		String s = new String(foo, 0, 5);
		System.out.println(s);
	}
}
