class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int low = 0;
        int high = mat[0].length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int maxIndex = indexMax(mat, mid);
            int left = mid - 1 >= 0 ? mat[maxIndex][mid - 1] : -1;
            int right = mid + 1 < mat[0].length ? mat[maxIndex][mid + 1] : -1;
            if (mat[maxIndex][mid] > left && mat[maxIndex][mid] > right) {
                return new int[] { maxIndex, mid };
            } else if (mat[maxIndex][mid] < left) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{-1,-1};
    }

    public int indexMax(int[][] arr, int col) {
        int idx = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][col] > max) {
                max = arr[i][col];
                idx = i;
            }
        }
        return idx;
    }
}