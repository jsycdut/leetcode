class Solution {
    public String finalString(String s) {
        // 偶数次，末尾添加，不用翻转
        // 奇数次，队首添加，需要反正
        // poimic
        // po
        // opm
        // mpo
        // mpoc
        int cnt = 0;
        char[] arr = s.toCharArray();
        Deque<Character> dq = new ArrayDeque<>();
        boolean tail = true;
        for (char c : arr) {
            if (c == 'i') {
                tail = !tail;
                continue;
            }
            if (tail) {
                // 偶数次
                dq.addLast(c);
            } else {
                dq.addFirst(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : dq) {
            sb.append(c);
        }

        if (tail) {
            return sb.toString();
        }

        return sb.reverse().toString();
    }
}
