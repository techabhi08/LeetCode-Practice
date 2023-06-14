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
            int [][]points=new int[N][3];
            for(int i=0;i<N;i++){
                for(int j=0;j<3;j++){
                    points[i][j]=sc.nextInt();
                }
            }
            Solution obj=new Solution();
            int res=obj.maximumPoints(points,N);
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int maximumPoints(int points[][],int N){
        //code here
        int[][] dp = new int[N][4];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
        
        for(int index = 1; index < N; index++){
            for(int last = 0; last <= 3; last++){
                dp[index][last] = 0;
                for(int i = 0; i <= 2; i++){
                    if(i != last){
                        int point = points[index][i] + dp[index - 1][i];
                        dp[index][last] = Math.max(dp[index][last], point);
                    }
                }
            }
        }
        
        return dp[N - 1][3];
    }
}