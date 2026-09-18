class Solution {
    public int countSpecialIntegers(int[] nums) {
        int count = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        for (List<Integer> lists : map.values()) {
            if (lists.size() >= 3) {
                int dist = lists.get(1) - lists.get(0);
                boolean flag = false;
                for (int i = 2; i < lists.size(); i++) {
                    int dist2 = lists.get(i) - lists.get(i - 1);
                    if (dist2 != dist) {
                        flag = true;
                        break;
                    }
                }
                if (!flag)
                    count++;
            }
        }
        return count;
    }
}