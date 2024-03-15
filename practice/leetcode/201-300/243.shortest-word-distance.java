class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        List<Integer> a = new ArrayList<>(); // word1
        List<Integer> b = new ArrayList<>(); // word2
        for (int i = 0; i < wordsDict.length; i++){
            String s = wordsDict[i];
            if (s.equals(word1)) {
                a.add(i);
            } else if (s.equals(word2) ){
                b.add(i);
            }
        }
        int max = Math.max(a.size() , b.size());
        int i = 0, j = 0;
        int min = Integer.MAX_VALUE;
        while (i < max && j < max) {
            int val1 = i >= a.size() ? a.get(a.size() - 1) : a.get(i);
            int val2 = j >= b.size() ? b.get(b.size() - 1) : b.get(j);
            int cur = Math.abs(val1 - val2);
            min = Math.min(min, cur);
            if (val1 < val2){
                i++;
            } else {
                j++;
            }
        }

        return min;
    }
}
