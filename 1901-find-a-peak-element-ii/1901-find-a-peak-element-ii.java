class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int columns = mat[0].length;
        int low = 0, high = columns - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int maxIndex = findMax(mat, mid);
            int left = mid - 1 >= 0 ? mat[maxIndex][mid - 1] : -1;
            int right = mid + 1 < columns  ? mat[maxIndex][mid + 1] : -1;
            if (mat[maxIndex][mid] > left && mat[maxIndex][mid] > right) {
                return new int[] { maxIndex, mid };
            } else if (mat[maxIndex][mid] < left) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[] { -1, -1 };
    }

    public int findMax(int[][] arr, int mid) {
        int max = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][mid] > max) {
                max = arr[i][mid];
                idx = i;
            }
        }
        return idx;
    }
}