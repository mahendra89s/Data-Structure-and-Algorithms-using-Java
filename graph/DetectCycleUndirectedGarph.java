import java.util.*;
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        
        for(int i = 0;i<V;i++){
            if(!visited[i]){
                if(dfs(i,adj,visited,-1)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(int v, ArrayList<ArrayList<Integer>> adj,boolean[] visited,int parent){
        visited[v] = true;
        
        for(int neighbor:adj.get(v)){
            if(!visited[neighbor]){
                if(dfs(neighbor,adj,visited,v)){
                    return true;
                }
            }
            else if(neighbor != parent){
                return true;
            }
        }
        return false;
    }
}