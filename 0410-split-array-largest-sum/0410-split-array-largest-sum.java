class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        for (int ele : nums) {
            low = Math.max(low, ele);
            high += ele;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            boolean isPossible = canSubArrayPossible(nums, mid, k);
            if (isPossible) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean canSubArrayPossible(int[] arr, int largestSum, int numberOfSubArray) {
        int subArrCreated = 1;
        int sum = 0;
        for (int ele : arr) {
            if (sum + ele > largestSum) {
                subArrCreated++;
                sum = ele;
            } else {
                sum += ele;
            }
        }
        if (subArrCreated > numberOfSubArray)
            return false;
        else
            return true;
    }
}