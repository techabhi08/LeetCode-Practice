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
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
                
            }
            Solution obj=new Solution();
            int res=obj.minimumEnergy(arr,N);
            System.out.println(res);
            
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    public int minimumEnergy(int arr[],int N){
        //code here
        int[] dp = new int[N];
        Arrays.fill(dp, -1);
        int ans = findMin(0, arr, dp);
        return ans;
    }
    
    public int findMin(int index, int[] arr, int[] dp){
        if(index >= arr.length - 1){
            return 0; 
        }
        
        if(dp[index] != -1){
            return dp[index];
        }
        
        int plusOne = findMin(index + 1, arr, dp)+ Math.abs(arr[index] - arr[index + 1]);
        int plusTwo = Integer.MAX_VALUE;
        if(index < arr.length - 2){
            plusTwo = findMin(index + 2, arr, dp)+ Math.abs(arr[index] - arr[index + 2]);
        }
        
        return dp[index] = Math.min(plusOne, plusTwo);
    }
}