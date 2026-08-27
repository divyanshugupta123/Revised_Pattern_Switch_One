class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{first(nums,target),last(nums,target)};
    }
    public int last(int[] nums,int target){
        int idx = -1;
        int low = 0;
        int high = nums.length - 1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                idx = mid;
                low = mid + 1;
            }
            else if(nums[mid]>target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return idx;
    }
    public int first(int[] nums,int target){
        int idx = -1;
        int low = 0;
        int high = nums.length - 1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                idx = mid;
                high = mid - 1;
            }
            else if(nums[mid]>target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return idx;
    }
}