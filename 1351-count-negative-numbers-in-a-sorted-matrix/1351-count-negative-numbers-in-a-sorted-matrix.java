class Solution {
    public int countNegatives(int[][] grid) {
        // return solution1(grid);
        // return solution2(grid);
        return solution3(grid);
    }

    public int solution1(int[][] mat) {
        int c = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] < 0)
                    c++;
            }
        }
        return c;
    }

    public int solution2(int[][] mat) {
        int c = 0;
        for (int i = 0; i < mat.length; i++) {
            c += helper(mat[i]);
        }
        return c;
    }

    public int helper(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return arr.length - low;
    }

    public int solution3(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        int r = arr.length - 1;
        int c = 0;
        int count = 0;
        while (r >= 0 && c < cols) {
            if (arr[r][c] >= 0) {
                c++;
            } else {
                count += (cols - c);
                r--;
            }
        }
        return count;
    }
}