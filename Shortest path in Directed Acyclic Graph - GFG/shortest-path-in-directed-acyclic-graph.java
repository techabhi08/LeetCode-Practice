//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends

class Pair {
    int node;
    int weight;
    Pair(int node, int weight){
        this.node = node;
        this.weight = weight;
    }
}
//User function Template for Java
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
	List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < N; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
        }
        
        Stack<Integer> stack = new Stack<>();
        int[] vis = new int[N];
        for(int i = 0; i < N; i++){
            if(vis[i] == 0){
                findToposort(i, adj, stack, vis);
            }
        }
        
        int[] dist = new int[N];
        Arrays.fill(dist, (int)1e8);
        dist[0] = 0;
        
        while(!stack.isEmpty()){
            int top = stack.pop();
            
            for(Pair item : adj.get(top)){
                int nDist = item.weight;
                int node = item.node;
                
                if(nDist + dist[top] < dist[node]){
                    dist[node] = nDist + dist[top];
                }
            }
        }
        
        for(int i = 0; i < N; i++){
            if(dist[i] == (int)1e8){
                dist[i] = -1;
            }
        }
        
        return dist;
    }
    
    public void findToposort(int node, List<List<Pair>> adj, Stack<Integer> stack, int[] vis){
        vis[node] = 1;
        
        for(Pair item : adj.get(node)){
            if(vis[item.node] == 0){
                findToposort(item.node, adj, stack, vis);
            }
        }
        
        stack.add(node);
    }
}
