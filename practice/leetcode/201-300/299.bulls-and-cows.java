class Solution {
    public String getHint(String secret, String guess) {
        // 根据定义，对应索引上相等对应就是要累加到A的值
        // 不相等的就是可能要累加到B的值，至于累加多少个，取对应的字符在两个字符串中较小的
        int[] a = new int[10];
        int[] b = new int[10];
        int len = secret.length();
        int A = 0;
        for (int i = 0; i < len; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                A++;
            } else {
                a[secret.charAt(i) - '0']++;
                b[guess.charAt(i) - '0']++;
            }
        }

        int B = 0;
        for (int i = 0; i < 10; i++) {
            B += Math.min(a[i], b[i]);
        }

        return A + "A" + B + "B";
    }
}

