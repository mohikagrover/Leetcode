class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        List<Integer> oddFreqs = new ArrayList<>();
        List<Integer> evenFreqs = new ArrayList<>();
        for (int count : freq) {
            if (count > 0) {
                if (count % 2 == 0) {
                    evenFreqs.add(count);
                } else {
                    oddFreqs.add(count);
                }
            }
        }

        int maxDiff = Integer.MIN_VALUE;
        boolean found = false;

        for (int odd : oddFreqs) {
            for (int even : evenFreqs) {
                maxDiff = Math.max(maxDiff, odd - even);
                found = true;
            }
        }
        return found ? maxDiff : 0;
    }
}