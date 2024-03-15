class WordDistance {
    Map<String, List<Integer>> map;

    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            String s = wordsDict[i];
            List<Integer> p = map.get(s);
            if (p == null) {
                p = new ArrayList<>();
                map.put(s, p);
            }
            p.add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> a = map.get(word1);
        List<Integer> b = map.get(word2);

        int i = 0, j = 0;
        int min = Integer.MAX_VALUE;
        while (i < a.size() && j < b.size()) {
            int val1 = a.get(i);
            int val2 = b.get(j);
            int cur = Math.abs(val1 - val2);
            min = Math.min(min, cur);
            if (val1 < val2) {
                i++;
            } else {
                j++;
            }
        }

        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */
