class Solution {
    public int findKthPositive(int[] arr, int k) {
        // return bruteForce(arr,k);
        return binarySearch(arr,k);
    }
    public int bruteForce(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (k >= arr[i]) {
                k++;
            } else {
                break;
            }
        }
        return k;
    }
    public int binarySearch(int[] arr,int k){
        int low = 0;
        int high = arr.length - 1;
        while(low<=high){
            int mid = low + (high-low)/2;
            int missingAtMidthIdx = arr[mid] - (mid + 1);
            if(missingAtMidthIdx<k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return k + high + 1;
    }
}