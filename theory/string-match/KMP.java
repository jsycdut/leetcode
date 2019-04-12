/**
 * KMP algorithm
 * This is a algorithm for searching the string in the given text
 * the runtime complexity is O(n)
 *
 *To write the KMP in a simple way is not so easy
 *Some guys who write the blogs about kmp algorithm, I got to confess, they may
 *truly understand it, but they just write it in a mess.
 *Some guys just uses too much if && else, and they use while in their for loop centences. 
 *
 *This KMP written by me may be the easiest and the simplest alg you've ever read,
 *Just enjoy it.
 */
public class KMP{
	public static int[] getNextArray(String pattern){
		int length = pattern.length();
		int[] next = new int[length];
		next[0] = -1;
		int k = -1;
		int j = 0;
		while(j < length -1){
			if(k == -1 || pattern.charAt(j) == pattern.charAt(k)){
				j++;
				k++;
				if(pattern.charAt(j) != pattern.charAt(k)){
					next[j] = k;
				}else{
					next[j] = next[k];
				}
			}else{
				k = next[k];
			}
		}
		return next;
	}

	public static int searchInKMP(String source, String pattern){
		if(source == null || pattern == null || pattern.length() > source.length()){
			return -1;
		}
		int[] next = getNextArray(pattern);
		int i = 0;
		int j = 0;
		while(i <= source.length() - pattern.length() && j < pattern.length()){
			if(j == -1 || source.charAt(i) == pattern.charAt(j)){
				i++;
				j++;
			}else{
				j = next[j];
			}
		}
		return j == pattern.length() ? i - j : -1;
	}


