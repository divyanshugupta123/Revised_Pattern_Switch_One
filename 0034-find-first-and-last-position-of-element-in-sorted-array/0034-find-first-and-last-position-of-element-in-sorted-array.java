class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{findFirst(nums,target),findLast(nums,target)};
    }
    public int findFirst(int[] arr,int target){
        int low = 0;
        int high = arr.length-1;
        int idx = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]==target){
                idx = mid;
                high = mid - 1;
            }else if(arr[mid]>target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return idx;
    }
    public int findLast(int[] arr,int target){
        int low = 0;
        int high = arr.length-1;
        int idx = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]==target){
                idx = mid;
                low = mid + 1;
            }else if(arr[mid]>target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return idx;
    }
}