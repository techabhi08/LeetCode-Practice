class Solution {
    public int heightChecker(int[] heights) {
        
        // using counting sort
        int[] buckets = createBuck(heights);
        int nextValidNum = 0;
        int wrongIndexCount = 0;
        
        for(int i = 0; i < heights.length; i++){
            nextValidNum = findNextValid(buckets, nextValidNum);
            if(heights[i] != nextValidNum){
                wrongIndexCount++;
            }
            buckets[nextValidNum]--;
        }
        return wrongIndexCount;
    }
    
    public int[] createBuck(int[] arr){
        int[] buckets = new int[101];
        for(int num : arr){
            buckets[num]++;
        }
        return buckets;
    }
    
    public int findNextValid(int[] buckets, int currNum){
        while(buckets[currNum] == 0){
            currNum++;
        }
        return currNum;
    }
        
        
        
        
        
        
        
        
        
        
//         int j = 0;
//         int[] original = new int[heights.length];
//         for(int num : heights){
//             original[j] = num;
//             j++;
//         }
        
//         Arrays.sort(heights);
//         int[] expected = heights;
        
//         int count = 0;
//         int i = original.length - 1;
        
//         while(i >= 0){
//             if(original[i] != heights[i]){
//                 count++;
//             }
//             i--;
//         }
        
//         return count;
        
        
//     }
}
