class Solution {
    public int countNegatives(int[][] grid) {
        // return solution1(grid);
        return solution2(grid);
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
            if(arr[mid]>=0){
                low = mid +1;
            }else{
                high = mid - 1;
            }
        }
        return arr.length - low;
    }
}