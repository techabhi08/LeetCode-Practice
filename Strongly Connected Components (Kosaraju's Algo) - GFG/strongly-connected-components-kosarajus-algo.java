//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        int[] vis = new int[V];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                dfs(i, vis, adj, stack);
            }
        }
        
        List<List<Integer>> adjT = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adjT.add(new ArrayList<>());
        }
        
        for(int i = 0; i < V; i++){
            vis[i] = 0;
            for(int item : adj.get(i)){
                adjT.get(item).add(i);
            }
        }
        
        int ans = 0;
        while(!stack.isEmpty()){
            int curr = stack.pop();
            if(vis[curr] == 0){
                ans++;
                dfs2(curr, adjT, vis);
            }
        }
        return ans;
    }
    
    public static void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack){
        vis[node] = 1;
        for(int item : adj.get(node)){
            if(vis[item] == 0){
                dfs(item, vis, adj, stack);
            }
        }
        stack.push(node);
    }
    
    public static void dfs2(int node, List<List<Integer>> adj, int[] vis){
        vis[node] = 1;
        for(int item : adj.get(node)){
            if(vis[item] == 0){
                dfs2(item, adj, vis);
            }
        }
    }
}
