class Solution {
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        
        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        }while(slow != fast);
        
        return slow == 1;
    }
    public int findSquare(int num){
        int ans = 0;
        while(num != 0){
            int rem = num % 10;
            ans += rem * rem;
            num /= 10;
        }
        
        return ans;
    }
}
