import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    int  v ;
    ArrayList<ArrayList<Integer>> adj;
    Graph(int v){
        this.v=v;
        adj=new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
    }
    void addEdge(int u,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    void display(){
        for(int i=0;i<v;i++){
            System.out.println(i+"-->"+adj.get(i));
        }
    }
    void DFS(int start,boolean[] vis){
       
        vis[start]=true;
        System.out.println(start);
        for(int nei : adj.get(start)){
            if(!vis[nei]){
                DFS(nei,vis);
            }
        }
    }
    void BFS(int start){
        boolean vis[] = new boolean[v];
        Queue<Integer> q = new LinkedList<>();
        vis[start]=true;
        q.add(start);
        while(!q.isEmpty()){
            int val = q.poll();
            System.out.println(val);
            for(int nei : adj.get(val)){
                if(!vis[nei]){
                    vis[nei]=true;
                    q.add(nei);
                }
            }
        }
    }
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 4);

        g.display();
        System.out.println("BFS");
        g.BFS(0);
        System.out.println("DFS");
        boolean[] vis = new boolean[g.v];
        g.DFS(0,vis);
    }
}
