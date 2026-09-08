class Solution {
    public int removeDuplicates(int[] nums) {
        List<Integer> ans = helper(nums);
        for (int i = 0; i < ans.size(); i++)
            nums[i] = ans.get(i);
        return ans.size();
    }

    public List<Integer> helper(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 0) {
                list.add(nums[i]);
            }
        }
        return list;
    }
}