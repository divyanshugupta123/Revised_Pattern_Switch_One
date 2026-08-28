class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        int ans = 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int totalTime = func(piles, mid);
            if (totalTime <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int func(int[] arr, int mid) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++)
            ans += Math.ceil((double)(arr[i]) / mid);
        return ans;
    }
}