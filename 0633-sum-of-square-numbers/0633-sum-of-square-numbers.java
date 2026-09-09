class Solution {
    public boolean judgeSquareSum(int c) {
        return solution2(c);
    }
    public boolean solution2(int c){
        long i = 0;
        long j = (long)Math.floor(Math.sqrt(c));
        while(i<=j){
            if((i*i)+(j*j)==c) return true;
            else if((i*i)+(j*j)>c) j--;
            else i++;
        }
        return false;
    }
    public boolean solution1(int c){
        int range = (int)Math.floor(Math.sqrt(c));
        for(int i = 0;i<=range;i++){
            int find = c-(i*i);
            boolean isPresent = helper(find);
            if(isPresent)   return true;
        }
        return false;
    }
    public boolean helper(int num){
        int low = 0;
        int high = (int)Math.floor(Math.sqrt(num));
        while(low<=high){
            int mid = low + (high - low)/2;
            if(mid * mid==num){
                return true;
            }else if(mid*mid<num){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return false;
    }
}