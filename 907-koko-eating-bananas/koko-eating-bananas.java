class Solution {
    public boolean check(int[] piles, int h, int mid) {
        long hour = 0;
        for (int pile : piles) {
            hour += (pile + (long)mid - 1) / mid;
            if (hour > h) return false; // early termination
        }
        return hour <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        int ans = -1;

        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (check(piles, h, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
