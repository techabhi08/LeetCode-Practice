class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int largest = 0;
        int[] ans = new int[arr1.length];
        
        //finding the largest element from arr1 
        for(int i = 0; i < arr1.length; i++){
            largest = Math.max(largest, arr1[i]);
        }
        
        //storing the count of each number that appear in arr1 in array of size largest + 1
        int[] num_count = new int[largest + 1];
        for(int i = 0; i < arr1.length; i++){
            num_count[arr1[i]]++;
        }
        
        //checking for each number in arr2 if it exists in num_count array
        //then we add that number into our ans array until the num_count of that number
        //becomes 0;
        int j = 0;
        for(int i = 0; i < arr2.length; i++){
            while((num_count[arr2[i]]--) > 0){
                ans[j++] = arr2[i];
            }
        }
        
        //adding the extra elements that were present in arr1 but not in arr2 to the 
        //resultant ans array.
        for(int i = 0; i < num_count.length; i++){
            while((num_count[i]--) > 0){
                ans[j++] = i;
            }
        }
        
        return ans;
    }
}
