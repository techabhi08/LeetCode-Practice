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
        return findMax(N - 1, 3, points, dp);
    }
    
    public int findMax(int index, int last, int[][] points, int[][] dp){
        if(index == 0){
            int max = 0;
            for(int i = 0; i <= 2; i++){
                if(i != last){
                    max = Math.max(max, points[index][i]);
                }
            }
            return max;
        }
        
        if(dp[index][last] != -1){
            return dp[index][last];
        }
        
        int maxi = 0;
        for(int i = 0; i <= 2; i++){
            if(i != last){
                int point = points[index][i] + findMax(index - 1, i, points, dp);
                maxi = Math.max(maxi, point);
            }
        }
        return dp[index][last] = maxi;
    }
}