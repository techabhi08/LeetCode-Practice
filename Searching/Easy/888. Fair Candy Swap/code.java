class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int Asum = 0;
        int Bsum = 0;
        for(int num : aliceSizes){
            Asum += num;
        }
        
        for(int num : bobSizes){
            Bsum += num;
        }
        
        int diff = (Asum - Bsum)/ 2;
        Arrays.sort(aliceSizes);
        
        for(int num : bobSizes){
            if(findInBS(aliceSizes, num + diff) != -1){
                int[] ans = new int[]{num + diff, num};
                return ans;
            }
        }
        return null;
    }
    
    public int findInBS(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        
        while(start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
}
