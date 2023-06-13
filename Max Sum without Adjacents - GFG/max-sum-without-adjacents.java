//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int findMaxSum(int arr[], int n) {
        // code here
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        return findMax(n - 1, arr, dp);
    }
    
    int findMax(int index, int[] arr, int[] dp){
        if(index < 0){
            return 0;
        }
        
        if(index == 0){
            return arr[index];
        }
        
        if(dp[index] != -1){
            return dp[index];
        }
        
        int sum = 0;
        int take = arr[index] + findMax(index - 2, arr, dp);
        int notTake = findMax(index - 1, arr, dp);
        
        sum += Math.max(take, notTake);
        
        return dp[index] = sum;
    }
}