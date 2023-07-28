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
        int n = mountainArr.length();
        int peakIndex = findPeak(mountainArr, n);
        
        int ans = findIndex(0, peakIndex, mountainArr, target);
        if(ans != -1){
            return ans;
        }
        return findIndex(peakIndex + 1, n - 1, mountainArr, target);
    }
    
    public int findIndex(int start, int end, MountainArray arr, int target){
        boolean isAsc = arr.get(start) < arr.get(end);
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(isAsc){
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
    
    public int findPeak(MountainArray arr, int n){
        int start = 0;
        int end = n - 1;
        
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
}