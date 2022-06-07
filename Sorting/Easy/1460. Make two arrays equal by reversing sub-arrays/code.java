class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] bucket = new int[1001];
        
        for(int i = 0; i < target.length; i++){
            bucket[target[i]]++;
            bucket[arr[i]]--;
        }
        
        for(int num : bucket){
            if(num != 0){
                return false;
            }
        }
        return true;
    }
}
