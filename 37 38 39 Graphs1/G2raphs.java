import java.util.*;
import java.util.LinkedList;

//!  B F S  Divided in two to also traveerse disjoint sets 
//!  D F S  Divided in two to also traveerse disjoint sets 

//!  1.  Detect Cycle ( For Undirected Graph)    O ( V+H )
//!  2.  Bipartite Graph                         O ( V+H )
//!  3.  Detect Cycle ( DIRECTED Graph )         O ( V+H )


public class G2raphs {
    static class Edge{
        int src;
        int dest;
        // int wt;
        public Edge(int s, int d/*  ,int w  */){
            this.src = s;
            this.dest = d;
            // this.wt = w;
        }
    }

    //!  B F S  Divided in two to also traveerse disjoint sets 
    public static void bfs(ArrayList<Edge>[] graph){
        boolean visited[] = new boolean[graph.length];
        for(int i = 0;i<graph.length;i++){
            if(!visited[i]){
                BFSUtil(graph, visited);
            }
        }
    }
    public static void BFSUtil(ArrayList<Edge>[] graph, boolean visited[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while(!q.isEmpty()){
            int curr = q.remove();
            if(!visited[curr]){
                System.out.print(curr+" ");
                visited[curr] = true;
                for(int i=0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    //!  D F S  Divided in two to also traveerse disjoint sets 
    public static void dfs(ArrayList<Edge>[] graph){
        boolean visited[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            DFSUtil(graph, i, visited);
        }
    }
    public static void DFSUtil(ArrayList<Edge>[] graph, int curr, boolean visited[]){
        System.out.print(curr+" ");
        visited[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                DFSUtil(graph, e.dest, visited);
            }
        }
    }

    //!  Graph
    static void createGraph(ArrayList<Edge>[] graph){
        for(int i = 0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        // graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        // graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
    
    }

    //!  1.  Detect Cycle ( For Undirected Graph)    O(V+H)
    public static boolean isCycleUD(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];

        for(int i = 0;i<graph.length;i++){
            // check if node not visited then visit 
            if(!vis[i]){
                if(isCycleUDUtil(graph, vis, i, -1)){
                    return true;
                    // means cycle exists in one of the part
                }
            }
        }

        return false; 
    }
    public static boolean isCycleUDUtil(ArrayList<Edge>[] graph, boolean vis[], int curr, int parent){
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);

            // Case 1   When not visited node so agaion DFS called
            if(!vis[e.dest]){
                if(isCycleUDUtil(graph,vis,e.dest,curr)){
                    return true;
                }
            }

            // Case 2   If neighbour is also visited and neighbour is not parent then cycle always exist
            else if(vis[e.dest] && e.dest !=parent){
                return true;
            }

            // Case 3  If neighbour visited and it is parent -> Do nothing... continue
        } 

        return false;
    }


    //!  2.  Bipartite Graph                         O ( V+H )
    public static void createGraph2(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        // graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        // graph[4].add(new Edge(4, 3));
    } 

    public static boolean isBipartite(ArrayList<Edge>[] graph){
        // Initially create a color array which is initialized by -1
        int col[] = new int[graph.length];
        for(int i=0;i<col.length;i++){
            col[i] = -1;
        }

        //  If graph divided in multiple parts we need a loop which we run in this only
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<graph.length;i++){
            if(col[i]==-1){  // Color not given to node
                // perform bfs
                q.add(i);
                col[i]=0; // yellow
                while(!q.isEmpty()){
                    int curr = q.remove();
                    // check for neighbours
                    for(int j=0;j<graph[curr].size();j++){
                        Edge e = graph[curr].get(j); // neighbour is e.dest e ka destination is my neighbour
                        //  Now check 3 cases for neighbour
                        //&  1.  No color for neighbor
                        if(col[e.dest]==-1){
                            int nextCol = col[curr]==0 ? 1 : 0; // If current color is 0 assign to next 1 else assign 0
                            col[e.dest]= nextCol;
                            q.add(e.dest);
                        }
                        //&  2.  Neighbour has color but same color
                        else if(col[e.dest]== col[curr]){
                            return false; // Graph not bipartite
                        }

                    }
                }

            }
                
        }
        return true;
    }


    //!  3.  Detect Cycle ( DIRECTED Graph )         O ( V+H )
    public static void createGraph3(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
    }

    //  THIS FN CHECK S FOR UNVISITED NODES AND IF ANY UNVISITED FOUND With help of DFS Check it if cycle exists or no
    public static boolean isCycleD(ArrayList<Edge>[] graph){
        // Create 2 arrays
        boolean visited[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                if(isCycleDUtil(graph, i, visited, stack)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleDUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], boolean stack[]){
        // Same as DFS but one change that stack is also used here
        vis[curr]= true;
        stack[curr]= true;

        //  Check for neighbour, C1 if it exists in stack there is cycle or  C2  if neighbour is unvisited call fn again
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            // C1
            if(stack[e.dest]){ // if current stack me already neighbour exist then cycle exist 
                return true;
            }
            // C2 Unvisited 
            if(!vis[e.dest] && isCycleDUtil(graph, e.dest, vis, stack)){ // node not vidsited call isCyc Util recn step
                return true;
            }
        }
        stack[curr] = false;  // step to remove current from stack because recn me call waapas jaati tab stack se node hat jaati
        return false;
    }
    public static void main(String args[]){
        //!  1.  Detect Cycle ( For Undirected Graph)    O ( V+H )
        /*
                0 ------ 3
               /|        |   
              / |        | 
             1  |        4
              \ |
               \|
                2
         */
        
        // int v = 5;
        // ArrayList<Edge>[] graph = new ArrayList[v];
        // createGraph(graph);

        // System.out.println(isCycleUD(graph));


        //!  2.  Bipartite Graph                         O ( V+H )
        /*
               0 ------ 2 
              /          \
             /            \  
            1              4
             \            /  
              \          /   
               \        /         
                \      /
                 \    /
                    3  
        */
        // int v = 5;
        // ArrayList<Edge>[] graph = new ArrayList[v];
        // createGraph2(graph);
        // System.out.println(isBipartite(graph));


        //!  3.  Detect Cycle ( DIRECTED Graph )         O ( V+H )
        int v = 4;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        System.out.println(isCycleD(graph));
}
}
