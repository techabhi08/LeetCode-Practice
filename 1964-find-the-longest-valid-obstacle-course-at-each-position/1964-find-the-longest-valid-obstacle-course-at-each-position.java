class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int[] ans = new int[obstacles.length];
        int[] seq = new int[obstacles.length];
        int i = -1;
        int ansIndex = 0;
        int seqSize = -1;
        
        for(int height : obstacles){
            if(i == -1 || seq[i] <= height){
                seq[++i] = height;
                seqSize = i;
            }else{
                int index = binarySearch(seq, 0, i, height);
                seq[index] = height;
                seqSize = index;
            }
            ans[ansIndex++] = seqSize + 1;
        }
        return ans;
    }
    
    public int binarySearch(int[] arr, int start, int end, int target){
        int boundary = 0;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] > target){
                boundary = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return boundary;
    }
}