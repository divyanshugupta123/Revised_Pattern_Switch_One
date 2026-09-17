class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int[] answer = new int[2];
        int aCandy = 0, bCandy = 0;
        for (int i = 0; i < aliceSizes.length; i++) {
            aCandy += aliceSizes[i];
        }
        for (int i = 0; i < bobSizes.length; i++) {
            bCandy += bobSizes[i];
        }
        int equalCandy = (aCandy + bCandy)/2;
        HashSet<Integer> set = new HashSet<>();
        for(int candy : bobSizes){
            set.add(candy);
        }
        for(int candy : aliceSizes){
            if(set.contains(equalCandy-aCandy+candy)){
                answer[0] = candy;
                answer[1] = equalCandy-aCandy+candy;
            }
        }
        return answer;
    }
}