class Trie {
    private boolean isWord;

    private Trie[] next;

    /** Initialize your data structure here. */
    public Trie() {
        this.next = new Trie[26];
        this.isWord = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0)
            return;
        Trie currentNode = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (currentNode.next[index] == null) {
                currentNode.next[index] = new Trie();
            }
            currentNode = currentNode.next[index];
        }
        currentNode.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null || word.length() == 0)
            return false;
        
        Trie currentNode = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (currentNode.next[index] == null) {
                return false;
            } else {
                currentNode = currentNode.next[index];
            }
        }
        return currentNode.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0)
            return false;
        Trie currentNode = this;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (currentNode.next[index] == null) {
                return false;
            } else {
                currentNode = currentNode.next[index];
                currb
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new Trie();
 * obj.insert(word); boolean param_2 = obj.search(word); boolean param_3 = obj.startsWith(prefix);
 */
