class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;
        for(int num : nums) high = Math.max(high,num);
        int ans = 0;
        while(low<=high){
            int mid = low + (high - low)/2;
            int sum = func(nums,mid);
            if(sum<=threshold){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public int func(int[] arr,int mid){
        int sum = 0;
        for(int ele : arr){
            sum += Math.ceil((double)ele/mid);
        }
        return sum;
    }
}