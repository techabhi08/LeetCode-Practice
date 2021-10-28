class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        if(arr.length == 0){
            return -1;
        }
        
        int start = 0;
        int end = arr.length - 1;
        int target = 0;
        
        while(start <= end){
            int mid = start + (end - start)/2;
            target = arr[mid];
            
            if(arr[mid + 1] > target)
                start = mid + 1;
            else if(arr[mid + 1] < target)
                end = mid - 1;
            else 
                return mid;
        }
        return start;
    }
}
