class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] arr2 = new int[arr.length];
        int i = 0;
        for(int num : arr){
            arr2[i++] = num;
        }
        Arrays.sort(arr2);
        
        int[] ans = new int[arr.length];
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int j = 0; j < arr2.length; j++){
            if(!map.containsKey(arr2[j])){
                map.put(arr2[j], map.size() + 1);
            }
        }
        
        for(int j = 0; j < arr.length; j++){
            ans[j] = map.get(arr[j]);
        }
        
        return ans;

    }
}
