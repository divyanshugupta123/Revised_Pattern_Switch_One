class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low<high){
            int mid = low+(high-low)/2;
            // means minimum is in right side
            if(nums[mid]>nums[high]){
                low = mid + 1;
            }
            // means min is in left side
            else{
                high = mid;
            }
        }
        return nums[low];
    }
}