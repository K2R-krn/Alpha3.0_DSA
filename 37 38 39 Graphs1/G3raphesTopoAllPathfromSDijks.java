import java.util.*;
import java.util.LinkedList;

//!   1.  Topological Sorting ( USING DFS )                     O( V+E )     sc = O(V)
//!   2.  Topological Sorting ( USING BFS ) ( KAHNs ALGO )      O( V+E )     sc = O(V)
//!   3.  All Paths from Source to Target



public class G3raphesTopoAllPathfromSDijks {

    static class Edge{
        int src;
        int dest;
        
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    //!   1.  Topological Sorting ( USING DFS )                     O( V+E )     sc = O(V)
    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        graph[2].add(new Edge(2, 3));   
        
        graph[3].add(new Edge(3, 1));   

        graph[4].add(new Edge(4, 0));   
        graph[4].add(new Edge(4, 1));   
        
        graph[5].add(new Edge(5, 0));   
        graph[5].add(new Edge(5, 2));   
    }
    public static void topSortDFS(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i=0;i<graph.length;i++){  // loop so that all the elements can be covered
            // if any node unvisited call DFS
            if(!vis[i]){ 
                topSortDFSUtil(graph, i, vis, s); // modified dfs
            }
        }
        //  Print it
        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
    }
    public static void topSortDFSUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], Stack<Integer> s){
        //  As we need to perform modified dfs  accordingly we go first step of dfs is as follows
        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            // now e.dest is neighbout
            if(!vis[e.dest]){
                topSortDFSUtil(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    //!   2.  Topological Sorting ( USING BFS ) ( KAHNs ALGO )      O( V+E )     sc = O(V)
    public static void topSortBFSKahn(ArrayList<Edge>[] graph){
        int indeg[] = new int[graph.length];
        calcIndegree(graph, indeg);
        Queue<Integer> q = new LinkedList<>();

        // nodes whose ind is 0 add in queue 
        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }

        // BFS
        while(!q.isEmpty()){ // till queue is empty

            int curr = q.remove();  //  remove element from queue
            System.out.print(curr+" "); // now add it in topo sort that is print current 
            
            for(int i=0;i<graph[curr].size();i++){ // check for neighbours // current ke neighbopur ke liye indeg -1
                Edge e = graph[curr].get(i);
                indeg[e.dest]--; 
                if(indeg[e.dest]==0){   // kam hone ke baad if 0 add it in queue
                    q.add(e.dest);
                }
            }
        }
    }
        // Fn to calc Indegree for graph
    public static void calcIndegree(ArrayList<Edge>[] graph, int indeg[]){
        for(int i=0;i<graph.length;i++){
            int vertex = i; // if i am at any vertex i am trying to find all edges
            for(int j=0;j<graph[vertex].size();j++){
                Edge e = graph[vertex].get(j);
                indeg[e.dest]++;
            }
        }
    } 

    public static void main(String args[]){
        //!   1.  Topological Sorting ( USING DFS )      O( V+E )     sc = O(V)
        // int v = 6;
        // ArrayList<Edge>[] graph = new ArrayList[v];
        // createGraph(graph);
        // topSortDFS(graph);

        //!   2.  Topological Sorting ( USING BFS ) ( KAHNs ALGO )      O( V+E )     sc = O(V)
        // int v = 6;
        // ArrayList<Edge>[] graph = new ArrayList[v];
        // createGraph(graph);
        // topSortBFSKahn(graph);

        System.out.println(count(3));
    }
    static long count(int n) {
        int noOfEdges = n*(n-1)/2;
        long ans = (long)Math.pow(2, noOfEdges);
        return ans;
    }
}
