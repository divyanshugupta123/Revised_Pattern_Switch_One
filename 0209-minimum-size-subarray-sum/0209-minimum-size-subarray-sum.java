class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = 0;
        int low = 0;
        int high = nums.length;
        while(low<=high){
            int mid = low + (high-low)/2;
            boolean isPresent = isSubArrayWithLenMid(nums,mid,target);
            if(isPresent){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public boolean isSubArrayWithLenMid(int[] arr,int len,int target){
        int sum = 0;
        for(int i = 0;i<len;i++){
            sum+=arr[i];
        }
        if(sum>=target) return true;
        for(int i = len;i<arr.length;i++){
            sum+=arr[i];
            sum-=arr[i-len];
            if(sum>=target) return true;
        }
        return false;
    }
}