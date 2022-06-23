class Solution {
    public int maxRepeating(String sequence, String word) {
        int ans = 0;
        StringBuilder s = new StringBuilder();
        s.append(word);
        while(sequence.contains(s)){
            ans++;
            s.append(word);
        }
        return ans;
    }
}
