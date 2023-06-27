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
        int peakIndex = findPeak(mountainArr);
        
        int ans = binarySearch(0, peakIndex, mountainArr, target);
        if(ans != -1){
            return ans;
        }
        return binarySearch(peakIndex + 1, n - 1, mountainArr, target);
    }
    
    public int binarySearch(int start, int end, MountainArray m, int target){
        boolean isAsc = m.get(start) < m.get(end);
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(isAsc){
                if(m.get(mid) < target){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }else{
                if(m.get(mid) < target){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
            
            if(m.get(mid) == target){
                return mid;
            }
        }
        return -1;
    }
    
    public int findPeak(MountainArray m){
        int start = 0;
        int end = m.length() - 1;
        
        while(start < end){
            int mid = start + (end - start) / 2;
            if(m.get(mid) > m.get(mid + 1)){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }
}