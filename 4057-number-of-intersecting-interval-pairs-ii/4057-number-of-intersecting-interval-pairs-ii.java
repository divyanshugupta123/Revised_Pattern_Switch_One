class Solution {
    private int helperFunction(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low+(high-low)/2;
            if (arr[mid] < target) low = mid + 1;
            else high = mid;
        }
        return low;
    }
    public long countIntersectingIntervals(int[][] intervals) {
        int n = intervals.length;
        int[] firstRoww = new int[n];
        int[] secondColumn = new int[n];
        for (int i = 0; i < n; i++) {
            firstRoww[i] = intervals[i][0];
            secondColumn[i] = intervals[i][1];
        }
        int[][] tempMatStoreIntervals = intervals;
        Arrays.sort(secondColumn);
        long numberOfPairsGenerated = (long) n * (n - 1) / 2;
        long pairsNotIntersectsOther = 0;
        for (int iterateFirstColumn : firstRoww) pairsNotIntersectsOther += helperFunction(secondColumn, iterateFirstColumn);

        return numberOfPairsGenerated - pairsNotIntersectsOther;
    }
}