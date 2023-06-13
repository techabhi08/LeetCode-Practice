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
        // int[] dp = new int[n];
        // dp[0] = arr[0];
        int prev2 = 0;
        int prev = arr[0];
        
        for(int index = 1; index < n; index++){
            int pick = arr[index];
            if(index - 2 >= 0){
                pick += prev2;
            }
            int notPick = 0 + prev;
            
            int curr = Math.max(pick, notPick);
            prev2 = prev;
            prev = curr;
        }
        
        return prev;
    }
}