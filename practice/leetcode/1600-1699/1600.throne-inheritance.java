class ThroneInheritance {
    // 继承顺序翻译出来就是一棵树的前序遍历，根左....右，子节点按照出生顺序逐个添加到list里面
    // Successor(x, curOrder):
    // 如果 x 没有孩子或者所有 x 的孩子都在 curOrder 中：=> x是叶子结点，或者它的子树已经被访问过了
        // 如果 x 是国王，那么返回 null  => 根节点，返回
        // 否则，返回 Successor(x 的父亲, curOrder)  => 回到父节点，继续访问
    // 否则，返回 x 不在 curOrder 中最年长的孩子  => 下一个按顺序访问的子节点
    Map<String, Node> map;
    Node king;

    public ThroneInheritance(String kingName) {
        map = new HashMap<>();
        Node king = new Node();
        king.name = kingName;
        map.put(kingName, king);
        this.king = king;
    }

    public void birth(String parentName, String childName) {
        Node parent = map.get(parentName);
        Node child = new Node();
        child.name = childName;
        parent.children.add(child);
        map.put(childName, child);
    }

    public void death(String name) {
        Node node = map.get(name);
        node.alive = false;
    }

    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        successor(king.name, order);
        return order;
    }

    void successor(String cur, List<String> order) {
        // 这个继承顺序翻译出来，就是树的前序遍历
        Node node = map.get(cur);
        if (node.alive) {
            order.add(cur);
        }
        List<Node> children = node.children;
        for (Node child : children) {
            successor(child.name, order);
        }
    }

    class Node {
        String name;
        boolean alive = true;
        List<Node> children = new ArrayList<>();
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */
