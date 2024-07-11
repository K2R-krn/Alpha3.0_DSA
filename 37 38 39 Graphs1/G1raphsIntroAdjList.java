import java.util.*;
import java.util.LinkedList;
public class G1raphsIntroAdjList {
    //!  1.  Creating Adjacency List and Basics of Graph
    //!  2.   B   F   S           O(V+E)
    //!  3.   D   F   S           O(V+E)
    //!  4.  Has  Path  ?         O(V+E)
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    //!  2.  Create Graph
    static void createGraph(ArrayList<Edge> graph[]){
        for(int i =0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));
        
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
    }

    //!  2    B   F   S                                  O(V+E) whichever more controls it basically O(n)
    public static void BFS(ArrayList<Edge>[] graph){
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];

        // we can take any source
        q.add(0);

        while(!q.isEmpty()){
            int curr = q.remove();

            if(!vis[curr]){ // visit curr
                System.out.print(curr+" ");
                vis[curr] = true;
                for(int i = 0;i<graph[curr].size();i++){ // Add neighbour in queue
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void BFSo(ArrayList<Edge>[] graph){
        Queue<Integer> q = new LinkedList<>();
        boolean v[] = new boolean[graph.length];

        q.add(0);
        while(!q.isEmpty()){
            int curr = q.remove();
            if(!v[curr]){
                System.out.print(curr+" ");
                v[curr] = true;
                for(int i=0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    //!  3     D   F   S     O(V+E)
    public static void DFS(ArrayList<Edge>[] graph, int curr, boolean visited[]){
        // 1 Visit Current
        System.out.print(curr+" ");

        visited[curr]= true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){ // check if neighbour was visited or no
                DFS(graph, e.dest, visited);
            }
        }
    }

    //!  4.  Has Path ?   O(V+E)
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean visited[]){
        // 1 If source is destination
        if(src == dest){
            return true;
        }
        visited[src] = true;
        // 2 can neighbour take us to destination ?
        for(int i = 0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);

            if(!visited[e.dest] && hasPath(graph, e.dest, dest, visited)){
                return true;
            }
        }
        return false;
   }

    public static void main(String args[]){
        
        // int V = 5;
        // //  Array ka DATA TYPE is ARRAYLIST OF TYPE EDGE so we have written it just like   int[] arr = new int[V];
        // ArrayList<Edge>[] graph = new ArrayList[V]; // Graph is array so square bracket before it and it is of size V
        // // now null is stored in arraylist it is not defined
        // // After we defined it above   Null is stored that means nothing in it it is UNDEFINED
        // //  So to make it an EMPTY arraylist we use below loop
        // for(int i = 0;i<V;i++){
        //     graph[i] = new ArrayList<>();
        // }

        // // now to store edges
        // //first for 0 vertex
        // graph[0].add(new Edge(0, 1, 5));

        // // 1 vertex
        // graph[1].add(new Edge(1, 0, 5));
        // graph[1].add(new Edge(1, 3, 3));
        // graph[1].add(new Edge(1, 2, 1));
        
        // //2 vertex
        // graph[2].add(new Edge(2, 1, 1));
        // graph[2].add(new Edge(2, 3, 1));
        // graph[2].add(new Edge(2, 4, 4));
    
        // // 3 vertex
        // graph[3].add(new Edge(3, 1, 3));
        // graph[3].add(new Edge(3, 2, 1));
        
        // // 4 vertex
        // graph[4].add(new Edge(4, 2, 2));

        // //  CREATED

        // // To store 2 s neighbours
        // for(int i = 0;i<graph[2].size();i++){
        //     Edge e = graph[2].get(i); // we get an edge that has s d w
        //     System.out.println(e.dest);
        // }
    //! 1 ------------------------------------------------------------------------------

        int v = 7;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
    
    
    //* 2 ----------------------------------------------------------------------------
        // BFS(graph);
    //! 2 ---------------------------------------------------------------------------
    
    
    //* 3 ----------------------------------------------------------------------------
        // DFS(graph, 0, new boolean[v]);
    //! 3 ----------------------------------------------------------------------------
       
    
    //* 4 ----------------------------------------------------------------------------
        System.out.println(hasPath(graph, 0, 5, new boolean[v]));
    //! 4-----------------------------------------------------------------------------
}

}
