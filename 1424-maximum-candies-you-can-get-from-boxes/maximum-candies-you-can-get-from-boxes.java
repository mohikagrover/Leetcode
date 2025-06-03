class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
         int n = status.length;
        boolean[] hasKey = new boolean[n];
        boolean[] hasBox = new boolean[n];
        boolean[] opened = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();

        for (int box : initialBoxes) {
            hasBox[box] = true;
        }

        int totalCandies = 0;
        boolean progress = true;

        // Keep checking boxes as long as we are making progress (opening at least one new box)
        while (progress) {
            progress = false;

            for (int i = 0; i < n; i++) {
                // Only open if we have the box and it's open or we have the key, and not already opened
                if (hasBox[i] && (status[i] == 1 || hasKey[i]) && !opened[i]) {
                    totalCandies += candies[i];
                    opened[i] = true;
                    progress = true;

                    // Collect new keys
                    for (int key : keys[i]) {
                        hasKey[key] = true;
                    }

                    // Collect new boxes
                    for (int box : containedBoxes[i]) {
                        hasBox[box] = true;
                    }
                }
            }
        }

        return totalCandies;

    }
}