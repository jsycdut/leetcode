/**
 * https://leetcode-cn.com/problems/lru-cache/
 * LRU的精髓就在双向链表 + 哈希表
 * 在jdk里面有个 LinkedHashMap完美满足这个条件，并且提供了移除最老元素的接口
 * 所以可以通过此方法来取巧，另外就算不用这个东西，也可以用LinkedList这个双向链表+HashMap来搞
 * 实在不行，可以自己写双向链表，然后结合HashMap，自己造一个HashMap还是算了
 */
class LRUCache {
    // 这个做法效率低，因为需要O(N)的复杂度去查找对应的值
    int capacity;
    LinkedList<Integer> leastUsedKeys;
    Map<Integer, Integer> mappings;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.leastUsedKeys = new LinkedList<>();
        this.mappings = new HashMap<>();
    }

    /**
     * need to put the used value at first
     */
    public int get(int key) {
        if (!this.mappings.containsKey(key)) return -1;

        this.leastUsedKeys.remove((Integer)key); // remove(int index) remove(Object target)
        this.leastUsedKeys.addFirst(key);
        return this.mappings.get(key);
    }

    /**
     * 1. check the key exist or not, if exist, update value, make it first at the leastUsedKeys
     * 2. if not exist, check capacity, if full, remove the last one at the leastUseKeys and insert the key
     */
    public void put(int key, int value) {
        // find existing mapping, update value and put it at the front
        if (this.mappings.containsKey(key)) {
            this.mappings.put(key, value);
            this.leastUsedKeys.remove((Integer)key);
            this.leastUsedKeys.addFirst(key);
            return;
        }

        // key not exist, if full, remove the last
        if (this.leastUsedKeys.size() == this.capacity) {
            int obsoleteKey = this.leastUsedKeys.removeLast();
            this.mappings.remove(obsoleteKey);
        }
        
        this.leastUsedKeys.addFirst(key);
        this.mappings.put(key, value);
    }
}

/**
 * The Faster Way, use hashmap to locate the Node to be removed
 * and the double-linked-list is easy to remove the node
 */
class LRUCache {
    int capacity;    
    Node head;
    Node tail;
    Map<Integer, Node> mappings;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.mappings = new HashMap<>();
    }
    
    public int get(int key) {
        if (!mappings.containsKey(key)) return -1;
        
        Node node = mappings.get(key);
        removeNode(node);
        addNodeAfterDummyHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (mappings.containsKey(key)) {
            Node node = mappings.get(key);
            node.value = value;
            removeNode(node);
            addNodeAfterDummyHead(node);
            return;
        }

        Node node = new Node(key, value);
        node.value = value;
        mappings.put(key, node);
        addNodeAfterDummyHead(node);

        if (mappings.size() > this.capacity) {
            removeNodeBeforeDummyTail();
        }
    }

    void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null; // hep GC
        node.prev = null;
    }

    void addNodeAfterDummyHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    void removeNodeBeforeDummyTail() {
        Node toBeRemoved = tail.prev;
        this.removeNode(toBeRemoved);
        this.mappings.remove(toBeRemoved.key);
    }
    
    private class Node {
        Node prev;
        Node next;
        int key;
        int value;

        public Node(int key, int vlaue) {
            this.key = key;
            this.value = value;
        }
    }
}


