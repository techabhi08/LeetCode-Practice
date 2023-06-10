//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java
class DisjointSet{
    int[] size;
    int[] parent;
    
    DisjointSet(int n){
        size = new int[n];
        parent = new int[n];
        
        for(int i = 0; i < n; i++){
            size[i] = 1;
            parent[i] = i;
        }
    }
    
    public int findParent(int node){
        if(parent[node] == node){
            return node;
        }
        
        int ulp = findParent(parent[node]);
        parent[node] = ulp;
        return ulp;
    }
    
    public void union(int x, int y){
        x = findParent(x);
        y = findParent(y);
        
        if(x == y){
            return;
        }
        if(size[x] < size[y]){
            parent[x] = y;
            size[y] = size[y] + size[x];
        }else{
            parent[y] = x;
            size[x] = size[y] + size[x];
        }
    }
}

class Tuples{
    int u;
    int v;
    int wt;
    Tuples(int u, int v, int wt){
        this.u = u;
        this.v = v;
        this.wt = wt;
    }
}

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    DisjointSet ds = new DisjointSet(V);
	    
	    PriorityQueue<Tuples> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
	    
	    for(int[] edge : edges){
	        pq.add(new Tuples(edge[0], edge[1], edge[2]));
	    }
	    
	    int sum = 0;
	    
	    while(!pq.isEmpty()){
	        Tuples curr = pq.poll();
	        int u = curr.u;
	        int v = curr.v;
	        int wt = curr.wt;
	        
	        if(ds.findParent(u) == ds.findParent(v)){
	            continue;
	        }
	        
	        ds.union(u, v);
	        sum += wt;
	    }
	    return sum;
	}
}