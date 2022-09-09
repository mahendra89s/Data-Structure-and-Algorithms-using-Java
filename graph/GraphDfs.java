import java.util.Iterator;
import java.util.LinkedList;

public class GraphDfs {
    private int V;
    private LinkedList<Integer> adj[];
    private boolean[] visited;
    GraphDfs(int v){
        V = v;
        adj = new LinkedList[V];
        visited = new boolean[V];
        for(int i = 0; i<v;i++){
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
    }

    public void DFS(int s){
    
        visited[s] = true;
        System.out.println(s);
        Iterator<Integer> it = adj[s].listIterator();
        while(it.hasNext()){
            int adj = it.next();
            if(!visited[adj]){
                DFS(adj);
            }
        }
    }

    public static void main(String args[]){
        GraphDfs g = new GraphDfs(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
    

        g.DFS(0);
    }
}
