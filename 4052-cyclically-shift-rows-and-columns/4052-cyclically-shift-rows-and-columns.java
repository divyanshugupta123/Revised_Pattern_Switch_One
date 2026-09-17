class Solution {
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        for (int i = 0; i < grid.length; i++) {
            rotateLeft(grid[i], rowShift[i]);
        }
        for (int col = 0; col < colShift.length; col++) {
            int[] temp = new int[n];
            for (int row = 0; row < n; row++) {
                temp[row] = grid[row][col];
            }
            rotateLeft(temp, colShift[col]);
            for (int row = 0; row < n; row++) {
                grid[row][col] = temp[row];
            }
        }
        return grid;
    }
    public void rotateLeft(int[] arr, int k) {
        k = k % arr.length;
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }

    public void reverse(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}