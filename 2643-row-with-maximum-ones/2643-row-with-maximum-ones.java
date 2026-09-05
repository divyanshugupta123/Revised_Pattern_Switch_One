class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int idx = 0;
        int c = 0;
        for (int i = 0; i < mat.length; i++) {
            int count = count1InRow(mat[i]);
            if (count > c) {
                idx = i;
                c = count;
            }
        }
        return new int[]{idx,c};
    }

    public int count1InRow(int[] arr) {
        Arrays.sort(arr);
        if (arr[0] == 1) {
            return arr.length;
        }
        if (arr[arr.length - 1] == 0) {
            return 0;
        }
        int low = 1;
        int high = arr.length - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == 1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return arr.length - low;
    }
}