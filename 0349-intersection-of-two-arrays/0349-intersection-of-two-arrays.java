class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1>len2){
            return intersection(nums2,nums1);
        }
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for(int i = 0;i<len1;i++){
            boolean isFound = helper(nums2,nums1[i]);
            if(isFound &&(ans.isEmpty() || ans.get(ans.size()-1)!=nums1[i]))  ans.add(nums1[i]);
        }
        int[] arr = new int[ans.size()];
        for(int i = 0;i<ans.size();i++){
            arr[i] = ans.get(i);
        }
        return arr;
    }
    public boolean helper(int[] arr,int tar){
        int low = 0;
        int high = arr.length - 1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]==tar)   return true;
            else if(arr[mid]>tar) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
}