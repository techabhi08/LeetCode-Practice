class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for(int i = 0; i < s.length(); i += 2 * k){
            int left = i;
            int right = Math.min(i + k - 1, s.length() - 1);
             
            while(left < right){
                char temp = arr[left];
                arr[left++] = arr[right];
                arr[right--] = temp;
            }
        }
        return new String(arr);
    }
}