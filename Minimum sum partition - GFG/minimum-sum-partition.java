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
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    int sum = 0;
	    for(int num : arr){
	        sum += num;
	    }
	    
	    boolean[][] dp = new boolean[n][sum + 1];
	    for(int i = 0; i < n; i++){
	        dp[i][0] = true;
	    }
	    if(arr[0] <= sum){
	        dp[0][arr[0]] = true;
	    }
	    
	    for(int index = 1; index < n; index++){
	        for(int target = 1; target <= sum; target++){
	            boolean notTake = dp[index - 1][target];
	            boolean take = false;
	            if(arr[index] <= target){
	                take = dp[index - 1][target - arr[index]];
	            }
	            dp[index][target] = take || notTake;
	        }
	    }
	    
	    int min = (int)1e9;
	    
	    for(int i = 0; i <= sum / 2; i++){
	        if(dp[n - 1][i] == true){
	            min = Math.min(min, Math.abs((sum - i) - i));
	        }
	    }
	    return min;
	} 
}
