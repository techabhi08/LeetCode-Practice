class Solution {
    public char findTheDifference(String s, String t) {
        int sum = 0;
        for(char c : t.toCharArray()){
            sum += c;
            System.out.println(sum);
        }
        for(char c : s.toCharArray()){
            sum -= c;
        }
        return (char)sum;
    }
}
