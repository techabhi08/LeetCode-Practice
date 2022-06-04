/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeakElement(mountainArr);
        int ans = binarySearch(mountainArr, target, 0, peak);
        if(ans == -1){
            return binarySearch(mountainArr, target, peak + 1, mountainArr.length() - 1);
        }else{
            return ans;
        }
    }
    
    public int findPeakElement(MountainArray arr){
        int start = 0;
        int end = arr.length() - 1;
        
        while(start < end){
            int mid = start + (end - start) / 2;
            if(arr.get(mid) > arr.get(mid + 1)){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }
    
    public int binarySearch(MountainArray arr, int target, int start, int end){
        boolean Asc = (arr.get(start) < arr.get(end));
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(Asc){
               if(arr.get(mid) < target){
                   start = mid + 1;
               }else{
                   end = mid - 1;
               } 
            }else{
                if(arr.get(mid) < target){
                   end = mid - 1;
               }else{
                   start = mid + 1;
               } 
            }
            
            if(arr.get(mid) == target){
                return mid;
            }
        }
        return -1;
    }
}
