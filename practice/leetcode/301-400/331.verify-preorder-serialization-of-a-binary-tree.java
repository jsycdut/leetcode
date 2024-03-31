class Solution {
    public boolean isValidSerialization(String preorder) {
        // 给根节点的入度
        // 只要是一颗合法的树，其入度和出度之和必为0
        // 新产生一个节点，它需要消耗父节点的1个出度，并且产生自己的两个出度（即使这个节点是叶子结点）
        int d = 1;
        int idx = 0;
        char[] arr = preorder.toCharArray();
        int n = arr.length;
        while (idx < n) {
            // 因为要处理后面的节点，必须要有足够的度留给后面的节点来消耗
            if (d == 0) {
                return false;
            }

            // 分隔符，不鸟他
            if (arr[idx] == ',') {
                idx++;
                continue;
            }

            if (arr[idx] == '#') {
                // 叶子节点，消耗图中的度
                d--;
                idx++;
            } else {
                // 非叶子节点(数字)，消耗1个度，产生2个度，等价于d++
                d -= 1;
                d += 2;
                while (idx < n && Character.isDigit(arr[idx])) {
                    idx++;
                }
            }
        }

        return d == 0;
    }
}
