class Node{
    int index;
    String val;
    
    Node(int index, String val){
        this.index = index;
        this.val = val;
    }
}
class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        Map<Integer, Node[]> map = new HashMap<>();
        int[] res = new int[queries.length];
        int index = 0;
        int len = nums[0].length();
        
        for(int[] query : queries){
            if(!map.containsKey(query[1])){
                Node[] arr = new Node[nums.length];
                for(int i = 0; i < nums.length; i++){
                    String str = nums[i].substring(len - query[1], len);
                    arr[i] = new Node(i, str);
                }
                Arrays.sort(arr, (a, b) -> a.val.compareTo(b.val));
                map.put(query[1], arr);
            }
            res[index++] = map.get(query[1])[query[0] - 1].index;
        }
        return res;
    }
}