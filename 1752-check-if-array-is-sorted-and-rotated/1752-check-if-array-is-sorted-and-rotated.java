class Solution {
    public boolean check(int[] nums) {
        int idx = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[(i+1)%nums.length]-nums[i]<0){
                idx++;
            }
        }
        return idx<=1?true:false;
    }
    
}