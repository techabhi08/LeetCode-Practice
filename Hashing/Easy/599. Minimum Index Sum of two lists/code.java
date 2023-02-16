class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> freq = new HashMap<>();
        
        for(int i = 0; i < list1.length; i++){
            freq.put(list1[i], i);
        }
        
        List<String> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int sum;
        for(int j = 0; j < list2.length && j <= min; j++){
            if(freq.containsKey(list2[j])){
                sum = j + freq.get(list2[j]);
                if(sum < min){
                    ans.clear();
                    ans.add(list2[j]);
                    min = sum;
                }else if(sum == min){
                    ans.add(list2[j]);
                }
            }
        }
        
        String[] result = new String[ans.size()];
        int index = 0;
        for(String str : ans){
            result[index++] = str;
        }
        return result;
    }
}
