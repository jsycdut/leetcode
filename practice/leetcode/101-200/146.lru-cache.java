/**
 * https://leetcode-cn.com/problems/lru-cache/
 * 
 */

class LRUCache {
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
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
