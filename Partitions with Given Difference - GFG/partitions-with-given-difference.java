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
            int n=sc.nextInt();
            int d=sc.nextInt();
            
            int []arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            
            Solution obj=new Solution();
            int res=obj.countPartitions(n, d, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//Back-end complete function Template for Java

class Solution{
    int mod = (int)1e9 + 7;
    public int countPartitions(int n, int d, int arr[]){
        // Code here
        int sum = 0;
        for(int num : arr){
            sum += num;
        }
        
        if(sum - d < 0 || (sum - d) % 2 != 0){
            return 0;
        }
        
        int target = (sum - d) / 2;
        int[][] dp = new int[n][target + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return findSum(n - 1, target, arr, dp);
    }
    
    public int findSum(int index, int sum, int[] arr, int[][] dp){
        if(index == 0){
            if(sum == 0 && arr[0] == 0) return 2;
            if(sum == 0 || arr[0] == sum) return 1;
            return 0;
        }
        
        if(dp[index][sum] != -1){
            return dp[index][sum];
        }
        
        int notTake = findSum(index - 1, sum, arr, dp);
        int take = 0;
        if(arr[index] <= sum){
            take = findSum(index - 1, sum - arr[index], arr, dp);
        }
        
        return dp[index][sum] = (take + notTake) % mod;
    }
}