class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String ans = "";
        if(!(str1 + str2).equals(str2 + str1)){
            return ans;
        }
        
        int len1 = str1.length();
        int len2 = str2.length();
        
        int gcd = findGCD(len1, len2);
        return str1.substring(0, gcd);
    }
    
    public int findGCD(int a, int b){
        if(b == 0){
            return a;
        }
        return findGCD(b, a % b);
    }
}
