class Solution {
    public int missingNumber(int[] nums) {
        int totalSum = (nums.length * (nums.length+1))/2;
        int currSum = 0;
        for(int ele : nums){
            currSum += ele;
        }
        return totalSum - currSum;
    }
}