class Solution {
    public int maximum69Number (int num) {
        List<Integer> list = new ArrayList<>();
        while(num != 0){
            int rem = num % 10;
            list.add(rem);
            num /= 10;
        }
        
        int ans = 0;
        boolean changed = false;
        for(int i = list.size() - 1; i >= 0; i--){
            if(list.get(i) == 6 && !changed){
                ans = ans * 10 + 9;
                changed = true;
            }else{
                ans = ans * 10 + list.get(i);
            }
        }
        return ans;
    }
}
