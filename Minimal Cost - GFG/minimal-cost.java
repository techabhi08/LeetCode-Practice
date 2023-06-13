//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int K=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
            }
            Solution obj=new Solution();
            int res=obj.minimizeCost(arr,N,K);
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int minimizeCost(int arr[],int N,int K){
        //code here
        int[] dp = new int[N];
        Arrays.fill(dp, - 1);
        return findMin(N - 1, arr, K, dp);
    }
    
    public int findMin(int index, int[] arr, int k, int[] dp){
        if(index == 0){
            return 0;
        }
        
        if(dp[index] != -1){
            return dp[index];
        }
        
        int step = Integer.MAX_VALUE;
        for(int i = 1; i <= k; i++){
            if(index - i >= 0){
                step = Math.min(step, findMin(index - i, arr, k, dp) + Math.abs(arr[index] - arr[index - i]));
            }
        }
        
        return dp[index] = step;
    }
}
