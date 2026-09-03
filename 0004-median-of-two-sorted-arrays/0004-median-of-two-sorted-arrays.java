class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        int low = 0;
        int high = nums1.length;
        int left = (nums1.length + nums2.length + 1) / 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            int mid2 = left - mid;
            int l1 = mid - 1 >= 0 ? nums1[mid - 1] : Integer.MIN_VALUE;
            int r1 = mid <= nums1.length - 1 ? nums1[mid] : Integer.MAX_VALUE;
            int l2 = mid2 - 1 >= 0 ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int r2 = mid2 <= nums2.length - 1 ? nums2[mid2] : Integer.MAX_VALUE;
            if (l1 <= r2 && l2 <= r1) {
                if ((nums1.length + nums2.length) % 2 == 0)
                    return (double)(Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                else
                    return (double) Math.max(l1, l2);
            } else if (l1 > r2) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}