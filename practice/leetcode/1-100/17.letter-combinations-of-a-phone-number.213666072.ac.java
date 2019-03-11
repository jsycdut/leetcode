class Solution {
    // I have no Chinese input method on my arch
    // so I will try to use English to explain how this solution works
    // Actually, this is a DFS problem
    // you can imagine you got n boxes, for every box, you should put one of the digits that you were told, for example
    // now, you got 3 boxes, for box 1, you can put one of 'a' 'b' 'c' to it
    // for box 2, your choice is one of 'd' 'e' 'f'
    // for box 3, 'g', 'h', 'i'

    // you need 3 steps to finish the job
    // step 1, choose a character from 'a' 'c' 'c' and put it to box 1
    // step 2, similar to step 1
    // step 3, similar to step 2

    //yes, this is a recursion, for every step , you got different
    //choices, so you should use loop inside the recursion function

    public List<String> letterCombinations(String digits) {
        // for special test case, digit is null or has no elements
        List<String> list = new ArrayList<String>();
        if (digits == null || digits.length()  == 0) return list;

        // numbers and letters mapping array
        // for string like '23', every member of the string is a character
        // so I use it's ascii code to make it an digit(from 0 to 9)
        // charcter '0' has ascii number 48, so just use digit[i] - 48
        // and you will get a real digit from 0-9, and the phone number
        // mapping started with 2 at least, so you should use
        // digit[i] - 48 - 2 to get the index of the mapping
        char[][] mapping = {
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
        };
        int step = 0;
        int end = digits.length();
        char[] result = new char[end];
        dfs(0, end, digits, mapping, result, list);
        return list;
    }

    // this is just a simple recursion cause you do not need to confirm the charater you are
    // using is used or not(you are using totally different characters on every step)
    // actually this is a simplified dfs
    void dfs(int step, int end, String digits, char[][] mapping, char[] result, List list) {
        // exit point
        if (step == end) {
            list.add(new String(result));
            return;
        }

        char[] currentChoice = mapping[digits.charAt(step) - 48 - 2];
        int len = currentChoice.length;
        for (int i = 0; i < len; i++) {
            result[step] = currentChoice[i];
            dfs(step + 1, end, digits, mapping, result, list);
        }
    }
}

