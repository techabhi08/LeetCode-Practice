class Solution {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            if(binarySearch(arr, arr[i] * 2) != -1 && binarySearch(arr, arr[i] * 2) != i){
                return true;
            }
        }
        return false;
    }
    
    public int binarySearch(int[] arr, int target){
        int s = 0;
        int e = arr.length - 1;
        
        while(s <= e){
            int mid = s + (e - s)/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] < target){
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        return -1;
    }
}
