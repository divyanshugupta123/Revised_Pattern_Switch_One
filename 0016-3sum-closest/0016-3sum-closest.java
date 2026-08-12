class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];
        for(int i = 0;i<len;i++){
            int j = i+1;
            int k = len-1;
            while(j<k){
                int cur_sum = nums[i] + nums[j] + nums[k];
                if(Math.abs(cur_sum-target)<Math.abs(sum-target)){
                    sum = cur_sum;
                }else if(cur_sum<target)    j++;
                else k--;
            }
        }
        return sum;
    }
}