//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int[][] dp = new int[n][n + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return findMax(n - 1, n, price, dp);
    }
    
    public int findMax(int index, int pieces, int[] price, int[][] dp){
        if(index == 0){
            return pieces >= index + 1 ? (pieces / (index + 1)) * price[index] : 0;
        }
        
        if(dp[index][pieces] != -1){
            return dp[index][pieces];
        }
        
        int notTake = findMax(index - 1, pieces, price, dp);
        int take = Integer.MIN_VALUE;
        if(index + 1 <= pieces){
            take = price[index] + findMax(index, pieces - index - 1, price, dp);
        }
        
        return dp[index][pieces] = Math.max(take, notTake);
    }
}