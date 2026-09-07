class Solution {
    public int hIndex(int[] citations) {
        int low = 0;
        int high = citations.length;
        while(low<=high){
            int mid = low + (high-low)/2;
            boolean isPossible = possibleWithMid(citations,mid);
            if(isPossible){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return high;
    }
    public boolean possibleWithMid(int[] arr, int mid){
        int c = 0;
        for(int ele : arr){
            if(ele>=mid)    c++;
        }
        return c>=mid?true:false;
    }
}