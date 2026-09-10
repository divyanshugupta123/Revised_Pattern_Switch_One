class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = Integer.MIN_VALUE;
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                counter++;
            } else {
                max = Math.max(counter, max);
                counter = 0;
            }
        }
        return Math.max(counter,max);
    }
}