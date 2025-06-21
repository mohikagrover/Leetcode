class Solution {
    public int minimumDeletions(String word, int k) {
         Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        List<Integer> frequencies = new ArrayList<>(freqMap.values());
        int maxFreq = Collections.max(frequencies);
        int minDeletions = Integer.MAX_VALUE;
        for (int target = 1; target <= maxFreq; target++) {
            int deletions = 0;

            for (int f : frequencies) {
                if (f < target) {
                    deletions += f;  
                } else if (f > target + k) {
                    deletions += f - (target + k);  
                }
            }

            minDeletions = Math.min(minDeletions, deletions);
        }

        return minDeletions;
    }
}