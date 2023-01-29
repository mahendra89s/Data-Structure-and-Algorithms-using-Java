import java.util.*;
//User function Template for Java
class Pair implements Comparable<Pair>{
    int v;
    int wt;
    Pair(int v, int wt){
        this.v = v;
        this.wt = wt;
    }
    
    public int compareTo(Pair that){
        return this.wt - that.wt;
    }
}

class Dijkstra
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        boolean[] visited = new boolean[V];
        int[] ans = new int[V];
        Arrays.fill(ans,1000000);
        
        ans[S] = 0;
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(S,0));
        
        while(!q.isEmpty()){
            Pair curr = q.poll();
            
            int u = curr.v;
            if(visited[u]){
                continue;
            }
            
            
            visited[u] = true;
            
            ArrayList<ArrayList<Integer>> neighbor = adj.get(u);
            for(ArrayList<Integer> list : neighbor){
                int vertex = list.get(0);
                int weight = list.get(1);
                if(ans[vertex] > ans[u]+weight){
                    ans[vertex] = ans[u]+weight;
                    q.add(new Pair(vertex,ans[vertex]));
                }
            }
            
        }
        return ans;
    }
}

