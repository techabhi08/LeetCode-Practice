class Solution {
    public String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        if(num < 0){
            flag = true;
        }
        num = Math.abs(num);
        while(num != 0){
            int rem = num % 7;
            sb.append(rem);
            num /= 7;
        }
        
        String ans = "";
        if(flag){
            ans += '-';
        }
        ans += sb.reverse().toString();
        return ans.length() == 0 ? "0" : ans;
    }
}