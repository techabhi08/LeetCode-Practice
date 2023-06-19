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
        int[] prev = new int[W + 1];
        for(int i = 0; i <= W; i++){
            prev[i] = i <= W ? (i / wt[0]) * val[0] : 0;
        }
        
        int[] curr = new int[W + 1];
        
        for(int index = 1; index < N; index++){
            for(int weight = 0; weight <= W; weight++){
                int notTake = prev[weight];
                int take = Integer.MIN_VALUE;
                if(wt[index] <= weight){
                    take = val[index] + curr[weight - wt[index]];
                }
                
                curr[weight] = Math.max(take, notTake);
            }
            prev = curr;
        }
        
        return prev[W];
    }
}