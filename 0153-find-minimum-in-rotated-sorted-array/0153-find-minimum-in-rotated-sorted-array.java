class Solution {
    public int findMin(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int low = 0;
        int high = nums.length - 1;
        while(low<=high){
            int mid = low + (high - low)/2;
            // we know one part is surely sorted 
            // if left then the low is smallest
            if(nums[low]<=nums[mid]){
                ans = ans>nums[low] ? nums[low] : ans;
                // now check for min on right side
                low = mid + 1;
            }else{
                // if right is sorted then mid is smallest
                ans = ans>nums[mid]?nums[mid]:ans;
                // ans check in left side
                high = mid - 1;
            }
        }
        return ans;
    }
}