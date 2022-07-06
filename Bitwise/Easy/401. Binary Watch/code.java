class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        if(turnedOn < 0 || turnedOn > 10 ){
            return new ArrayList<>();
        }
        
        List<String> ans = new ArrayList<>();
        for(int hour = 0; hour < 12; hour++){
            for(int min = 0; min < 60; min++){
                if(Integer.bitCount(hour) + Integer.bitCount(min) == turnedOn){
                    ans.add(String.format("%d:%02d", hour, min));
                }
            }
        }
        return ans;
        
        
//         Method 2
        // List<String> ans = new ArrayList<>();
        // for(int hour = 0; hour < 12; hour++){
        //     for(int min = 0; min < 60; min++){
        //         if(countBits(hour) + countBits(min) == turnedOn){
        //             ans.add(String.format("%d:%02d", hour, min));
        //         }
        //     }
        // }
        // return ans;
//     }
    
//     public int countBits(int num){
//         int count = 0;
//         while(num > 0){
//             if((num & 1) != 0){
//                 count++;
//             }
//             num = num >> 1;
//         }
//         return count;
    }
}
