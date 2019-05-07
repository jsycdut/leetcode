/**
 * 翻转字符串(思路:两次翻转, 第一次翻转整个字符串, 第二次按照空格分割, 然后进行翻转)
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class Solution {
    public String ReverseSentence(String str) {
        // 边界条件
        if (str == null || str.length() == 0) return "";

        char[] arr = str.toCharArray();

        // 第一轮, 全局翻转
        reverse(arr, 0, arr.length - 1);

        // 第二轮，单词翻转
        int begin = 0;
        int end = 0;

        while (begin < arr.length) {
             if (end < arr.length && arr[end] != ' ') {
                 end++;
             } else {
                 reverse(arr, begin, end - 1);
                 begin = ++end;
             }
        }
        return new String(arr);
    }

    public void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}

