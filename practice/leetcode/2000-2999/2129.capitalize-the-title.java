class Solution {
    public String capitalizeTitle(String title) {
        title += " ";
        char[] arr = title.toCharArray();
        int len = arr.length;
        int i = 0;
        int j = 0;
        while (i < len && j < len) {
            while (arr[j] != ' ') {
                j++;
            }

            int t = i;
            while (i != j && i < len) { // 统统变小写
                int x = arr[i] - 'A';
                if (0 <= x && x < 26) { // 大写字母，转小写字母
                    arr[i] = (char) (arr[i] + 32);
                }

                i++;
            }

            int x = arr[t] - 'a';
            if (j - t > 2) {
                // 首字母小写变大写
                if (0 <= x && x < 26) {
                    arr[t] = (char) (arr[t] - 32);
                }
            }
            i++;
            j++;

        }

        return new String(arr).trim();
    }
}
