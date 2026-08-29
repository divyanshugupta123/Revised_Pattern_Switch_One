class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low = 1;
        int high = 0;
        for (int idx : bloomDay)
            high = Math.max(high, idx);
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // CNB = currentNumberOfBoquet
            int CNB = bouquetInNthDay(bloomDay, mid, m, k);
            if (CNB >= m) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int bouquetInNthDay(int[] arr, int mid, int m, int k) {
        int c = 0, ans = 0;
        for (int days : arr) {
            if (days <= mid) {
                c++;
                if (c == k) {
                    ans++;
                    c = 0;
                }
            } else {
                c = 0;
            }
        }
        return ans;
    }
}