//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{
    int mod = (int)1e9 + 7;
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    int[][] dp = new int[n][sum + 1];
	    for(int[] row : dp){
	        Arrays.fill(row, -1);
	    }
	    return findCount(n - 1, sum, arr, dp);
	} 
	
	public int findCount(int index, int sum, int[] arr, int[][] dp){
	    if(index == 0){
	        if(sum == 0 && arr[0] == 0) return 2;
	        if(sum == 0 || arr[0] == sum) return 1;
	        return 0;
	    }
	    
	    if(dp[index][sum] != -1){
	        return dp[index][sum];
	    }
	    
	    int notTake = findCount(index - 1, sum, arr, dp);
	    int take = 0;
	    if(arr[index] <= sum){
	        take = findCount(index - 1, sum - arr[index], arr, dp);
	    }
	    
	    return dp[index][sum] = (take + notTake) % mod;
	}
}