class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for (int ele : weights){
            low = Math.max(low,ele);
            high += ele;
        }
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int numberOfDays = func(weights, mid);
            if (numberOfDays <= days) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int func(int[] arr, int mid) {
        int days = 1;
        int sum = 0;
        for (int ele : arr) {
            if(ele+sum>mid){
                days++;
                sum = ele;
            }else{
                sum+=ele;
            }
        }
        return days;
    }
}