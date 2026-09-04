class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // start from the last element of first row 
        // if tar is bigger then go down (col) and check
        // if tar is small then go left(row) and check
        // and if we cross the boundary that means tar is not present
        int i = 0;
        int j = matrix[0].length - 1;
        while(i<matrix.length && j>=0){
            if(matrix[i][j]==target){
                return true;
            }else if(matrix[i][j]>target){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
}