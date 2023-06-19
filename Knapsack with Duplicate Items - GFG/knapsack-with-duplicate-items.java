//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        int[][] dp = new int[N][W + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return findMax(N - 1, W, val, wt, dp);
    }
    
    public static int findMax(int index, int weight, int[] val, int[] wt, int[][] dp){
        if(weight == 0){
            return 0;
        }
        
        if(index == 0){
            return wt[0] <= weight ? (weight / wt[0]) * val[index] : 0;
        }
        
        if(dp[index][weight] != -1){
            return dp[index][weight];
        }
        
        int notTake = findMax(index - 1, weight, val, wt, dp);
        int take = Integer.MIN_VALUE;
        if(wt[index] <= weight){
            take = val[index] + findMax(index, weight - wt[index], val, wt, dp);
        }
        
        return dp[index][weight] = Math.max(take, notTake);
    }
}