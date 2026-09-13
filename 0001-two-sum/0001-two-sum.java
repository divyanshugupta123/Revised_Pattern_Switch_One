class Solution {
    public int[] twoSum(int[] nums, int target) {
        return solution1(nums,target);
    }
    public int[] solution1(int[] arr,int tar){
        for(int i = 0;i<arr.length;i++){
            for(int j = i+1;j<arr.length;j++){
                if(arr[i]+arr[j]==tar){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
}