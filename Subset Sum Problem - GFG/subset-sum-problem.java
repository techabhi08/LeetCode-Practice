//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        int[][] dp = new int[N][sum + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return findSubset(N - 1, sum, arr, dp);
    }
    
    static boolean findSubset(int index, int sum, int[] arr, int[][] dp){
        if(sum == 0){
            return true;
        }
        if(index == 0){
            return arr[0] == sum;
        }
        
        if(dp[index][sum] != -1){
            return dp[index][sum] == 1 ? true : false;
        }
        
        boolean notTake = findSubset(index - 1, sum, arr, dp);
        boolean take = false;
        if(arr[index] <= sum){
            take = findSubset(index - 1, sum - arr[index], arr, dp);
        }
        
        dp[index][sum] = (notTake || take) ? 1 : 0;
        return take || notTake;
    }
}