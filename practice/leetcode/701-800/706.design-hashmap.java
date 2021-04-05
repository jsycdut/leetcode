class MyHashMap {

    Mapping[] mappings;
    int size;
    /** Initialize your data structure here. */
    public MyHashMap() {
      this.mappings = new Mapping[10_002];
      this.size = 0;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
      int index = isExist(key);
      if (index != -1) {
        mappings[index].value = value;
        return;
      }

      mappings[size++] = new Mapping(key, value);
      sort();
      return;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
      int index = isExist(key);
      //if (key == 11) System.out.println(index);
      if (index == -1) return -1;
      return mappings[index].value;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
      int index = isExist(key);
      if (index == -1) return;
      System.arraycopy(mappings, index + 1, mappings, index, size - index - 1);
      size--;
      sort();
    }

    private void sort() {
      Arrays.sort(mappings, 0, size, (m1, m2) -> m1.key - m2.key < 0 ? -1 : 1);
    }

    private int isExist(int key) {
      int lo = 0;
      int hi = size - 1;
      while (lo <= hi) {
        int mid = (lo + hi) >>> 1;
        if (mappings[mid].key < key) {
          lo = mid + 1;
        } else if (mappings[mid].key > key) {
          hi = mid - 1;
        } else {
          return mid;
        }
      }

      return -1;
    }

    private static class Mapping {
      int key;
      int value;
      public Mapping(int key, int value) {
        this.key = key;
        this.value = value;
      }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
