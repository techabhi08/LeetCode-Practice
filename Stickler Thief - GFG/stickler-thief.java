//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        return findMax(n - 1, arr, dp);
    }
    
    public int findMax(int index, int[] arr, int[] dp){
        if(index == 0){
            return arr[index];
        }
        if(index < 0){
            return 0;
        }
        
        if(dp[index] != -1){
            return dp[index];
        }
        
        int pick = arr[index];
        if(index - 2 >= 0){
            pick += findMax(index - 2, arr, dp);
        }
        int notPick = 0 + findMax(index - 1, arr, dp);
        
        return dp[index] = Math.max(pick, notPick);
    }
}